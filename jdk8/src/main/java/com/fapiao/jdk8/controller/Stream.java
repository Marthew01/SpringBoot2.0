package com.fapiao.jdk8.controller;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.text.SimpleDateFormat;

/**
 * @author zhang-rongyao
 * @version V 1.0
 * @Package com.fapiao.jdk8.controller
 * @date 2020/12/31/031 14:31
 */
public class Stream {

    public static void main(String[] args) {

        String str="{\"code\":\"0000\",\"listData\":[{\"PRINT_LOG_ID\":\"15000352888833360061\",\"OPER_TYPE\":2,\"PROJECT_NAME\":\"黑色加碳锻造生铁\",\"PRINT_FEE\":-1261.930000000000000000,\"PRINT_TIME\":1609124868000,\"WRITE_MANAGER\":\"小强\",\"CHECK_MANAGER\":\"\",\"RECE_FEE_MANAGER\":\"\",\"BUYER_TAXPAYER_ID\":\"\",\"BUYER_NAME\":\"wan\",\"SELLER_NAME\":\"百旺电子测试1\",\"PROVINCE_CODE\":\"51\"},{\"PRINT_LOG_ID\":\"15200018635730403698\",\"OPER_TYPE\":2,\"PROJECT_NAME\":\"技术服务\",\"PRINT_FEE\":-624.140000000000000000,\"PRINT_TIME\":1609124709000,\"WRITE_MANAGER\":\"王柏\",\"CHECK_MANAGER\":\"\",\"RECE_FEE_MANAGER\":\"\",\"BUYER_TAXPAYER_ID\":\"\",\"BUYER_NAME\":\"wan\",\"SELLER_NAME\":\"百旺电子测试2\",\"PROVINCE_CODE\":\"51\"},{\"PRINT_LOG_ID\":\"15000352888833360060\",\"OPER_TYPE\":2,\"PROJECT_NAME\":\"金矿钻石\",\"PRINT_FEE\":-724.560000000000000000,\"PRINT_TIME\":1609124638000,\"WRITE_MANAGER\":\"小强\",\"CHECK_MANAGER\":\"\",\"RECE_FEE_MANAGER\":\"\",\"BUYER_TAXPAYER_ID\":\"\",\"BUYER_NAME\":\"wan\",\"SELLER_NAME\":\"百旺电子测试1\",\"PROVINCE_CODE\":\"51\"},{\"PRINT_LOG_ID\":\"15200018635730854048\",\"OPER_TYPE\":2,\"PROJECT_NAME\":\"技术服务\",\"PRINT_FEE\":-624.140000000000000000,\"PRINT_TIME\":1609124449000,\"WRITE_MANAGER\":\"王柏\",\"CHECK_MANAGER\":\"万\",\"RECE_FEE_MANAGER\":\"万\",\"BUYER_TAXPAYER_ID\":\"WANDW123456789999999\",\"BUYER_NAME\":\"测试2\",\"SELLER_NAME\":\"百旺电子测试2\",\"PROVINCE_CODE\":\"51\"},{\"PRINT_LOG_ID\":\"15000352888833300114\",\"OPER_TYPE\":2,\"PROJECT_NAME\":\"黑色加碳锻造生铁\",\"PRINT_FEE\":-1257.480000000000000000,\"PRINT_TIME\":1609120534000,\"WRITE_MANAGER\":\"小强\",\"CHECK_MANAGER\":\"\",\"RECE_FEE_MANAGER\":\"\",\"BUYER_TAXPAYER_ID\":\"\",\"BUYER_NAME\":\"wan\",\"SELLER_NAME\":\"百旺电子测试1\",\"PROVINCE_CODE\":\"51\"},{\"PRINT_LOG_ID\":\"15200018635730849828\",\"OPER_TYPE\":2,\"PROJECT_NAME\":\"短信和彩信服务\",\"PRINT_FEE\":-9.430000000000000000,\"PRINT_TIME\":1609055080000,\"WRITE_MANAGER\":\"王柏\",\"CHECK_MANAGER\":\"\",\"RECE_FEE_MANAGER\":\"\",\"BUYER_TAXPAYER_ID\":\"\",\"BUYER_NAME\":\"万\",\"SELLER_NAME\":\"百旺电子测试2\",\"PROVINCE_CODE\":\"51\"},{\"PRINT_LOG_ID\":\"15000352888833360096\",\"OPER_TYPE\":2,\"PROJECT_NAME\":\"黑色加碳锻造生铁\",\"PRINT_FEE\":-1341.640000000000000000,\"PRINT_TIME\":1608973424000,\"WRITE_MANAGER\":\"小强\",\"CHECK_MANAGER\":\"\",\"RECE_FEE_MANAGER\":\"\",\"BUYER_TAXPAYER_ID\":\"\",\"BUYER_NAME\":\"wan\",\"SELLER_NAME\":\"百旺电子测试1\",\"PROVINCE_CODE\":\"51\"},{\"PRINT_LOG_ID\":\"15200018635730403699\",\"OPER_TYPE\":1,\"PROJECT_NAME\":\"技术服务\",\"PRINT_FEE\":716.590000000000000000,\"PRINT_TIME\":1608801964000,\"WRITE_MANAGER\":\"王柏\",\"CHECK_MANAGER\":\"\",\"RECE_FEE_MANAGER\":\"\",\"BUYER_TAXPAYER_ID\":\"\",\"BUYER_NAME\":\"wan2\",\"SELLER_NAME\":\"百旺电子测试2\",\"PROVINCE_CODE\":\"51\"}],\"msg\":\"获取成功\"}";

        JSONObject jsonObject = JSONObject.fromObject(str);
        JSONArray jsonArray = jsonObject.getJSONArray("listData");
        /*for(int i=0; i<listData.size(); i++){
            JSONObject obj = (JSONObject) listData.get(i);
            Iterator it = obj.keys();
            while (it.hasNext()) {
                String key = String.valueOf(it.next());
                System.out.println("key ----- "+key);
                System.out.println("value ----- "+obj.get(key));
            }
        }*/

       /* Object collect = jsonArray.stream()
                .map(obj -> JSONObject.fromObject(obj))
                .forEach(a)
                .collect(Collectors.toList());
        System.out.println(collect.toString());

*/
        //list里存放map
        /*ArrayList<String> arrayList = new ArrayList<>();
        for (Object json : jsonArray){
            StringBuffer stringBuffer=new StringBuffer();
            if (json instanceof JSONObject){
                //json转化为map
                Map<String, Object> map =new HashMap<>();
                Iterator it =JSONObject.fromObject(json).entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry<String, Object> entry = (Map.Entry<String, Object>) it.next();
                    map.put(entry.getKey(), entry.getValue());
                }

                map.entrySet().stream()
                        .filter(entry -> StringUtils.hasText(entry.getKey()))
                        .forEach(entry -> stringBuffer.append(entry.getValue()).append("|"));
                arrayList.add(String.valueOf(stringBuffer));
            }
        }
        System.out.println(arrayList);*/

        StringBuffer stringBuffer=new StringBuffer();
        jsonArray.stream()
                .forEach((entry) ->{
                    JSONObject json=JSONObject.fromObject(entry);
                     json.keySet().forEach((key) ->
                     {
                         switch(String.valueOf(key)){
                             case "PRINT_TIME" :
                                 stringBuffer.append(new SimpleDateFormat("yyyyMMddHHmmss").format(json.get(key))).append("|");
                                 break;
                             case "PROVINCE_CODE" :
                                 stringBuffer.append(json.get(key));
                                 break;
                             default :
                                 stringBuffer.append(json.get(key)).append("|");
                         }
                     });
                    stringBuffer.append("\r\n");
                    }
                );
        System.out.println(stringBuffer);
        System.out.println(stringBuffer);
    }


}
