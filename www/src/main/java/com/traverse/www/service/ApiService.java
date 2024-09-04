package com.traverse.www.service;


import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.traverse.www.model.ApiDAO;
import com.traverse.www.vo.ApiVO;


@Service
public class ApiService {
   
   @Autowired
   private ApiDAO dao;

   public List<ApiVO> fetchDataFromApi() throws Exception {
      String url = "https://apis.data.go.kr/B551011/KorService1/areaBasedList1?";
      HashMap<String, String> params = new HashMap<>();
      
      params.put("ServiceKey", "6RkKaXlTQt2IajvJnERjyEHx6pTvNp0n8ZT/iBQPLe4bXmMbm0o8mBSubhyyCBEjYC0Ur+OsD/pNUdrxNp7owQ==");
      //params.put("areaCode", "32");
      params.put("numOfRows", "800");
      params.put("pageNo", "21");
      params.put("numOfRows", "1000");
      params.put("pageNo", "17");
      params.put("MobileOS", "ETC");
      params.put("MobileApp", "AppTest");
      params.put("listYN", "Y");
      params.put("arrange", "A");
      params.put("contentTypeId", "39");
      params.put("_type", "json");
      
      for(String key : params.keySet()) {
         String value = params.get(key);
         value = URLEncoder.encode(value, "UTF-8");
         url += String.format("%s=%s&", key,value);
      }
      String data = "";
      System.out.println(url);
      HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
      int responseCode = conn.getResponseCode();
      System.out.println(responseCode);
      
      if(responseCode == 200) {
         Scanner sc = new Scanner(conn.getInputStream());
         while(sc.hasNextLine()) {
            data += sc.nextLine() + "\n";

         }
         sc.close();
         System.out.println(data);
      }
      
      JsonMapper jsonMapper = JsonMapper.builder()
                                                         .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false)
                                                         .build();
      JsonNode jsonNode = jsonMapper.readTree(data).get("response").get("body").get("items").get("item");
      return jsonMapper.readValue(jsonNode.toString(),new TypeReference<List<ApiVO>>(){});
   }

   public void saveDataToDatabase(List<ApiVO> dataList) {
      dao.insertData(dataList);
   }

}
