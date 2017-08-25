package com.iotek.dao.impl;

import com.iotek.dao.ITicketDao;
import com.iotek.entity.Ticket;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by baymax on 2017/8/24.
 * No cross no  crown.
 */
public class TicketDaoImpl extends BaseDao implements ITicketDao {
    @Override
    public boolean addTicket(Ticket ticket) {
        String sql ="insert into ticket(screening_id,user_id,seat_num) values (?,?,?)";
        List<Object> params = new ArrayList<>();
        params.add(ticket.getScreeningId());
        params.add(ticket.getUserId());
        params.add(ticket.getSeatNum());
        return update(sql,params);
    }

    @Override
    public List<Map<Integer, Object>> getTicketsByUserId(int id) {
        return null;
    }

    @Override
    public List<Map<Integer, Object>> getTicketsByUserIdAndMovieName(int id, String mn) {
        return null;
    }
}
