package com.iotek.dao.impl;

import com.iotek.dao.IScreeningDao;
import com.iotek.entity.Cinema;
import com.iotek.entity.Screening;
import com.sun.xml.internal.bind.v2.model.core.ID;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by baymax on 2017/8/22.
 * No cross no  crown.
 */
public class ScreeningDaoImpl extends BaseDao implements IScreeningDao {
    @Override
    public boolean addScreening(Screening sg) {
        String sql = "insert into screening(cinema_id,movie_id,hall_num,seat_capacity,screening_start_date,screening_end_date) values (?,?,?,?,?,?)";
        List<Object> params = new ArrayList<>();
        params.add(sg.getCinemaId());
        params.add(sg.getMovieId());
        params.add(sg.getHallNum());
        params.add(sg.getSeatCapacity());
        params.add(sg.getScreeningStartDate());
        params.add(sg.getScreeningEndDate());
        return update(sql,params);
    }

    @Override
    public boolean updateScreeningById(Screening sg,int id) {
        String sql = "update screening set cinema_id = ?,movie_id = ?,hall_num = ?,seat_capacity = ?,screening_start_date = ?,screening_end_date = ?,screening_status = ? where id = ?;";
        List<Object> params = new ArrayList<>();
        params.add(sg.getCinemaId());
        params.add(sg.getMovieId());
        params.add(sg.getHallNum());
        params.add(sg.getSeatCapacity());
        params.add(sg.getScreeningStartDate());
        params.add(sg.getScreeningEndDate());
        params.add(sg.getScreeningStatus());
        params.add(id);
        return update(sql,params);
    }

    @Override
    public boolean updateScreeningStatus(Screening sg,int id) {
        String sql = "update screening set screening_status = ? where id = ?;";
        List<Object> params = new ArrayList<>();
        params.add(sg.getScreeningStatus());
        params.add(id);
        return update(sql,params);
    }

    @Override
    public List<Map<Integer, Object>> allScreening() {
        String sql = "select s.id,m.movie_name,c.cinema_name,s.hall_num,s.seat_capacity,s.screening_start_date,s.screening_end_date,s.screening_status from screening s ,cinema c ,address a,movie m where s.cinema_id = c.id and c.address_id = a.id and s.movie_id = m.id ";
        List<Map<Integer, Object>> maps = queryTables(sql, null);
        return maps;
    }

    @Override
    public Map<Integer, Object> getScreeningById(int id) {
        String sql = "select s.id,m.movie_name,c.cinema_name,s.hall_num,s.seat_capacity,s.screening_start_date,s.screening_end_date,s.screening_status from screening s ,cinema c ,address a,movie m where s.cinema_id = c.id and c.address_id = a.id and s.movie_id = m.id and s.id=?";
        List<Object> params = new ArrayList<>();
        params.add(id);
        List<Map<Integer, Object>> maps = queryTables(sql, params);
        if (maps != null) {
            return maps.get(0);
        }
        return null;
    }

    @Override
    public List<Map<Integer, Object>> getScreeningByCityAndMovieName(String city, String mn) {
        String sql = "select s.id,m.movie_name,c.cinema_name,s.hall_num,s.seat_capacity,s.screening_start_date,s.screening_end_date,s.screening_status from screening s ,cinema c ,address a,movie m where s.cinema_id = c.id and c.address_id = a.id and s.movie_id = m.id and a.address_city = ? and m.movie_name = ?";
        List<Object> params = new ArrayList<>();
        params.add(city);
        params.add(mn);
        List<Map<Integer, Object>> maps = queryTables(sql, params);
        return null;
    }

    @Override
    public List<Map<Integer, Object>> getScreeningByMovieName(String mn) {
        String sql = "select s.id,m.movie_name,c.cinema_name,s.hall_num,s.seat_capacity,s.screening_start_date,s.screening_end_date,s.screening_status from screening s ,cinema c ,address a,movie m where s.cinema_id = c.id and c.address_id = a.id and s.movie_id = m.id and m.movie_name = ?";
        List<Object> params = new ArrayList<>();
        params.add(mn);
        List<Map<Integer, Object>> maps = queryTables(sql, params);
        if (maps != null) {
            return maps;
        }
        return null;
    }

    @Override
    public List<Map<Integer, Object>> getScreeningByCinemaName(String cn) {
        String sql = "select s.id,m.movie_name,c.cinema_name,s.hall_num,s.seat_capacity,s.screening_start_date,s.screening_end_date,s.screening_status from screening s ,cinema c ,address a,movie m where s.cinema_id = c.id and c.address_id = a.id and s.movie_id = m.id and c.cinema_name = ?";
        List<Object> params = new ArrayList<>();
        params.add(cn);
        List<Map<Integer, Object>> maps = queryTables(sql, params);
        if (maps != null) {
            return maps;
        }
        return null;
    }

    @Override
    public List<Map<Integer, Object>> getScreeningByArea(String area) {
        return null;
    }

    @Override
    public List<Map<Integer, Object>> getScreeningByDate(Date date) {
        return null;
    }

    @Override
    public List<Map<Integer, Object>> getScreeningByCinema(Cinema c) {
        return null;
    }


}
