package com.iotek.dao.impl;

import com.iotek.dao.IAddressDao;
import com.iotek.entity.Address;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by baymax on 2017/8/22.
 * No cross no  crown.
 */
public class AddressDaoImpl extends BaseDao implements IAddressDao {
    @Override
    public boolean addAddress(Address address) {
        String sql = "insert into address(address_province,address_city,address_county,address_road) values (?,?,?,?)";
        List<Object> params = new ArrayList<>();
        params.add(address.getAddressProvince());
        params.add(address.getAddressCity());
        params.add(address.getAddressCounty());
        params.add(address.getAddressRoad());
        return update(sql,params);
    }

    @Override
    public boolean updateAddress(Address address,int cId) {
        String sql = "update address set address_province = ? , address_city = ? ,address_county = ?  , address_road = ? where id = ?";
        List<Object> params = new ArrayList<>();
        params.add(address.getAddressProvince());
        params.add(address.getAddressCity());
        params.add(address.getAddressCounty());
        params.add(address.getAddressRoad());
        params.add(cId);
        return update(sql,params);
    }

    @Override
    public List<Address> allAddress() {
        String sql = "select * from address";
        List<Address> addressList = query(sql, null, Address.class);
        return addressList;
    }


    @Override
    public Address getAddr(Address address) {
        String sql = "select id from address where address_province=? and address_city=? and address_county=? and address_road=?";
        List<Object> params = new ArrayList<>();
        params.add(address.getAddressProvince());
        params.add(address.getAddressCity());
        params.add(address.getAddressCounty());
        params.add(address.getAddressRoad());
        List<Address> result = query(sql, params, Address.class);
        if(result != null){
            return result.get(0);
        }
        return null;
    }

    @Override
    public List<Address> getAddressByCity(String city) {
        String sql = "select * from address where address_city = ?";
        List<Object> params = new ArrayList<>();
        params.add(city);
        List<Address> addresses = query(sql, params, Address.class);
        return addresses;
    }

}
