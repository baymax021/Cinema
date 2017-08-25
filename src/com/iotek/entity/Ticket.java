package com.iotek.entity;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by baymax on 2017/8/21.
 * No cross no  crown.
 */
public class Ticket implements Serializable{
    private int id;
    private int screeningId;
    private int userId;
    private int seatNum;
    private Timestamp ticketCreateDate;

    public Ticket() {
    }

    public Ticket(int screeningId, int userId, int seatNum, Timestamp ticketCreateDate) {
        this.screeningId = screeningId;
        this.userId = userId;
        this.seatNum = seatNum;
        this.ticketCreateDate = ticketCreateDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getScreeningId() {
        return screeningId;
    }

    public void setScreeningId(int screeningId) {
        this.screeningId = screeningId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getSeatNum() {
        return seatNum;
    }

    public void setSeatNum(int seatNum) {
        this.seatNum = seatNum;
    }

    public Timestamp getTicketCreateDate() {
        return ticketCreateDate;
    }

    public void setTicketCreateDate(Timestamp ticketCreateDate) {
        this.ticketCreateDate = ticketCreateDate;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", screeningId=" + screeningId +
                ", userId=" + userId +
                ", seatNum=" + seatNum +
                ", ticketCreateDate=" + ticketCreateDate +
                '}';
    }
}
