package com.iotek.biz;

import com.iotek.entity.Screening;

import java.util.List;
import java.util.Map;

/**
 * Created by baymax on 2017/8/23.
 * No cross no  crown.
 */
public interface IScreeningBiz {
    //    增加场次
    boolean addScreening(Screening sg);

    //    更新场次
    boolean updateScreening(Screening sg);

    //    查看所有场次
    List<Map<Integer, Object>> allScreening();

    //    查看指定区域指定电影的场次信息
    List<Map<Integer, Object>> getScreeningByCityAndMovieName(String city, String mn);

    //    通过场次Id查看场次信息
    Map<Integer, Object> getScreeningById(int id);


    //    通过电影名字获得电影场次
    List<Map<Integer, Object>> getScreeningByMovieName(String mn);

    //    通过影院名字获得电影场次
    List<Map<Integer, Object>> getScreeningByCinemaName(String cn);


    //输出多个场次信息
    void output(List<Map<Integer, Object>> maps);

}
