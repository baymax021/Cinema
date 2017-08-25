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
                case 1: // 用户注册
                    userBiz.userRegister();
                    break;
                case 2:  // 用户登录
                    if (userBiz.userLogin() != null) {
                        b:
                        while (true) {
                            UserMenu.userShow();
                            int n = Input.inputInt();
                            switch (n) {
                                case 1: //查看电影
                                    Movie movie = new Movie();
                                    IMovieBiz movieBiz = new MovieBizImpl();
                                    while (true) {
                                        UserMenu.userShow1();
                                        n = Input.inputInt();
                                        switch (n) {
                                            case 1: //查看所有电影
                                                for (Movie movie1 : movieBiz.allMovies()) {
                                                    System.out.println(movie1);
                                                }
                                                break;
                                            case 2: //输入电影类型查看电影
                                                System.out.println("请输入要查看的电影类型：");
                                                String type = Input.inputText();
                                                if (movieBiz.getMoiveByType(type) != null) {
                                                    List<Movie> moiveByType = movieBiz.getMoiveByType(type);
                                                    for (Movie movie1 : moiveByType) {
                                                        System.out.println(movie1);
                                                    }
                                                } else {
                                                    System.out.println("没有您要找的类型的电影！");
                                                }
                                                break;
                                            case 3: //输入电影名字查看电影
                                                System.out.println("请输入要查看的电影名字：");
                                                String name = Input.inputText();
                                                if (movieBiz.showMovieByName(name) != null) {
                                                    System.out.println(movieBiz.showMovieByName(name));
                                                } else {
                                                    System.out.println("没有您要找的类型的电影！");
                                                }
                                                break;
                                            case 4: //查看电影评分排行榜
                                                break;
                                            case 0:
                                                continue b;
                                        }
                                    }
                                case 2:  //购买影票
                                    break;
                                case 3:  //评论
                                    break;
                                case 0:  // 退出登录
                                    System.out.println("您已成功退出账户！");
                                    continue a;
                            }
                        }
                    }
                    break;
                case 3:
                    //管理员登录成功
                    if (adminBiz.adminLogin()) {
                        b:
                        while (true) {
                            AdminMenu.adminShow();
                            int n = Input.inputInt();
                            switch (n) {
                                case 1: // 对电影信息的操作
                                    Movie movie = new Movie();
                                    IMovieBiz movieBiz = new MovieBizImpl();
                                    while (true) {
                                        AdminMenu.adminShow1();
                                        n = Input.inputInt();
                                        switch (n) {
                                            case 1:  //增加电影
                                                movieBiz.addMoive(movie);
                                                break;
                                            case 2: //更新电影
                                                movieBiz.updateMovie(movie);
                                                break;
                                            case 3: //查看所有电影
                                                for (Movie movie1 : movieBiz.allMovies()) {
                                                    System.out.println(movie1);
                                                }
                                                break;
                                            case 4: //查看用户看过的电影

                                                break;
                                            case 0: // 返回上级菜单
                                                continue b;
                                        }
                                    }
                                case 2:    // 对电影院信息的操作
                                    ICinemaBiz cinemaBiz = new CinemaBizImpl();
                                    while (true) {
                                        AdminMenu.adminShow2();
                                        n = Input.inputInt();
                                        Cinema c = new Cinema();
                                        switch (n) {
                                            case 1: //增加电影院
                                                cinemaBiz.addCinema(c);
                                                break;
                                            case 2: //更新电影院
                                                cinemaBiz.updateCinema(c);
                                                break;
                                            case 3: //查看指定城市的电影院
                                                System.out.println("请输入要查看的城市：");
                                                String city = Input.inputText();
                                                List<Map<Integer, Object>> maps = cinemaBiz.getCinemaByAddressCity(city);
                                                cinemaBiz.output(maps);
                                                break;
                                            case 4:  //查看所有电影院
                                                List<Map<Integer, Object>> maps1 = cinemaBiz.allCinemas();
                                                cinemaBiz.output(maps1);
                                                break;
                                            case 0: // 返回上级菜单
                                                continue b;
                                        }
                                    }

                                case 3:   // 对电影场次信息的操作
                                    IScreeningBiz screeningBiz = new ScreeningBizImpl();
                                    Screening sc = new Screening();
                                    while (true) {
                                        AdminMenu.adminShow3();
                                        n = Input.inputInt();
                                        switch (n) {
                                            case 1:  //增加电影场次
                                                screeningBiz.addScreening(sc);
                                                break;
                                            case 2: //更新电影场次
                                                screeningBiz.updateScreening(sc);
                                                break;
                                            case 3: //查看指定城市指定电影名的电影场次
                                                System.out.println("请输入要查看的城市名：");
                                                String city = Input.inputText();
                                                System.out.println("请输入要查看的电影名：");
                                                String mn = Input.inputText();
                                                if (screeningBiz.getScreeningByCityAndMovieName(city, mn) != null) {
                                                    screeningBiz.output(screeningBiz.getScreeningByCityAndMovieName(city, mn));
                                                } else {
                                                    System.out.println("该城市没有您要查看的电影");
                                                }
                                                break;
                                            case 4: //查看所有电影场次
                                                screeningBiz.output(screeningBiz.allScreening());
                                                break;
                                            case 0: // 返回上级菜单
                                                continue b;
                                        }
                                    }
                                case 4: // 查看影票信息

                                    break;
                                case 5: // 查看、删除评论信息
                                case 6:  // 查看某个场次的座位信息
                                case 0:  // 退出登录
                                    System.out.println("您已成功退出管理员账户！");
                                    continue a;
                            }
                        }
                    }
                    break;
                case 0:
                    System.out.println("是否确认退出? Y / N ");
                    if (Input.inputText().equalsIgnoreCase("y")) {
                        System.out.println("您已退出系统,欢迎下次光临！");
                        System.exit(0);
                    }
                    break;
                default:
                    System.out.println("输入不正确，请重新输入");
                    continue;
            }
        }
    }
}
