package com.iotek.biz;

import com.iotek.entity.Address;
import com.iotek.entity.Cinema;

import java.util.List;
import java.util.Map;

/**
 * Created by baymax on 2017/8/22.
 * No cross no  crown.
 */
public interface ICinemaBiz {
    //    增加电影院，需调用增加地址的方法
    boolean addCinema(Cinema c);



    //    通过城市名查找电影院
    List<Map<Integer, Object>> getCinemaByAddressCity(String city);

    // 更新影院信息
    boolean updateCinema(Cinema c);

    //  通过影院id查找电影院
    Map<Integer, Object> getCinemaById(int id);

    //    获取所有电影院信息   编号，名字，地址
    List<Map<Integer, Object>> allCinemas();


    //输出多个影院信息
    void output(List<Map<Integer, Object>> maps);

    //输出单个影院信息
    void output(Map<Integer, Object> map);
}
