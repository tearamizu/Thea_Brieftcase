package BackEnd;

import java.io.Serializable;

public class Address implements Serializable {
    private String province;
    private String city;
    private String street;
    private String houseNumber;

    public Address(String province, String city, String street, String houseNumber) {
        this.province = province;
        this.city = city;
        this.street = street;
        this.houseNumber = houseNumber;
    }

    public String getProvince() {
        return province;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public String getHouseNumber() {
        return houseNumber;
    }
}