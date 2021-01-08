package com.fapiao.layui.controller;

import com.fapiao.layui.model.User;
import net.sf.json.JSONObject;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.DateFormat;
import java.util.*;

/**
 * @author zhang-rongyao
 * @version V 1.0
 * @Package com.fapiao.layui.controller
 * @date 2021/1/5/005 17:06
 */
@RestController
public class DemoController {

    @GetMapping("ssss")
    public User aaa(Model model) {
        User user = new User("zhang", "sss");
        return user;
    }

    @GetMapping("/getDetail")
    public JSONObject getDetail(Locale locale, Model model) {

        HashMap<String, Object> hashMap = new HashMap<>();
        ArrayList<Object> contentArrayList = new ArrayList<>();
        ArrayList<Object> valueArrayList = new ArrayList<>();

        Map<String, String> done = new HashMap<>();
        done.put("name", "done");
        done.put("display", "结果");
        done.put("type", "select");
        JSONObject doneJsonObject = JSONObject.fromObject(done);

        Map<String, String> id = new HashMap<>();
        id.put("name", "id");
        id.put("searchable", "");
        JSONObject idJsonObject = JSONObject.fromObject(id);

        Map<String, String> xx = new HashMap<>();
        xx.put("aa", "aaaa");
        xx.put("bb", "bbbb");
        JSONObject xxJsonObject = JSONObject.fromObject(xx);

        Map<String, Object> con = new HashMap<>();
        con.put("done", doneJsonObject);
        con.put("id", idJsonObject);
        con.put("xx", xxJsonObject);
        JSONObject conJsonObject = JSONObject.fromObject(con);
        contentArrayList.add(conJsonObject);

        Map<String, String> done1 = new HashMap<>();
        done1.put("name", "done222");
        done1.put("display", "结果222");
        done1.put("type", "select");
        JSONObject doneJsonObject1 = JSONObject.fromObject(done1);

        Map<String, String> id1 = new HashMap<>();
        id1.put("name", "id");
        id1.put("searchable", "");
        JSONObject idJsonObject1 = JSONObject.fromObject(id1);

        Map<String, String> xx1 = new HashMap<>();
        xx1.put("aa", "aaaa");
        xx1.put("bb", "bbbb");
        JSONObject xxJsonObject1 = JSONObject.fromObject(xx1);

        Map<String, Object> con1 = new HashMap<>();
        con1.put("done", doneJsonObject1);
        con1.put("id", idJsonObject1);
        con1.put("xx", xxJsonObject1);
        JSONObject conJsonObject1 = JSONObject.fromObject(con1);
        contentArrayList.add(conJsonObject1);

        Map<String, Object> val = new HashMap<>();
        val.put("done", true);
        val.put("id", "111222000333");
        val.put("factory", "OCR");
        JSONObject valJsonObject = JSONObject.fromObject(val);
        valueArrayList.add(valJsonObject);

        hashMap.put("content", contentArrayList);
        hashMap.put("values", valueArrayList);
        JSONObject jsonObject = JSONObject.fromObject(hashMap);

        System.out.println(jsonObject);

        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
        String formattedDate = dateFormat.format(date);
        model.addAttribute("currentTime", formattedDate);

        return  jsonObject;
    }
}
