package com.iotek.entity;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by baymax on 2017/8/21.
 * No cross no  crown.
 */
public class Screening implements Serializable {
    private int id;
    private int cinemaId;
    private int movieId;
    private int hallNum;
    private int seatCapacity;
    private int sellNum;
    private Timestamp screeningCreateDate;
    private Timestamp screeningStartDate;
    private Timestamp screeningEndDate;
    private Timestamp screeningCancelDate;
    private String screeningStatus;

    public Screening() {
    }

    public Screening(int cinemaId, int movieId, int hallNum, int seatCapacity, int sellNum, Timestamp screeningCreateDate, Timestamp screeningStartDate, Timestamp screeningEndDate, Timestamp screeningCancelDate, String screeningStatus) {
        this.cinemaId = cinemaId;
        this.movieId = movieId;
        this.hallNum = hallNum;
        this.seatCapacity = seatCapacity;
        this.sellNum = sellNum;
        this.screeningCreateDate = screeningCreateDate;
        this.screeningStartDate = screeningStartDate;
        this.screeningEndDate = screeningEndDate;
        this.screeningCancelDate = screeningCancelDate;
        this.screeningStatus = screeningStatus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCinemaId() {
        return cinemaId;
    }

    public void setCinemaId(int cinemaId) {
        this.cinemaId = cinemaId;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public int getHallNum() {
        return hallNum;
    }

    public void setHallNum(int hallNum) {
        this.hallNum = hallNum;
    }

    public int getSeatCapacity() {
        return seatCapacity;
    }

    public void setSeatCapacity(int seatCapacity) {
        this.seatCapacity = seatCapacity;
    }

    public int getSellNum() {
        return sellNum;
    }

    public void setSellNum(int sellNum) {
        this.sellNum = sellNum;
    }

    public Timestamp getScreeningCreateDate() {
        return screeningCreateDate;
    }

    public void setScreeningCreateDate(Timestamp screeningCreateDate) {
        this.screeningCreateDate = screeningCreateDate;
    }

    public Timestamp getScreeningStartDate() {
        return screeningStartDate;
    }

    public void setScreeningStartDate(Timestamp screeningStartDate) {
        this.screeningStartDate = screeningStartDate;
    }

    public Timestamp getScreeningEndDate() {
        return screeningEndDate;
    }

    public void setScreeningEndDate(Timestamp screeningEndDate) {
        this.screeningEndDate = screeningEndDate;
    }

    public Timestamp getScreeningCancelDate() {
        return screeningCancelDate;
    }

    public void setScreeningCancelDate(Timestamp screeningCancelDate) {
        this.screeningCancelDate = screeningCancelDate;
    }

    public String getScreeningStatus() {
        return screeningStatus;
    }

    public void setScreeningStatus(String screeningStatus) {
        this.screeningStatus = screeningStatus;
    }

    @Override
    public String toString() {
        return "Screening{" +
                "id=" + id +
                ", cinemaId=" + cinemaId +
                ", movieId=" + movieId +
                ", hallNum=" + hallNum +
                ", seatCapacity=" + seatCapacity +
                ", sellNum=" + sellNum +
                ", screeningCreateDate=" + screeningCreateDate +
                ", screeningStartDate=" + screeningStartDate +
                ", screeningEndDate=" + screeningEndDate +
                ", screeningCancelDate=" + screeningCancelDate +
                ", screeningStatus='" + screeningStatus + '\'' +
                '}';
    }
}
