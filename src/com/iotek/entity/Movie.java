package com.iotek.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * Created by baymax on 2017/8/21.
 * No cross no  crown.
 */
public class Movie implements Serializable{
    private int id;
    private String movieName;
    private String movieType;
    private BigDecimal moviePrice;
    private String movieCaption;
    private Timestamp movieCreateDate;

    public Movie() {
    }

    public Movie(String movieName, String movieType, BigDecimal moviePrice, String movieCaption) {
        this.movieName = movieName;
        this.movieType = movieType;
        this.moviePrice = moviePrice;
        this.movieCaption = movieCaption;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getMovieType() {
        return movieType;
    }

    public void setMovieType(String movieType) {
        this.movieType = movieType;
    }

    public BigDecimal getMoviePrice() {
        return moviePrice;
    }

    public void setMoviePrice(BigDecimal moviePrice) {
        this.moviePrice = moviePrice;
    }

    public String getMovieCaption() {
        return movieCaption;
    }

    public void setMovieCaption(String movieCaption) {
        this.movieCaption = movieCaption;
    }

    public Timestamp getMovieCreateDate() {
        return movieCreateDate;
    }

    public void setMovieCreateDate(Timestamp movieCreateDate) {
        this.movieCreateDate = movieCreateDate;
    }

    @Override
    public String toString() {
        return "��Ӱ��ţ�"+id+"\n��Ӱ����"+movieName+"\n��Ӱ���ͣ�"+movieType+"\n��ӰƱ�ۣ�"+moviePrice+"\n��Ӱ��飺"+movieCaption+"\n�ϼ�ʱ�䣺"+movieCreateDate+"\n";
    }
}
