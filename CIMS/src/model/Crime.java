package model;

public class Crime {

    private int crime_id;
    private int month;
    private int date;
    private String place;
    private String crime_name;
    private String victim;
    private String detail_desc;
    private String suspect;
    private String area;
    private String status;

    public Crime() {}

    public Crime(int crime_id, int month, int date, String place, String crime_name, String victim, String detail_desc, String suspect, String area, String status) {
        this.crime_id = crime_id;
        this.month = month;
        this.date = date;
        this.place = place;
        this.crime_name = crime_name;
        this.victim = victim;
        this.detail_desc = detail_desc;
        this.suspect = suspect;
        this.area = area;
        this.status = status;
    }

    public int getCrime_id() {
        return crime_id;
    }
    public void setCrime_id(int crime_id) {
        this.crime_id = crime_id;
    }
    
    public int getMonth() {
        return month;
    }
    public void setMonth(int month) {
        this.month = month;
    }

    public int getDate() {
        return date;
    }
    public void setDate(int date) {
        this.date = date;
    }

    public String getPlace() {
        return place;
    }
    public void setPlace(String place) {
        this.place = place;
    }

    public String getCrime_name() {
        return crime_name;
    }
    public void setCrime_name(String crime_name) {
        this.crime_name = crime_name;
    }

    public String getVictim() {
        return victim;
    }
    public void setVictim(String victim) {
        this.victim = victim;
    }

    public String getDetail_desc() {
        return detail_desc;
    }
    public void setDetail_desc(String detail_desc) {
        this.detail_desc = detail_desc;
    }

    public String getSuspect() {
        return suspect;
    }
    public void setSuspect(String suspect) {
        this.suspect = suspect;
    }

    public String getArea() {
        return area;
    }
    public void setArea(String area) {
        this.area = area;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Crime{" +
                "crime_id=" + crime_id +
                ", month=" + month +
                ", date=" + date +
                ", place='" + place + '\'' +
                ", crime_name='" + crime_name + '\'' +
                ", victim='" + victim + '\'' +
                ", detail_desc='" + detail_desc + '\'' +
                ", suspect='" + suspect + '\'' +
                ", area='" + area + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
