package zerobase.wifi.service;



//import org.json.JSONArray;
// import org.json.JSONObject;
import org.json.simple.parser.ParseException;
import zerobase.wifi.dto.WifiInfoDto;
import zerobase.wifi.model.WifiInfoModel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.JSONObject;




public class WifiApiComponent {

  //  /**
  //   * OpenAPI를 통해서 와이파이 정보의 JSON문자열을 리턴함
  //   */
 //   public String getWifiInfoList(int pageIndex) {
//
 //       throw new RuntimeException("구현해 주세요.");
//   }

 public int getTotal() throws IOException, ParseException{
        StringBuilder url = new StringBuilder("http://openapi.seoul.go.kr:8088");
        url.append("/" + URLEncoder.encode("6b47795770647564313035424e485451","UTF-8") );

        URL u = new URL(url.toString());
        HttpURLConnection conn = (HttpURLConnection) u.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");

        BufferedReader rd;


        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }

        StringBuilder sb = new StringBuilder();
        String line;

        while ((line = rd.readLine()) != null){
            sb.append(line);
        }

        rd.close();
        conn.disconnect();


        JSONObject result = (JSONObject) new JSONParser().parse(sb.toString());
        JSONObject data = (JSONObject) result.get("data");
        JSONArray array = (JSONArray) data.get("row");

        JSONObject tmp = null;

        for(int j=0; j <array.size(); j++){
            WifiInfoModel w = new WifiInfoModel();
            w.setWifi_no(String.valueOf(tmp.get("wifi_no")));
            w.setWifi_name(String.valueOf(tmp.get("wifi_name")));

            WifiInfoDto wifiInfoDto = new WifiInfoDto();
            wifiInfoDto.insert(w);
        }

    return getTotal();
 }




}
