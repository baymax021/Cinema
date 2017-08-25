package com.iotek.test;

import com.iotek.biz.*;
import com.iotek.biz.impl.*;
import com.iotek.entity.Cinema;
import com.iotek.entity.Movie;
import com.iotek.entity.Screening;
import com.iotek.show.AdminMenu;
import com.iotek.show.Menu;
import com.iotek.show.UserMenu;
import com.iotek.util.Input;

import java.util.List;
import java.util.Map;


/**
 * Created by baymax on 2017/8/21.
 * No cross no  crown.
 */
public class Test {
    public static void main(String[] args) {
        a:
        while (true) {
            IUserBiz userBiz = new UserBizImpl();
            IAdminBiz adminBiz = new AdminBizImpl();
            Menu.show();
            int m = Input.inputInt();
            switch (m) {
                case 1: // �û�ע��
                    userBiz.userRegister();
                    break;
                case 2:  // �û���¼
                    if (userBiz.userLogin() != null) {
                        b:
                        while (true) {
                            UserMenu.userShow();
                            int n = Input.inputInt();
                            switch (n) {
                                case 1: //�鿴��Ӱ
                                    Movie movie = new Movie();
                                    IMovieBiz movieBiz = new MovieBizImpl();
                                    while (true) {
                                        UserMenu.userShow1();
                                        n = Input.inputInt();
                                        switch (n) {
                                            case 1: //�鿴���е�Ӱ
                                                for (Movie movie1 : movieBiz.allMovies()) {
                                                    System.out.println(movie1);
                                                }
                                                break;
                                            case 2: //�����Ӱ���Ͳ鿴��Ӱ
                                                System.out.println("������Ҫ�鿴�ĵ�Ӱ���ͣ�");
                                                String type = Input.inputText();
                                                if (movieBiz.getMoiveByType(type) != null) {
                                                    List<Movie> moiveByType = movieBiz.getMoiveByType(type);
                                                    for (Movie movie1 : moiveByType) {
                                                        System.out.println(movie1);
                                                    }
                                                } else {
                                                    System.out.println("û����Ҫ�ҵ����͵ĵ�Ӱ��");
                                                }
                                                break;
                                            case 3: //�����Ӱ���ֲ鿴��Ӱ
                                                System.out.println("������Ҫ�鿴�ĵ�Ӱ���֣�");
                                                String name = Input.inputText();
                                                if (movieBiz.showMovieByName(name) != null) {
                                                    System.out.println(movieBiz.showMovieByName(name));
                                                } else {
                                                    System.out.println("û����Ҫ�ҵ����͵ĵ�Ӱ��");
                                                }
                                                break;
                                            case 4: //�鿴��Ӱ�������а�
                                                break;
                                            case 0:
                                                continue b;
                                        }
                                    }
                                case 2:  //����ӰƱ
                                    break;
                                case 3:  //����
                                    break;
                                case 0:  // �˳���¼
                                    System.out.println("���ѳɹ��˳��˻���");
                                    continue a;
                            }
                        }
                    }
                    break;
                case 3:
                    //����Ա��¼�ɹ�
                    if (adminBiz.adminLogin()) {
                        b:
                        while (true) {
                            AdminMenu.adminShow();
                            int n = Input.inputInt();
                            switch (n) {
                                case 1: // �Ե�Ӱ��Ϣ�Ĳ���
                                    Movie movie = new Movie();
                                    IMovieBiz movieBiz = new MovieBizImpl();
                                    while (true) {
                                        AdminMenu.adminShow1();
                                        n = Input.inputInt();
                                        switch (n) {
                                            case 1:  //���ӵ�Ӱ
                                                movieBiz.addMoive(movie);
                                                break;
                                            case 2: //���µ�Ӱ
                                                movieBiz.updateMovie(movie);
                                                break;
                                            case 3: //�鿴���е�Ӱ
                                                for (Movie movie1 : movieBiz.allMovies()) {
                                                    System.out.println(movie1);
                                                }
                                                break;
                                            case 4: //�鿴�û������ĵ�Ӱ

                                                break;
                                            case 0: // �����ϼ��˵�
                                                continue b;
                                        }
                                    }
                                case 2:    // �Ե�ӰԺ��Ϣ�Ĳ���
                                    ICinemaBiz cinemaBiz = new CinemaBizImpl();
                                    while (true) {
                                        AdminMenu.adminShow2();
                                        n = Input.inputInt();
                                        Cinema c = new Cinema();
                                        switch (n) {
                                            case 1: //���ӵ�ӰԺ
                                                cinemaBiz.addCinema(c);
                                                break;
                                            case 2: //���µ�ӰԺ
                                                cinemaBiz.updateCinema(c);
                                                break;
                                            case 3: //�鿴ָ�����еĵ�ӰԺ
                                                System.out.println("������Ҫ�鿴�ĳ��У�");
                                                String city = Input.inputText();
                                                List<Map<Integer, Object>> maps = cinemaBiz.getCinemaByAddressCity(city);
                                                cinemaBiz.output(maps);
                                                break;
                                            case 4:  //�鿴���е�ӰԺ
                                                List<Map<Integer, Object>> maps1 = cinemaBiz.allCinemas();
                                                cinemaBiz.output(maps1);
                                                break;
                                            case 0: // �����ϼ��˵�
                                                continue b;
                                        }
                                    }

                                case 3:   // �Ե�Ӱ������Ϣ�Ĳ���
                                    IScreeningBiz screeningBiz = new ScreeningBizImpl();
                                    Screening sc = new Screening();
                                    while (true) {
                                        AdminMenu.adminShow3();
                                        n = Input.inputInt();
                                        switch (n) {
                                            case 1:  //���ӵ�Ӱ����
                                                screeningBiz.addScreening(sc);
                                                break;
                                            case 2: //���µ�Ӱ����
                                                screeningBiz.updateScreening(sc);
                                                break;
                                            case 3: //�鿴ָ������ָ����Ӱ���ĵ�Ӱ����
                                                System.out.println("������Ҫ�鿴�ĳ�������");
                                                String city = Input.inputText();
                                                System.out.println("������Ҫ�鿴�ĵ�Ӱ����");
                                                String mn = Input.inputText();
                                                if (screeningBiz.getScreeningByCityAndMovieName(city, mn) != null) {
                                                    screeningBiz.output(screeningBiz.getScreeningByCityAndMovieName(city, mn));
                                                } else {
                                                    System.out.println("�ó���û����Ҫ�鿴�ĵ�Ӱ");
                                                }
                                                break;
                                            case 4: //�鿴���е�Ӱ����
                                                screeningBiz.output(screeningBiz.allScreening());
                                                break;
                                            case 0: // �����ϼ��˵�
                                                continue b;
                                        }
                                    }
                                case 4: // �鿴ӰƱ��Ϣ

                                    break;
                                case 5: // �鿴��ɾ��������Ϣ
                                case 6:  // �鿴ĳ�����ε���λ��Ϣ
                                case 0:  // �˳���¼
                                    System.out.println("���ѳɹ��˳�����Ա�˻���");
                                    continue a;
                            }
                        }
                    }
                    break;
                case 0:
                    System.out.println("�Ƿ�ȷ���˳�? Y / N ");
                    if (Input.inputText().equalsIgnoreCase("y")) {
                        System.out.println("�����˳�ϵͳ,��ӭ�´ι��٣�");
                        System.exit(0);
                    }
                    break;
                default:
                    System.out.println("���벻��ȷ������������");
                    continue;
            }
        }
    }
}
