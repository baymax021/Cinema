package com.iotek.dao;


import com.iotek.entity.Ticket;

import java.util.List;
import java.util.Map;

/**
 * Created by baymax on 2017/8/22.
 * No cross no  crown.
 */
public interface ITicketDao {
    //    添加影票
    boolean addTicket(Ticket ticket);

    //通过用户id查看影票
    List<Map<Integer, Object>> getTicketsByUserId(int id);

    //通过用户id查看影票指定电影的影票
    List<Map<Integer, Object>> getTicketsByUserIdAndMovieName(int id,String mn);

//    通过

}
