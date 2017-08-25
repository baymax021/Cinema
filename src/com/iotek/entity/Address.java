package com.iotek.entity;

import java.io.Serializable;

/**
 * Created by baymax on 2017/8/21.
 * No cross no  crown.
 */
public class Address implements Serializable {
    private int id;
    private String addressProvince;
    private String addressCity;
    private String addressCounty;
    private String addressRoad;

    public Address() {
    }

    public Address(String addressProvince, String addressCity, String addressCounty, String addressRoad) {
        this.addressProvince = addressProvince;
        this.addressCity = addressCity;
        this.addressCounty = addressCounty;
        this.addressRoad = addressRoad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddressProvince() {
        return addressProvince;
    }

    public void setAddressProvince(String addressProvince) {
        this.addressProvince = addressProvince;
    }

    public String getAddressCity() {
        return addressCity;
    }

    public void setAddressCity(String addressCity) {
        this.addressCity = addressCity;
    }

    public String getAddressCounty() {
        return addressCounty;
    }

    public void setAddressCounty(String addressCounty) {
        this.addressCounty = addressCounty;
    }

    public String getAddressRoad() {
        return addressRoad;
    }

    public void setAddressRoad(String addressRoad) {
        this.addressRoad = addressRoad;
    }

    @Override
    public String toString() {
        return addressProvince+addressCity+addressCounty +addressRoad ;
    }
}
