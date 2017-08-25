package com.iotek.dao;


import com.iotek.entity.Ticket;

import java.util.List;
import java.util.Map;

/**
 * Created by baymax on 2017/8/22.
 * No cross no  crown.
 */
public interface ITicketDao {
    //    ���ӰƱ
    boolean addTicket(Ticket ticket);

    //ͨ���û�id�鿴ӰƱ
    List<Map<Integer, Object>> getTicketsByUserId(int id);

    //ͨ���û�id�鿴ӰƱָ����Ӱ��ӰƱ
    List<Map<Integer, Object>> getTicketsByUserIdAndMovieName(int id,String mn);

//    ͨ��

}
