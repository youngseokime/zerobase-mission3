package zerobase.wifi.dto;


import zerobase.wifi.model.WifiInfoModel;

public class WifiInfoDto {

    public void insert(WifiInfoModel wifiInfoModel){
        String sql = "INSERT INTO wifi_info VALUES(?,?,?,?);";
        wifiInfoModel.getWifi_no();
    }



}


