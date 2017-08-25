package com.iotek.entity;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by baymax on 2017/8/21.
 * No cross no  crown.
 */
public class Cinema implements Serializable{
    private int id;
    private Integer addressId;
    private String cinemaName;
    private Timestamp cinemaCreateDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public String getCinemaName() {
        return cinemaName;
    }

    public void setCinemaName(String cinemaName) {
        this.cinemaName = cinemaName;
    }

    public Timestamp getCinemaCreateDate() {
        return cinemaCreateDate;
    }

    public void setCinemaCreateDate(Timestamp cinemaCreateDate) {
        this.cinemaCreateDate = cinemaCreateDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cinema cinema = (Cinema) o;

        if (id != cinema.id) return false;
        if (addressId != null ? !addressId.equals(cinema.addressId) : cinema.addressId != null) return false;
        if (cinemaName != null ? !cinemaName.equals(cinema.cinemaName) : cinema.cinemaName != null) return false;
        return cinemaCreateDate != null ? cinemaCreateDate.equals(cinema.cinemaCreateDate) : cinema.cinemaCreateDate == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (addressId != null ? addressId.hashCode() : 0);
        result = 31 * result + (cinemaName != null ? cinemaName.hashCode() : 0);
        result = 31 * result + (cinemaCreateDate != null ? cinemaCreateDate.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "电影院编号：" + id +", \t 电影院名字："
                + cinemaName;
    }
}
