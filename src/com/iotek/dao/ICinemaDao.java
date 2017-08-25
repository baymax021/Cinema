package com.iotek.dao;

import com.iotek.entity.Address;
import com.iotek.entity.Cinema;

import java.util.List;
import java.util.Map;

/**
 * Created by baymax on 2017/8/22.
 * No cross no  crown.
 */
public interface ICinemaDao {
    //    增加电影院
    boolean addCinema(Cinema c);

    //    更新指定id的电影院
    boolean updateCinema(Cinema c, int id);

    //    获取所有电影院信息，含地址
    List<Map<Integer, Object>> allCinemas();

    // 通过地址id获取电影院对象
    Cinema getCinemaByAddressId(int id);

    //    通过城市名查找电影院
    List<Map<Integer, Object>> getCinemaByAddressCity(String city);

    //  通过影院id查找电影院
    Map<Integer, Object> getCinemaById(int id);

}
