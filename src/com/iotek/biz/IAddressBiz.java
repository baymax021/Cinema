package com.iotek.biz;

import com.iotek.entity.Address;

import java.util.List;

/**
 * Created by baymax on 2017/8/22.
 * No cross no  crown.
 */
public interface IAddressBiz {
    boolean addAddress(Address address);
    public List<Address> allAddress();
    Address getAddr(Address address);
    List<Address> getAddressByCity(String city);
    boolean updateAddress(Address address,int cId); // 电影院地址搬迁
}
