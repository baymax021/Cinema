package com.iotek.biz.impl;

import com.iotek.biz.IScreeningBiz;
import com.iotek.biz.ITicketBiz;
import com.iotek.dao.ITicketDao;
import com.iotek.dao.impl.TicketDaoImpl;
import com.iotek.entity.Ticket;
import com.iotek.util.Input;

import java.util.Map;

/**
 * Created by baymax on 2017/8/24.
 * No cross no  crown.
 */
public class TicketBizImpl implements ITicketBiz {
    private ITicketDao ticketDao = null;
    IScreeningBiz screeningBiz = null;

    public TicketBizImpl() {
        ticketDao = new TicketDaoImpl();
        screeningBiz = new ScreeningBizImpl();
    }

    @Override
    public boolean buyTicket(Ticket ticket) {
        return ticketDao.addTicket(ticket);
    }
}
