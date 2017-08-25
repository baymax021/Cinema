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
            System.out.println("������ӰԺ��ţ�");
            int n = Input.inputInt();
            if (cinemaBiz.getCinemaById(n) != null) {
                sg.setCinemaId(n);
                System.out.println("�������Ӱ��ţ�");
                n = Input.inputInt();
                if (movieBiz.getMovieById(n) != null) {
                    sg.setMovieId(n);
                    inputHallSeatDate(sg);
                }
            }
            if (screeningDao.addScreening(sg)) {
                System.out.println("�����Ϣ�ɹ�");
                return true;
            }
            System.out.println("���ʧ��");
        }
    }

    private void inputHallSeatDate(Screening sg) {
        int n;
        System.out.println("�������ӳ����ţ�");
        n = Input.inputInt();
        sg.setHallNum(n);

        System.out.println("�������ӳ����λ������");
        n = Input.inputInt();
        sg.setSeatCapacity(n);

        System.out.println("�������Ӱ��ӳ��ʼʱ�䣺");
        System.out.println("��������/��/�գ��밴��ʾ��ʽ���밴�س�����");
        StringBuilder sb = new StringBuilder();
        sb.append(Input.inputText());
        System.out.println("������ʱ�䣨Сʱ�����ӣ����밴��ʾ��ʽ��24Сʱ�ƣ����밴�س�����");
        sb.append("/" + Input.inputText());
        Timestamp startTime = timeFormat(sb.toString());
        sg.setScreeningStartDate(startTime);
        while (true) {
            System.out.println("�������Ӱ��ӳ����ʱ�䣺");
            System.out.println("��������/��/�գ��밴��ʾ��ʽ���밴�س�����");
            StringBuilder sb1 = new StringBuilder();
            sb1.append(Input.inputText());
            System.out.println("������ʱ�䣨Сʱ�����ӣ����밴��ʾ��ʽ��24Сʱ�ƣ����밴�س�����");
            sb1.append("/" + Input.inputText());
            Timestamp endTime = timeFormat(sb1.toString());
            if (endTime.getTime() < startTime.getTime()) {
                System.out.println("������������������");
                continue;
            }
            sg.setScreeningEndDate(endTime);
            break;
        }
    }


    @Override
    public boolean updateScreening(Screening sg) {
        System.out.println("������Ҫ���µĳ��α��");
        while (true) {
            int a = Input.inputInt();
            if (screeningDao.getScreeningById(a) != null) {
                System.out.println("�Ƿ�ȡ���ó��Σ�Y / N");
                String s = Input.inputText();
                if (s.equalsIgnoreCase("y")) {
                    sg.setScreeningStatus("ȡ��");
                } else {
                    sg.setScreeningStatus("����");
                }
                if (screeningDao.updateScreeningStatus(sg, a)) {
                    System.out.println("�Ƿ������ϸ��Ϣ��Y / N");
                    s = Input.inputText();
                    if (s.equalsIgnoreCase("y")) {
                        System.out.println("��������º�ĵ�ӰԺid");
                        while (true) {
                            int b = Input.inputInt();
                            if (cinemaBiz.getCinemaById(b) != null) {
                                sg.setCinemaId(b);
                                System.out.println("��������º�ĵ�Ӱid");
                                while (true) {
                                    int c = Input.inputInt();
                                    if (movieBiz.getMovieById(c) != null) {
                                        sg.setMovieId(c);
                                        inputHallSeatDate(sg);
                                        if (screeningDao.updateScreeningById(sg, a)) {
                                            System.out.println("���³ɹ�");
                                            return true;
                                        } else {
                                            System.out.println("����ʧ��");
                                            return false;
                                        }
                                    } else {
                                        System.out.println("��Ӱid���벻��ȷ����������");
                                    }
                                }

                            } else {
                                System.out.println("��ӰԺid���벻��ȷ����������");
                            }
                        }
                    } else {
                        System.out.println("���³ɹ�");
                        return true;
                    }
                }else{
                    System.out.println("����ʧ��");
                    return false;
                }

            } else {
                System.out.println("û������ĵ�Ӱ���Σ���������");
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
        System.out.println("���α��" + "\t��Ӱ����\t" + "\tӰԺ����\t" + "  ����\t" + " ��λ����" + "\t\t  ��ʼʱ��\t\t" + " \t\t\t����ʱ��" + "\t\t\t�Ƿ�������ӳ");
        try {
            for (Map<Integer, Object> map : maps) {
                Set<Integer> set = map.keySet();
                for (int i = 0; i < set.size(); i++) {
                    System.out.print(/*i+"="+*/"\t" + map.get(i + 1) + "\t");
                }
                System.out.println();
            }
        } catch (Exception e) {
            System.out.println("û����Ҫ���ҵĳ���");
        }
    }


    //ʱ���ʽת��

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
