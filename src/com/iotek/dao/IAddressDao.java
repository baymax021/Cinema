package com.iotek.dao;

import com.iotek.entity.Address;

import java.util.List;

/**
 * Created by baymax on 2017/8/22.
 * No cross no  crown.
 */
public interface IAddressDao {
    boolean addAddress(Address address);
    boolean updateAddress(Address address,int cId); // 电影院地址搬迁
    List<Address> allAddress();
    Address getAddr(Address address);
    List<Address> getAddressByCity(String city);

}

