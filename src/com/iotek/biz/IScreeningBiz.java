package com.iotek.biz;

import com.iotek.entity.Screening;

import java.util.List;
import java.util.Map;

/**
 * Created by baymax on 2017/8/23.
 * No cross no  crown.
 */
public interface IScreeningBiz {
    //    ���ӳ���
    boolean addScreening(Screening sg);

    //    ���³���
    boolean updateScreening(Screening sg);

    //    �鿴���г���
    List<Map<Integer, Object>> allScreening();

    //    �鿴ָ������ָ����Ӱ�ĳ�����Ϣ
    List<Map<Integer, Object>> getScreeningByCityAndMovieName(String city, String mn);

    //    ͨ������Id�鿴������Ϣ
    Map<Integer, Object> getScreeningById(int id);


    //    ͨ����Ӱ���ֻ�õ�Ӱ����
    List<Map<Integer, Object>> getScreeningByMovieName(String mn);

    //    ͨ��ӰԺ���ֻ�õ�Ӱ����
    List<Map<Integer, Object>> getScreeningByCinemaName(String cn);


    //������������Ϣ
    void output(List<Map<Integer, Object>> maps);

}
