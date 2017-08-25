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
    //    ���ӵ�ӰԺ����������ӵ�ַ�ķ���
    boolean addCinema(Cinema c);



    //    ͨ�����������ҵ�ӰԺ
    List<Map<Integer, Object>> getCinemaByAddressCity(String city);

    // ����ӰԺ��Ϣ
    boolean updateCinema(Cinema c);

    //  ͨ��ӰԺid���ҵ�ӰԺ
    Map<Integer, Object> getCinemaById(int id);

    //    ��ȡ���е�ӰԺ��Ϣ   ��ţ����֣���ַ
    List<Map<Integer, Object>> allCinemas();


    //������ӰԺ��Ϣ
    void output(List<Map<Integer, Object>> maps);

    //�������ӰԺ��Ϣ
    void output(Map<Integer, Object> map);
}
