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
//    ��ӵ�Ӱ����
    boolean addScreening(Screening sg);
//    ��id���µ�Ӱ����
    boolean updateScreeningById(Screening sg,int id);
//    ���³���״̬;�Ƿ�ȡ��
    boolean updateScreeningStatus(Screening sg,int id);
//    �鿴���е�Ӱ����
    List<Map<Integer, Object>> allScreening();
//    ͨ������Id�鿴������Ϣ
    Map<Integer, Object> getScreeningById(int id);

//    ͨ����Ӱ���ֻ�õ�Ӱ����
    List<Map<Integer, Object>> getScreeningByMovieName(String mn);

//    ͨ��ӰԺ���ֻ�õ�Ӱ����
    List<Map<Integer, Object>> getScreeningByCinemaName(String cn);

//    �鿴ָ������ָ����Ӱ�ĳ�����Ϣ
    List<Map<Integer, Object>> getScreeningByCityAndMovieName(String city,String mn);


    List<Map<Integer, Object>> getScreeningByArea(String area);
    List<Map<Integer, Object>> getScreeningByDate(Date date);
    List<Map<Integer, Object>> getScreeningByCinema(Cinema c);


}
