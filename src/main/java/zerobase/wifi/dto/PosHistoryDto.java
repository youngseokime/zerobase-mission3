package zerobase.wifi.dto;


import zerobase.wifi.model.PosHistoryModel;

import javax.servlet.ServletException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PosHistoryDto {

    public void insert(PosHistoryModel posHistoryModel){

        //DB 테이블을 이용한 쿼리짜기


        try{
           Class.forName("org.mariadb.jdbc.Driver");

        }catch (ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
        Connection conn = null;
        PreparedStatement statement = null;

    try{
        conn = DriverManager.getConnection("jdbc:mariadb://192.168.11.194:8080/testdb3/history");

        String sql = "INSERT INTO HISTORY(ID,LAT,LNT,search_date) VALUES(?,?,?,DATETIME('NOW', 'LOCALTIME'))";
        statement = conn.prepareStatement (sql);
        statement.setString(1,String.valueOf(posHistoryModel.getLNT()));
        statement.setString(2,String.valueOf(posHistoryModel.getLAT()));

        int affected = statement.executeUpdate();
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }





    }



}


