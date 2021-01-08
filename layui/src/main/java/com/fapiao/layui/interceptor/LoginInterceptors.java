package com.fapiao.layui.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;
import java.util.Map;

/**
 * @author zhang-rongyao
 * @version V 1.0
 * @Package com.fapiao.layui.interceptor
 * @date 2021/1/6/006 10:45
 */
@Slf4j
@Component
public class LoginInterceptors implements HandlerInterceptor {

    /**
     * 在调用controller之前调用
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String path = request.getRequestURI();
        String ip = getIpAddr(request);
        String url = path.substring(path.lastIndexOf("/") + 1, path.length());
        log.info("请求的url是--->" + url + ";请求方式为--->" + request.getMethod() + ";客户端的IP地址：" + ip);

        Enumeration<?> paraNames = request.getParameterNames();
        while (paraNames.hasMoreElements()) {
            String paraName = (String) paraNames.nextElement();
            String paraStrval = request.getParameter(paraName);
            if (paraStrval.length() < 5000){
                log.info("---paraName---" + paraName + "---paraStrval---" + paraStrval);
                if (StringUtils.isNotBlank(paraStrval)) {
                    paraStrval = paraStrval.toLowerCase();
                    for (String filter : filterStr) {
                        if (paraStrval.indexOf(filter) != -1) {
                            log.info("本次请求包含特殊字符，拒绝本次请求，参数内容：" + paraStrval);
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    /**
     * 方法在controller被调用之后调用，可在modelAndView中加入数据
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.debug("Controller请求处理后===");

        /**
         * 该方法生效条件：不能使用@ResponseBody注解，@ResponseBody注解会提前返回
         * 统一处理返回值可以使用：className implements ResponseBodyAdvice{
         *     @Override
         *     public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
         *
         *         System.out.println("TestResponseBodyAdvice==>beforeBodyWrite:" + o.toString() + ","
         *                 + methodParameter);
         *         return o;
         *     }
         *
         *     @Override
         *     public boolean supports(MethodParameter methodParameter, Class aClass) {
         *         return true;
         *     }
         * }
         */
        if (modelAndView != null) {
            ModelMap map = modelAndView.getModelMap();
            if (map != null && map.get("values") != null){
                log.info("请求返回结果代码--->" + map.get("values") + ";请求返回消息--->" + map.get("msg"));}
        }
    }

    /**
     * 在呈现视图之后调用，可用于清理资源等
      * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    }


    /**
     * 获取ip地址
     * @param request
     * @return
     */
    public String getIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("X-Forwarded-For");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }

    private static String[] filterStr = { "script", "document", "eval", "alert", "$(", "$.","<img","<",">","\"","\'","confirm" };
}
