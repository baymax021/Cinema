package com.iotek.biz.impl;

import com.iotek.biz.ICinemaBiz;
import com.iotek.biz.IMovieBiz;
import com.iotek.biz.IScreeningBiz;
import com.iotek.dao.IScreeningDao;

import com.iotek.dao.impl.ScreeningDaoImpl;
import com.iotek.entity.Screening;
import com.iotek.util.Input;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by baymax on 2017/8/23.
 * No cross no  crown.
 */
public class ScreeningBizImpl implements IScreeningBiz {
    private IScreeningDao screeningDao = null;
    private ICinemaBiz cinemaBiz = null;
    private IMovieBiz movieBiz = null;

    public ScreeningBizImpl() {
        screeningDao = new ScreeningDaoImpl();
        cinemaBiz = new CinemaBizImpl();
        movieBiz = new MovieBizImpl();
    }

    @Override
    public boolean addScreening(Screening sg) {
        while (true) {
            System.out.println("请输入影院编号：");
            int n = Input.inputInt();
            if (cinemaBiz.getCinemaById(n) != null) {
                sg.setCinemaId(n);
                System.out.println("请输入电影编号：");
                n = Input.inputInt();
                if (movieBiz.getMovieById(n) != null) {
                    sg.setMovieId(n);
                    inputHallSeatDate(sg);
                }
            }
            if (screeningDao.addScreening(sg)) {
                System.out.println("添加信息成功");
                return true;
            }
            System.out.println("添加失败");
        }
    }

    private void inputHallSeatDate(Screening sg) {
        int n;
        System.out.println("请输入放映厅编号：");
        n = Input.inputInt();
        sg.setHallNum(n);

        System.out.println("请输入放映厅座位容量：");
        n = Input.inputInt();
        sg.setSeatCapacity(n);

        System.out.println("请输入电影放映开始时间：");
        System.out.println("请输入年/月/日：请按所示格式输入按回车结束");
        StringBuilder sb = new StringBuilder();
        sb.append(Input.inputText());
        System.out.println("请输入时间（小时：分钟）：请按所示格式（24小时制）输入按回车结束");
        sb.append("/" + Input.inputText());
        Timestamp startTime = timeFormat(sb.toString());
        sg.setScreeningStartDate(startTime);
        while (true) {
            System.out.println("请输入电影放映结束时间：");
            System.out.println("请输入年/月/日：请按所示格式输入按回车结束");
            StringBuilder sb1 = new StringBuilder();
            sb1.append(Input.inputText());
            System.out.println("请输入时间（小时：分钟）：请按所示格式（24小时制）输入按回车结束");
            sb1.append("/" + Input.inputText());
            Timestamp endTime = timeFormat(sb1.toString());
            if (endTime.getTime() < startTime.getTime()) {
                System.out.println("输入有误，请重新输入");
                continue;
            }
            sg.setScreeningEndDate(endTime);
            break;
        }
    }


    @Override
    public boolean updateScreening(Screening sg) {
        System.out.println("请输入要更新的场次编号");
        while (true) {
            int a = Input.inputInt();
            if (screeningDao.getScreeningById(a) != null) {
                System.out.println("是否取消该场次？Y / N");
                String s = Input.inputText();
                if (s.equalsIgnoreCase("y")) {
                    sg.setScreeningStatus("取消");
                } else {
                    sg.setScreeningStatus("正常");
                }
                if (screeningDao.updateScreeningStatus(sg, a)) {
                    System.out.println("是否更新详细信息？Y / N");
                    s = Input.inputText();
                    if (s.equalsIgnoreCase("y")) {
                        System.out.println("请输入更新后的电影院id");
                        while (true) {
                            int b = Input.inputInt();
                            if (cinemaBiz.getCinemaById(b) != null) {
                                sg.setCinemaId(b);
                                System.out.println("请输入更新后的电影id");
                                while (true) {
                                    int c = Input.inputInt();
                                    if (movieBiz.getMovieById(c) != null) {
                                        sg.setMovieId(c);
                                        inputHallSeatDate(sg);
                                        if (screeningDao.updateScreeningById(sg, a)) {
                                            System.out.println("更新成功");
                                            return true;
                                        } else {
                                            System.out.println("更新失败");
                                            return false;
                                        }
                                    } else {
                                        System.out.println("电影id输入不正确，重新输入");
                                    }
                                }

                            } else {
                                System.out.println("电影院id输入不正确，重新输入");
                            }
                        }
                    } else {
                        System.out.println("更新成功");
                        return true;
                    }
                }else{
                    System.out.println("更新失败");
                    return false;
                }

            } else {
                System.out.println("没有输入的电影场次，重新输入");
            }

        }

    }

    @Override
    public List<Map<Integer, Object>> allScreening() {
        List<Map<Integer, Object>> maps = screeningDao.allScreening();
        return maps;
    }

    @Override
    public List<Map<Integer, Object>> getScreeningByCityAndMovieName(String city, String mn) {
        List<Map<Integer, Object>> maps = screeningDao.getScreeningByCityAndMovieName(city, mn);
        return maps;
    }

    @Override
    public Map<Integer, Object> getScreeningById(int id) {
        Map<Integer, Object> map = screeningDao.getScreeningById(id);
        if (map != null) {
            return map;
        }
        return null;
    }

    @Override
    public List<Map<Integer, Object>> getScreeningByMovieName(String mn) {
        return screeningDao.getScreeningByMovieName(mn);
    }

    @Override
    public List<Map<Integer, Object>> getScreeningByCinemaName(String cn) {
        return screeningDao.getScreeningByCinemaName(cn);
    }

    @Override
    public void output(List<Map<Integer, Object>> maps) {
        System.out.println("场次编号" + "\t电影名称\t" + "\t影院名称\t" + "  厅号\t" + " 座位容量" + "\t\t  开始时间\t\t" + " \t\t\t结束时间" + "\t\t\t是否正常放映");
        try {
            for (Map<Integer, Object> map : maps) {
                Set<Integer> set = map.keySet();
                for (int i = 0; i < set.size(); i++) {
                    System.out.print(/*i+"="+*/"\t" + map.get(i + 1) + "\t");
                }
                System.out.println();
            }
        } catch (Exception e) {
            System.out.println("没有你要查找的城市");
        }
    }


    //时间格式转换

    private static Timestamp timeFormat(String str) {
        Date date = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd/HH:mm");
        try {
            date = sdf.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return new Timestamp(date.getTime());
    }


}
