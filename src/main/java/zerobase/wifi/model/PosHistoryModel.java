package zerobase.wifi.model;


import java.util.Date;

public class PosHistoryModel {

    private int ID;
    private float  LAT;
    private float LNT;
    private Date search_date;


    public int getID(){
        return ID;
    }

    public float  getLAT(){
        return LAT;
    }

    public float getLNT(){
        return LNT;
    }

    public Date getSearch_date() {
        return search_date;
    }


    public void setID(int ID){
      this.ID = ID;
    }

    public void setLAT(float LAT) {
        this.LAT = LAT;

    }

    public void setLNT(float LNT){
       this.LNT = LNT;
    }

    public void setSearch_date(Date search_date) {
        this.search_date = search_date;
    }
}


