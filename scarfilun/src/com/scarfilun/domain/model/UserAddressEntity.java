package com.scarfilun.domain.model;

import javax.persistence.Embeddable;
import javax.persistence.Column;
import java.io.Serializable;

@SuppressWarnings("serial")
@Embeddable
public class UserAddressEntity implements Serializable{

    private String country;
    private String province;
    private String city;

    @Column(name = "COUNTRY", nullable = false)
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Column(name = "PROVINCE", nullable = false)
    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    @Column(name = "CITY", nullable = false)
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "UserAddress{" +
                "country='" + country + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
