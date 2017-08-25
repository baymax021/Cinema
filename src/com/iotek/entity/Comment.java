package com.iotek.entity;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by baymax on 2017/8/21.
 * No cross no  crown.
 */
public class Comment implements Serializable{
    private int id;
    private int ticketId;
    private String commentContent; //ÆÀ¼ÛÄÚÈÝ
    private int commentScore;  // ÆÀ·Ö 0/1/2/3/4/5
    private Timestamp commentUpdateDate;
}
