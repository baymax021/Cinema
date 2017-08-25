package com.iotek.test;

import com.iotek.biz.IAddressBiz;
import com.iotek.biz.ICinemaBiz;
import com.iotek.biz.IMovieBiz;
import com.iotek.biz.IScreeningBiz;
import com.iotek.biz.impl.AddressBizImpl;
import com.iotek.biz.impl.CinemaBizImpl;
import com.iotek.biz.impl.MovieBizImpl;
import com.iotek.biz.impl.ScreeningBizImpl;
import com.iotek.dao.IAddressDao;
import com.iotek.dao.ICinemaDao;
import com.iotek.dao.IMovieDao;
import com.iotek.dao.IScreeningDao;
import com.iotek.dao.impl.*;
import com.iotek.entity.Address;
import com.iotek.entity.Cinema;
import com.iotek.entity.Screening;
import com.iotek.util.Input;
import sun.text.resources.FormatData;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


/**
 * Created by baymax on 2017/8/21.
 * No cross no  crown.
 */
public class B {
    public static void main(String[] args) {
       /* ICinemaDao cinemaDao = new CinemaDaoImpl();
        System.out.println(cinemaDao.allCinemas());*/
     /*   IAddressBiz addressBiz = new AddressBizImpl();
        Address a = new Address();
        addressBiz.addAddress(a);
*/
  /*      ICinemaBiz cinemaBiz = new CinemaBizImpl();
      *//*  Address address = new Address();
        address.setAddressCity("上海");*//*
        System.out.println(cinemaBiz.getCinemaByAddressCity("上海"));*/
//        System.out.println(cinemaDao.allCinemas());
//        System.out.println(cinemaDao.getCinemaByAddress("上海"));
     /*   AddressDaoImpl addressDao = new AddressDaoImpl();
        List<Address> adds = addressDao.getAddressByCity("上海");
        System.out.println(adds);*/
   /*     ICinemaBiz cinemaBiz = new CinemaBizImpl();
        System.out.println(cinemaBiz.getCinemaByAddressCity("上海"));
*/
       /* CinemaDaoImpl cinemaDao = new CinemaDaoImpl();
        List<String> area = cinemaDao.getCinemaByArea("上海");
        for (String s : area) {
            System.out.println(s);
        }*/
     /*   Date date = null;
        String s = "2017年2月14 17:15";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd HH:mm");
        try {
            date = sdf.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(date);
        Timestamp timestamp = new Timestamp(date.getTime());
        System.out.println(timestamp);
        System.out.println(timestamp.getTime());
        System.out.println(date.getTime());
*/
 /*       ICinemaBiz cinemaBiz = new CinemaBizImpl();
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        System.out.println(cinemaBiz.getCinemaById(a) != null);

        IScreeningBiz screeningBiz = new ScreeningBizImpl();
        Screening sg = new Screening();
        screeningBiz.addScreening(sg);
*/
 /*       BaseDao baseDao = new BaseDao();
        String sql = "select s.id,m.movie_name,c.cinema_name,s.hall_num,s.seat_capacity,s.screening_start_date,s.screening_end_date from screening s ,cinema c ,address a,movie m where s.cinema_id = c.id and c.address_id = a.id and s.movie_id = m.id and s.screening_status = '正常'";
        String id = Input.inputText();
        List<Object> p = new ArrayList<>();
        p.add(id);
        List<Map<Integer, Object>> maps = baseDao.queryTables(sql, null);
        System.out.println("影院编号"+"\t影院名称"+"\t\t\t\t地址");
        for (Map<Integer, Object> map : maps) {
            Set<Integer> set = map.keySet();
            for (int i = 0; i < 2; i++) {
                System.out.print(*//*i+"="+*//*"\t"+map.get(i+1) + "\t");
            }
//            System.out.print("地址：");
            for (int i = 2; i < set.size(); i++) {
                System.out.print(map.get(i+1));
            }
            System.out.println();
        }*/
       /* CinemaBizImpl cinemaBiz = new CinemaBizImpl();
        String c = Input.inputText();
        List<Map<Integer, Object>> cs = cinemaBiz.getCinemaByAddressCity(c);
        System.out.println("影院编号"+"\t影院名称"+"\t\t\t\t地址");
        for (Map<Integer, Object> map : cs) {
            Set<Integer> set = map.keySet();
            for (int i = 0; i < 2; i++) {
                System.out.print(*//*i+"="+*//*"\t"+map.get(i+1) + "\t");
            }
//            System.out.print("地址：");
            for (int i = 2; i < set.size(); i++) {
                System.out.print(map.get(i+1));
            }
        }*/



            /*Set<Map.Entry<Integer, Object>> entries = map.entrySet();
            for (Map.Entry<Integer, Object> entry : entries) {
                int i = 0;
                if (i < 2) {
                    System.out.print(entry.getKey()+"="+entry.getValue()+"\t");
                    i++;
                } else {
                    System.out.print(entry.getKey()+"="+entry.getValue());
                }

            }*/
    /*    ICinemaDao cinemaDao = new CinemaDaoImpl();
        int i = Input.inputInt();
        Map<Integer, Object> cinemaById = cinemaDao.getCinemaById(i);
        System.out.println(cinemaById);
*/
/*
        ICinemaBiz cinemaBiz = new CinemaBizImpl();
        int b = Input.inputInt();
        System.out.println(cinemaBiz.getCinemaById(b) != null);*/

/*
        IScreeningDao screeningDao = new ScreeningDaoImpl();
        Screening sg = new Screening();
        System.out.println("-场次----");
        int id = Input.inputInt();
        System.out.println("--影院---");
        sg.setCinemaId(Input.inputInt());
        System.out.println("--电影---");
        sg.setMovieId(Input.inputInt());
        System.out.println("--厅--");
        sg.setHallNum(Input.inputInt());
        System.out.println("--座位---");
        sg.setSeatCapacity(Input.inputInt());
        System.out.println(screeningDao.updateScreeningById(sg,id));
*/




    }

}
