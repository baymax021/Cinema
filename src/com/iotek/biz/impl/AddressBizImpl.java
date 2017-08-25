package com.iotek.biz.impl;

import com.iotek.biz.IAddressBiz;
import com.iotek.dao.IAddressDao;
import com.iotek.dao.impl.AddressDaoImpl;
import com.iotek.entity.Address;
import com.iotek.util.Input;

import java.util.List;

/**
 * Created by baymax on 2017/8/22.
 * No cross no  crown.
 */
public class AddressBizImpl implements IAddressBiz {
    private IAddressDao addressDao = null;

    public AddressBizImpl() {
        addressDao = new AddressDaoImpl();
    }

    @Override
    public boolean addAddress(Address address) {
        while (true) {
            System.out.println("请输入省名：");
            address.setAddressProvince(Input.inputText());
            System.out.println("请输入市名：");
            address.setAddressCity(Input.inputText());
            System.out.println("请输入县名：");
            address.setAddressCounty(Input.inputText());
            System.out.println("请输入街道及门牌号：");
            address.setAddressRoad(Input.inputText());
            if (addressDao.getAddr(address) == null) {
                if (addressDao.addAddress(address)) {
                    System.out.println("地址添加成功");
                    return true;
                } else {
                    System.out.println("地址添加失败");
                    return false;
                }
            }else{
                System.out.println("地址已存在");

            }
        }

    }


    @Override
    public List<Address> allAddress() {
        List<Address> addresses = addressDao.allAddress();
        return addresses;
    }

    @Override
    public Address getAddr(Address address) {
        return addressDao.getAddr(address);
    }

    @Override
    public List<Address> getAddressByCity(String city) {
        return addressDao.getAddressByCity(city);
    }

    @Override
    public boolean updateAddress(Address address, int cId) {
        System.out.println("请输入省名：");
        address.setAddressProvince(Input.inputText());
        System.out.println("请输入市名：");
        address.setAddressCity(Input.inputText());
        System.out.println("请输入县名：");
        address.setAddressCounty(Input.inputText());
        System.out.println("请输入街道及门牌号：");
        address.setAddressRoad(Input.inputText());
        return addressDao.updateAddress(address,cId);
    }
}
