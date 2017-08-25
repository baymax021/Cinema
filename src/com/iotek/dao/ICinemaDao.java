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
    //    ���ӵ�ӰԺ
    boolean addCinema(Cinema c);

    //    ����ָ��id�ĵ�ӰԺ
    boolean updateCinema(Cinema c, int id);

    //    ��ȡ���е�ӰԺ��Ϣ������ַ
    List<Map<Integer, Object>> allCinemas();

    // ͨ����ַid��ȡ��ӰԺ����
    Cinema getCinemaByAddressId(int id);

    //    ͨ�����������ҵ�ӰԺ
    List<Map<Integer, Object>> getCinemaByAddressCity(String city);

    //  ͨ��ӰԺid���ҵ�ӰԺ
    Map<Integer, Object> getCinemaById(int id);

}
