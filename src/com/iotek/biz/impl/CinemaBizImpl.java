package com.iotek.biz.impl;

import com.iotek.biz.ICinemaBiz;
import com.iotek.dao.ICinemaDao;
import com.iotek.dao.impl.CinemaDaoImpl;
import com.iotek.entity.Address;
import com.iotek.entity.Cinema;
import com.iotek.util.Input;

import java.util.*;


/**
 * Created by baymax on 2017/8/22.
 * No cross no  crown.
 */
public class CinemaBizImpl implements ICinemaBiz {
    private ICinemaDao cinemaDao = null;

    public CinemaBizImpl() {
        cinemaDao = new CinemaDaoImpl();
    }

    @Override
    public boolean addCinema(Cinema c) {
        AddressBizImpl addressBiz = new AddressBizImpl();
        Address address = new Address();
        addressBiz.addAddress(address);
        System.out.println("�������ӰԺ���֣�");
        c.setCinemaName(Input.inputText());
        c.setAddressId(addressBiz.getAddr(address).getId());
        if (cinemaDao.addCinema(c)) {
            System.out.println("��ӳɹ�");
            return true;
        } else {
            System.out.println("���ʧ��");
            return false;
        }
    }

  /*  @Override
    public Map<Cinema, Address> allCinemas() {
        Map<Cinema, Address> map = new TreeMap<>(new Comparator<Cinema>() {
            @Override
            public int compare(Cinema o1, Cinema o2) {
                return o1.getId() - o2.getId();
            }
        });
        AddressBizImpl addressBiz = new AddressBizImpl();
        List<Address> addresses = addressBiz.allAddress();
        for (Address address : addresses) {
            map.put(cinemaDao.getCinemaByAddressId(address.getId()), address);
        }
        return map;
    }*/




    @Override
    public List<Map<Integer, Object>> getCinemaByAddressCity(String city) {
        return cinemaDao.getCinemaByAddressCity(city);
    }

    @Override
    public boolean updateCinema(Cinema c) {
        System.out.println("������Ҫ������Ϣ�ĵ�ӰԺ��ţ�");
        while (true) {
            int n = Input.inputInt();
            if (cinemaDao.getCinemaById(n) != null) {
                System.out.println("��ѡ����ĵ���Ϣ��1����ӰԺ����  2����ӰԺ��ַ��Ǩ");
                int a = Input.inputInt();
                if (a == 1) {
                    System.out.println("��������ĺ�����֣�");
                    c.setCinemaName(Input.inputText());
                    if (cinemaDao.updateCinema(c, n)) {
                        System.out.println("���³ɹ�");
                        return true;
                    }
                } else if (a == 2) {
                    AddressBizImpl addressBiz = new AddressBizImpl();
                    Address address = new Address();
                    if (addressBiz.updateAddress(address, cinemaDao.getCinemaByAddressId(n).getAddressId())) {
                        System.out.println("���³ɹ�");
                        return true;
                    }
                }
                System.out.println("����ʧ��");
                return false;
            } else {
                System.out.println("ӰԺ��Ų�����,����������");
            }
        }
    }

    @Override
    public Map<Integer, Object> getCinemaById(int id) {
        return cinemaDao.getCinemaById(id);
    }

    @Override
    public List<Map<Integer, Object>> allCinemas() {
        return cinemaDao.allCinemas();
    }

    @Override
    public void output(List<Map<Integer, Object>> maps) {
        System.out.println("ӰԺ���" + "\tӰԺ����" + "\t\t\t\t��ַ");
        try {
            for (Map<Integer, Object> map : maps) {
                Set<Integer> set = map.keySet();
                for (int i = 0; i < 2; i++) {
                    System.out.print(/*i+"="+*/"\t" + map.get(i + 1) + "\t");
                }
                for (int i = 2; i < set.size(); i++) {
                    System.out.print(map.get(i + 1));
                }
                System.out.println();
            }
        } catch (Exception e) {
            System.out.println("û����Ҫ���ҵĳ���");
        }
    }

    @Override
    public void output(Map<Integer, Object> map) {
        System.out.println("ӰԺ���" + "\tӰԺ����" + "\t\t\t\t��ַ");
        try {
            Set<Integer> set = map.keySet();
            for (int i = 0; i < 2; i++) {
                System.out.print(/*i+"="+*/"\t" + map.get(i + 1) + "\t");
            }
            for (int i = 2; i < set.size(); i++) {
                System.out.print(map.get(i + 1));
            }
            System.out.println();
        } catch (Exception e) {
            System.out.println("û����Ҫ���ҵĳ���");
        }
    }
}
