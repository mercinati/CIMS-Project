package model;

public class Criminal {

    private int criminal_id;
    private String name;
    private int age;
    private String gender;
    private String crime_name;
    private String address;
    private String arrest_date;

    public Criminal() {}

    public Criminal(int criminal_id, String name, int age, String gender, String crime_name, String address, String arrest_date) {
        this.criminal_id = criminal_id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.crime_name = crime_name;
        this.address = address;
        this.arrest_date = arrest_date;
    }

    public int getCriminal_id() {
        return criminal_id;
    }

    public void setCriminal_id(int criminal_id) {
        this.criminal_id = criminal_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCrime_name() {
        return crime_name;
    }

    public void setCrime_name(String crime_name) {
        this.crime_name = crime_name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getArrest_date() {
        return arrest_date;
    }

    public void setArrest_date(String arrest_date) {
        this.arrest_date = arrest_date;
    }

    @Override
    public String toString() {
        return "Criminal{" +
                "criminal_id=" + criminal_id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", crime_name='" + crime_name + '\'' +
                ", address='" + address + '\'' +
                ", arrest_date='" + arrest_date + '\'' +
                '}';
    }
}
