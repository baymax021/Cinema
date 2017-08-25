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
            System.out.println("������ʡ����");
            address.setAddressProvince(Input.inputText());
            System.out.println("������������");
            address.setAddressCity(Input.inputText());
            System.out.println("������������");
            address.setAddressCounty(Input.inputText());
            System.out.println("������ֵ������ƺţ�");
            address.setAddressRoad(Input.inputText());
            if (addressDao.getAddr(address) == null) {
                if (addressDao.addAddress(address)) {
                    System.out.println("��ַ��ӳɹ�");
                    return true;
                } else {
                    System.out.println("��ַ���ʧ��");
                    return false;
                }
            }else{
                System.out.println("��ַ�Ѵ���");

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
        System.out.println("������ʡ����");
        address.setAddressProvince(Input.inputText());
        System.out.println("������������");
        address.setAddressCity(Input.inputText());
        System.out.println("������������");
        address.setAddressCounty(Input.inputText());
        System.out.println("������ֵ������ƺţ�");
        address.setAddressRoad(Input.inputText());
        return addressDao.updateAddress(address,cId);
    }
}
