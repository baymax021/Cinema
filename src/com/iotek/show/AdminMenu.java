package com.iotek.show;

/**
 * Created by baymax on 2017/8/22.
 * No cross no  crown.
 */
public class AdminMenu {
    public static void adminShow() {
        System.out.println("请按提示选择操作对象：");
        System.out.println("1、电影信息");
        System.out.println("2、影院信息");
        System.out.println("3、电影场次信息");
        System.out.println("4、影票信息");
        System.out.println("5、评论信息");
        System.out.println("6、座位信息");
        System.out.println("0、退出登录");
    }
    public static void adminShow1() {
        System.out.println("1、增加电影");
        System.out.println("2、更新电影信息");
        System.out.println("3、查看所有电影信息");
        System.out.println("4、查看用户看过的电影");
        System.out.println("0、返回上级菜单");
    }
    public static void adminShow2() {
        System.out.println("1、增加电影院");
        System.out.println("2、更新电影院信息");
        System.out.println("3、按区域显示电影院信息");
        System.out.println("4、查看所有电影院信息");
        System.out.println("0、返回上级菜单");
    }
    public static void adminShow3() {
        System.out.println("1、增加电影场次");
        System.out.println("2、更新电影场次信息");
        System.out.println("3、按区域显示电影场次信息");
        System.out.println("4、显示所有电影场次信息");
        System.out.println("0、返回上级菜单");
    }
    public static void adminShow4() {
        System.out.println("1、查看影票信息");
        System.out.println("0、返回上级菜单");
    }
    public static void adminShow5() {
        System.out.println("1、查看电影评论信息");
        System.out.println("2、删除电影评论信息");
        System.out.println("0、返回上级菜单");
    }
    public static void adminShow6() {
        System.out.println("1、查看某个场次的座位信息");
        System.out.println("0、返回上级菜单");
    }


}
