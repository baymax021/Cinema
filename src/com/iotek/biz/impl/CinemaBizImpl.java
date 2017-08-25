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
        System.out.println("请输入电影院名字：");
        c.setCinemaName(Input.inputText());
        c.setAddressId(addressBiz.getAddr(address).getId());
        if (cinemaDao.addCinema(c)) {
            System.out.println("添加成功");
            return true;
        } else {
            System.out.println("添加失败");
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
        System.out.println("请输入要更新信息的电影院编号：");
        while (true) {
            int n = Input.inputInt();
            if (cinemaDao.getCinemaById(n) != null) {
                System.out.println("请选择更改的信息：1、电影院改名  2、电影院地址搬迁");
                int a = Input.inputInt();
                if (a == 1) {
                    System.out.println("请输入更改后的名字：");
                    c.setCinemaName(Input.inputText());
                    if (cinemaDao.updateCinema(c, n)) {
                        System.out.println("更新成功");
                        return true;
                    }
                } else if (a == 2) {
                    AddressBizImpl addressBiz = new AddressBizImpl();
                    Address address = new Address();
                    if (addressBiz.updateAddress(address, cinemaDao.getCinemaByAddressId(n).getAddressId())) {
                        System.out.println("更新成功");
                        return true;
                    }
                }
                System.out.println("更新失败");
                return false;
            } else {
                System.out.println("影院编号不存在,请重新输入");
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
        System.out.println("影院编号" + "\t影院名称" + "\t\t\t\t地址");
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
            System.out.println("没有你要查找的城市");
        }
    }

    @Override
    public void output(Map<Integer, Object> map) {
        System.out.println("影院编号" + "\t影院名称" + "\t\t\t\t地址");
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
            System.out.println("没有你要查找的城市");
        }
    }
}
