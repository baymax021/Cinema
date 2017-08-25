package com.iotek.dao;

import com.iotek.entity.Cinema;
import com.iotek.entity.Screening;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by baymax on 2017/8/22.
 * No cross no  crown.
 */
public interface IScreeningDao {
//    添加电影场次
    boolean addScreening(Screening sg);
//    按id更新电影场次
    boolean updateScreeningById(Screening sg,int id);
//    更新场次状态;是否取消
    boolean updateScreeningStatus(Screening sg,int id);
//    查看所有电影场次
    List<Map<Integer, Object>> allScreening();
//    通过场次Id查看场次信息
    Map<Integer, Object> getScreeningById(int id);

//    通过电影名字获得电影场次
    List<Map<Integer, Object>> getScreeningByMovieName(String mn);

//    通过影院名字获得电影场次
    List<Map<Integer, Object>> getScreeningByCinemaName(String cn);

//    查看指定区域指定电影的场次信息
    List<Map<Integer, Object>> getScreeningByCityAndMovieName(String city,String mn);


    List<Map<Integer, Object>> getScreeningByArea(String area);
    List<Map<Integer, Object>> getScreeningByDate(Date date);
    List<Map<Integer, Object>> getScreeningByCinema(Cinema c);


}
