package com.traverse.www.service;

import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.w3c.dom.Document;  // 이 부분이 중요합니다!
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import java.io.StringReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;

import org.xml.sax.InputSource;

@Service
public class TestService {

    private final RestTemplate rt;

    public TestService() {
        this.rt = new RestTemplate();
        // RestTemplate에 UTF-8 인코딩을 적용한 StringHttpMessageConverter를 추가
        this.rt.getMessageConverters().add(0, new StringHttpMessageConverter(StandardCharsets.UTF_8));
    }

    public HashMap<String, String> getPlaceDetails(int contenttypeid1,int contentid1) {
        String serviceKey = "6RkKaXlTQt2IajvJnERjyEHx6pTvNp0n8ZT%2FiBQPLe4bXmMbm0o8mBSubhyyCBEjYC0Ur%2BOsD%2FpNUdrxNp7owQ%3D%3D";
        String contenttypeid = Integer.toString(contenttypeid1);
        String contentid = Integer.toString(contentid1);
        
        String url = String.format(
            "http://apis.data.go.kr/B551011/KorService1/detailIntro1?ServiceKey=%s&contentTypeId=%s&contentId=%s&MobileOS=ETC&MobileApp=AppTest",
            serviceKey,contenttypeid, contentid
        );

        try {
            URI uri = new URI(url);  // URL을 URI 객체로 변환
            System.out.println(uri);
            // URI를 사용하여 GET 요청을 보내고, 응답을 String으로 받음
            String responseBody = rt.getForObject(uri, String.class);

            // 응답을 콘솔에 출력하여 확인
            System.out.println("Response Body: " + responseBody);

            // HashMap에 데이터를 파싱하고 저장하는 로직을 이어서 작성
            HashMap<String, String> resultMap = parseXmlToHashMap(responseBody);

            return resultMap;

        } catch (URISyntaxException e) {
            e.printStackTrace();
            return null;  // 오류 발생 시 null 반환
        }
    }
    public HashMap<String, String> getPlace(int contenttypeid1, int contentid1) {
			String serviceKey = "6RkKaXlTQt2IajvJnERjyEHx6pTvNp0n8ZT%2FiBQPLe4bXmMbm0o8mBSubhyyCBEjYC0Ur%2BOsD%2FpNUdrxNp7owQ%3D%3D";
      String contenttypeid = Integer.toString(contenttypeid1);
      String contentid = Integer.toString(contentid1);
      
      String url = String.format(
          "http://apis.data.go.kr/B551011/KorService1/detailCommon1?ServiceKey=%s&contentTypeId=%s&contentId=%s&MobileOS=ETC&MobileApp=AppTest&defaultYN=Y&firstImageYN=Y&areacodeYN=Y&catcodeYN=Y&addrinfoYN=Y&mapinfoYN=Y&overviewYN=Y",
          serviceKey,contenttypeid, contentid
      );

      try {
          URI uri = new URI(url);  // URL을 URI 객체로 변환
          System.out.println(uri);
          // URI를 사용하여 GET 요청을 보내고, 응답을 String으로 받음
          String responseBody = rt.getForObject(uri, String.class);

          // 응답을 콘솔에 출력하여 확인
          System.out.println("Response Body: " + responseBody);

          // HashMap에 데이터를 파싱하고 저장하는 로직을 이어서 작성
          HashMap<String, String> resultMap = parseXmlToHashMap(responseBody);

          return resultMap;

      } catch (URISyntaxException e) {
          e.printStackTrace();
          return null;  // 오류 발생 시 null 반환
      }
		}
    

    private HashMap<String, String> parseXmlToHashMap(String responseBody) {
        // XML을 파싱하여 HashMap으로 변환하는 로직 작성
        // 이전 코드에서 사용한 XML 파싱 로직을 이곳에 포함시킵니다
        HashMap<String, String> resultMap = new HashMap<>();

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new InputSource(new StringReader(responseBody)));

            XPathFactory xpathFactory = XPathFactory.newInstance();
            XPath xpath = xpathFactory.newXPath();
            // 공통
            resultMap.put("contentid", getTagValueWithXPath(xpath, doc, "//item/contentid"));
            resultMap.put("title", getTagValueWithXPath(xpath, doc, "//item/title"));
            resultMap.put("addr1", getTagValueWithXPath(xpath, doc, "//item/addr1"));
            resultMap.put("tel", getTagValueWithXPath(xpath, doc, "//item/tel"));
            resultMap.put("overview", getTagValueWithXPath(xpath, doc, "//item/overview"));
            resultMap.put("firstimage", getTagValueWithXPath(xpath, doc, "//item/firstimage"));
            resultMap.put("mapx", getTagValueWithXPath(xpath, doc, "//item/mapx"));
            resultMap.put("mapy", getTagValueWithXPath(xpath, doc, "//item/mapy"));
            resultMap.put("contenttypeid", getTagValueWithXPath(xpath, doc, "//item/contenttypeid"));
            // 문화시설
            resultMap.put("restculture", getTagValueWithXPath(xpath, doc, "//item/restdateculture"));
            resultMap.put("usetimeculture", getTagValueWithXPath(xpath, doc, "//item/usetimeculture"));
            resultMap.put("usefee", getTagValueWithXPath(xpath, doc, "//item/usefee"));
            resultMap.put("infocenterculture", getTagValueWithXPath(xpath, doc, "//item/infocenterculture"));
            resultMap.put("parkingculture", getTagValueWithXPath(xpath, doc, "//item/parkingculture"));
            resultMap.put("chkbagcarriageculture", getTagValueWithXPath(xpath, doc, "//item/chkcreditcardculture"));
            // 관광지
            resultMap.put("info", getTagValueWithXPath(xpath, doc, "//item/infocenter"));
            resultMap.put("restdate", getTagValueWithXPath(xpath, doc, "//item/restdate"));
            resultMap.put("expgname", getTagValueWithXPath(xpath, doc, "//item/expagerange"));
            resultMap.put("parking", getTagValueWithXPath(xpath, doc, "//item/parking"));
            resultMap.put("usetime", getTagValueWithXPath(xpath, doc, "//item/usetime"));
            resultMap.put("chkbagcarriage", getTagValueWithXPath(xpath, doc, "//item/chkbabycarriage"));
            resultMap.put("chkpet", getTagValueWithXPath(xpath, doc, "//item/chkpet"));
            // 레포츠
            resultMap.put("restateleports", getTagValueWithXPath(xpath, doc, "//item/restdateleports"));
            resultMap.put("usetimeleports", getTagValueWithXPath(xpath, doc, "//item/usetimeleports"));
            resultMap.put("incentreleports", getTagValueWithXPath(xpath, doc, "//item/infocenterleports"));
            resultMap.put("parkingleports", getTagValueWithXPath(xpath, doc, "//item/parkingleports"));
            resultMap.put("parkingfeeleports", getTagValueWithXPath(xpath, doc, "//item/parkingfeeleports"));
            // 숙박
            resultMap.put("roomtype", getTagValueWithXPath(xpath, doc, "//item/roomtype"));
            resultMap.put("chkintime", getTagValueWithXPath(xpath, doc, "//item/checkintime"));
            resultMap.put("chkouttime", getTagValueWithXPath(xpath, doc, "//item/checkouttime"));
            resultMap.put("cooking", getTagValueWithXPath(xpath, doc, "//item/chkcooking"));
            resultMap.put("incentrelodging", getTagValueWithXPath(xpath, doc, "//item/infocenterlodging"));
            resultMap.put("parkinglodging", getTagValueWithXPath(xpath, doc, "//item/parkinglodging"));
            resultMap.put("reservationurl", getTagValueWithXPath(xpath, doc, "//item/reservationurl"));
            //음식점
            resultMap.put("firstmenu", getTagValueWithXPath(xpath, doc, "//item/firstmenu"));
            resultMap.put("opentimefood", getTagValueWithXPath(xpath, doc, "//item/opentimefood"));
            resultMap.put("infocenterfood", getTagValueWithXPath(xpath, doc, "//item/infocenterfood"));
            resultMap.put("restdatefood", getTagValueWithXPath(xpath, doc, "//item/restdatefood"));

        } catch (Exception e) {
            e.printStackTrace();
        }

        return resultMap;
    }

    private String getTagValueWithXPath(XPath xpath, Document doc, String expression) {
        try {
            NodeList nodeList = (NodeList) xpath.evaluate(expression, doc, XPathConstants.NODESET);
            if (nodeList != null && nodeList.getLength() > 0) {
                return nodeList.item(0).getTextContent();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";  // 태그를 찾지 못했을 경우 반환
    }

		

		
}
