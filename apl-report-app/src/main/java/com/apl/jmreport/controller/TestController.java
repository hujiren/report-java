package com.apl.jmreport.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * @author hjr start
 * @Classname TestController
 * @Date 2021/1/22 16:04
 */
@RestController
@RequestMapping("/jimu-report")
public class TestController {

    @GetMapping("/get-school")
    public JSONObject getSchool(HttpServletRequest request){

        String token = request.getParameter("token");

        System.out.println(token);


        School school = new School();
        school.setSchoolName("深圳大学");
        school.setMechanicalProperty("民办");
        school.setType("大学");

        List<School> schoolList = new ArrayList<>();
        schoolList.add(school);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("data", schoolList);
        return jsonObject;
    }

    @GetMapping("/get-student")
    public JSONObject getStudent(){

        //http://localhost:8085/jeecg-boot/jimu-report/get-student
        Student student = new Student();
        student.setAddress("广东省深圳市");
        student.setAge(55);
        student.setGender("男");
        student.setName("马云");

        Student student2 = new Student();
        student2.setAddress("广东省深圳市");
        student2.setAge(3);
        student2.setGender("男");
        student2.setName("davi");

        Student student3 = new Student();
        student3.setAddress("广东省深圳市");
        student3.setAge(2);
        student3.setGender("男");
        student3.setName("jack");

        Student student4 = new Student();
        student4.setAddress("广东省深圳市");
        student4.setAge(1);
        student4.setGender("男");
        student4.setName("arran");

        List<Student> studentList = new ArrayList<>();
        studentList.add(student);
        studentList.add(student2);
        studentList.add(student3);
        studentList.add(student4);

        //int pageSize = 10;
        //int total = studentList.size();

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("data", studentList);
        //jsonObject.put("size", pageSize);
        //jsonObject.put("total", total);
        //jsonObject.put("count", total);

        return jsonObject;
    }

    @GetMapping(value = "/get-waybill")
    public String getWaybill(){
        //http://localhost:8085/report/jmreport/list
        //http://192.168.1.118:9173/lms-waybill/waybill/print-waybill-commodity?waybillId=512067031077421056&token=pgs_pgs_100_6130e5b9ce814105b288b96ad784bd75

        //http://localhost:8085/jeecg-boot/jimu-report/get-waybill
        //http://192.168.1.118:9173/lms-waybill/waybill/print-waybill-basic?waybillId='${waybillId}'&token='${token}'
        //?waybillId=512067031077421056&token=pgs_pgs_100_305ea7fca9bf48ba884b533ad95779c5
        String data = " {\n" +
                "    \"data\": [\n" +
                "        {\n" +
                "            \"id\": \"512067031077421056\",\n" +
                "            \"receivingTime\": \"2021-01-21T02:58:24.000+00:00\",\n" +
                "            \"customerId\": \"201\",\n" +
                "            \"customerNo\": \"pgs-air\",\n" +
                "            \"customerName\": \"pgs空运\",\n" +
                "            \"receivingId\": \"512067030771236864\",\n" +
                "            \"receivingSn\": \"RE-01-0008\",\n" +
                "            \"referenceSn\": \"44444\",\n" +
                "            \"trackingSn\": null,\n" +
                "            \"destCountryCode\": \"AD\",\n" +
                "            \"destCountryName\": \"安道尔\",\n" +
                "            \"channelCategory\": \"DHL\",\n" +
                "            \"channelName\": \"香港DHL代理价8\",\n" +
                "            \"ctns\": 3,\n" +
                "            \"volumeDivisor\": 5000,\n" +
                "            \"inChargeWeight\": 60.0,\n" +
                "            \"totalInAmount\": 0.0,\n" +
                "            \"grossProfit\": 0.0,\n" +
                "            \"partnerId\": \"0\",\n" +
                "            \"partnerName\": null,\n" +
                "            \"outChargeWeight\": 60.0,\n" +
                "            \"commodityName\": \"2323\",\n" +
                "            \"commodityNameEn\": \"\",\n" +
                "            \"salespersonId\": \"0\",\n" +
                "            \"snType\": null,\n" +
                "            \"freightType\": 1,\n" +
                "            \"destCity\": \"213\",\n" +
                "            \"destPortCode\": null,\n" +
                "            \"destPortName\": null,\n" +
                "            \"destZipCode\": \"123\",\n" +
                "            \"cargoType\": \"DOC\",\n" +
                "            \"declareValue\": 2222.0,\n" +
                "            \"inActualWeight\": 60.0,\n" +
                "            \"saleRemark\": \"213213\",\n" +
                "            \"consigneeContact\": \"gb g\",\n" +
                "            \"consigneeTel\": \"\",\n" +
                "            \"consigneePhone\": \"15870858463\",\n" +
                "            \"consigneeEmail\": \"\",\n" +
                "            \"consigneeState\": \"广东\",\n" +
                "            \"consigneeZipCode\": \"333300\",\n" +
                "            \"consigneeCity\": \"深圳\",\n" +
                "            \"consigneeCompanyName\": \"爱普伦\",\n" +
                "            \"consigneeTaxNumber\": \"\",\n" +
                "            \"consigneeHouseNumber\": \"\",\n" +
                "            \"consigneeAddress1\": \"深和大厦\",\n" +
                "            \"consigneeAddress2\": \"\",\n" +
                "            \"consigneeAddress3\": \"\",\n" +
                "            \"buyerId\": \"0\",\n" +
                "            \"senderContact\": null,\n" +
                "            \"senderTel\": null,\n" +
                "            \"senderPhone\": null,\n" +
                "            \"senderEmail\": null,\n" +
                "            \"senderState\": null,\n" +
                "            \"senderZipCode\": null,\n" +
                "            \"senderCity\": null,\n" +
                "            \"senderCompanyName\": null,\n" +
                "            \"senderAddress1\": null,\n" +
                "            \"senderAddress2\": null,\n" +
                "            \"senderAddress3\": null\n" +
                "        }\n" +
                "    ]\n" +
                "}";

        return data;
    }

    @GetMapping(value = "/get-commodity")
    public String getCommodity(){
        //http://localhost:8085/jeecg-boot/jimu-report/get-commodity
        //http://192.168.1.118:9173/lms-waybill/waybill/print-waybill-commodity?waybillId='${waybillId}'&token='${token}'
        //?waybillId=503441299027722240&token=pgs_pgs_100_786fd011149641219d4808b3efcfc8a9
        String data = "{\n" +
                "    \"data\": [\n" +
                "        {\n" +
                "            \"id\": \"499108045965426689\",\n" +
                "            \"sku\": \"string\",\n" +
                "            \"commodityName\": \"红米\",\n" +
                "            \"commodityNameEn\": \"hongmi\",\n" +
                "            \"qty\": 20,\n" +
                "            \"unitWeight\": 30.0,\n" +
                "            \"unitPrice\": 10.0,\n" +
                "            \"totalPrice\": 200.0,\n" +
                "            \"hsCode\": \"string\",\n" +
                "            \"commodityUse\": \"string\",\n" +
                "            \"origin\": \"string\",\n" +
                "            \"picture\": \"string\",\n" +
                "            \"remark\": \"string\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": \"499116628174110720\",\n" +
                "            \"sku\": \"string\",\n" +
                "            \"commodityName\": \"红米\",\n" +
                "            \"commodityNameEn\": \"hongmi\",\n" +
                "            \"qty\": 30,\n" +
                "            \"unitWeight\": 30.0,\n" +
                "            \"unitPrice\": 10.0,\n" +
                "            \"totalPrice\": 100.0,\n" +
                "            \"hsCode\": \"string\",\n" +
                "            \"commodityUse\": \"string\",\n" +
                "            \"origin\": \"string\",\n" +
                "            \"picture\": \"string\",\n" +
                "            \"remark\": \"string\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": \"499129805821640704\",\n" +
                "            \"sku\": \"string\",\n" +
                "            \"commodityName\": \"小米\",\n" +
                "            \"commodityNameEn\": \"xiaomi\",\n" +
                "            \"qty\": 40,\n" +
                "            \"unitWeight\": 30.0,\n" +
                "            \"unitPrice\": 10.0,\n" +
                "            \"totalPrice\": 100.0,\n" +
                "            \"hsCode\": \"string\",\n" +
                "            \"commodityUse\": \"string\",\n" +
                "            \"origin\": \"string\",\n" +
                "            \"picture\": \"string\",\n" +
                "            \"remark\": \"string\"\n" +
                "        }\n" +
                "    ]\n" +
                "}";

        return data;
    }
}
