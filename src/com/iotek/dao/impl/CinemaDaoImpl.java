package com.iotek.dao.impl;

import com.iotek.dao.ICinemaDao;
import com.iotek.entity.Address;
import com.iotek.entity.Cinema;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by baymax on 2017/8/22.
 * No cross no  crown.
 */
public class CinemaDaoImpl extends BaseDao implements ICinemaDao {
    @Override
    public boolean addCinema(Cinema c) {
        String s = "insert into cinema(address_id,cinema_name) values (?,?)";
        List<Object> params = new ArrayList<>();
        params.add(c.getAddressId());
        params.add(c.getCinemaName());
        return update(s, params);
    }

    @Override
    public boolean updateCinema(Cinema c,int id) {
        String s = "update cinema set cinema_name = ? where cinema.id = ?";
        List<Object> params = new ArrayList<>();
        params.add(c.getCinemaName());
        params.add(id);
        return update(s, params);
    }

    @Override
    public List<Map<Integer, Object>> allCinemas() {
        String sql = "select c.id,c.cinema_name,a.address_province,a.address_city,a.address_county,a.address_road from cinema c inner join address a on c.address_id = a.id";
        List<Map<Integer, Object>> maps = queryTables(sql, null);
        return maps;
    }


    @Override
    public Cinema getCinemaByAddressId(int id) {
        String s = "select * from cinema where address_id = ?";
        List<Object> params = new ArrayList<>();
        params.add(id);
        List<Cinema> cinemas = query(s, params, Cinema.class);
        if (cinemas != null) {
            return cinemas.get(0);
        }
        return null;
    }

    @Override
    public List<Map<Integer, Object>> getCinemaByAddressCity(String city) {
        String sql = "select c.id,c.cinema_name,a.address_province,a.address_city,a.address_county,a.address_road from cinema c inner join address a on a.id = c.address_id where a.address_city = ? ";
        List<Object> params = new ArrayList<>();
        params.add(city);
        List<Map<Integer, Object>> maps = queryTables(sql, params);
        return maps;
    }

    public List<String> getCinemaByArea1(Address address) {
        String sql = "select c.id,c.cinema_name,a.address_province,a.address_city,a.address_county,a.address_road from cinema c inner join address a where a.address_city = ? ";
        List<Object> params = new ArrayList<>();
        List<String> query = query(sql, params, String.class);
        return query;
    }






    @Override
    public Map<Integer, Object> getCinemaById(int id) {
        String sql = "select c.id,c.cinema_name,a.address_province,a.address_city,a.address_county,a.address_road from cinema c inner join address a on a.id = c.address_id where c.id = ? ";
        List<Object> params = new ArrayList<>();
        params.add(id);
        List<Map<Integer, Object>> maps = queryTables(sql, params);
        if (maps != null && maps.size()> 0){
            return maps.get(0);
        }
        return null;
    }
}
