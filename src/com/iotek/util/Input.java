package com.iotek.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by baymax on 2017/8/21.
 * No cross no  crown.
 */
public class Input {
    public static String inputNameOrPsd() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            String s = sc.nextLine();
            if (s != null) {
                s = s.trim();
                if (!s.contains(" ") && s.length() >= 5
                        && s.length() <= 12) {
                    return s;
                }
            }
            System.out.println("输入错误，重新输入");
        }
    }
/*

    Scanner input = new Scanner(System.in);
    System.out.println("请输入一个整数：");
    do {
        try {
            int i = input.nextInt();
            System.out.println(i);
            break;
        } catch (Exception e) {
            System.out.println("输入有误，请重新输入：");
            input.nextLine();
        }
    }while (true);
*/

    public static String inputText() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            String s = sc.nextLine();
            if (s != null) {
                s = s.trim();
                    return s;
            }
            System.out.println("内容不能为空，重新输入");
        }
    }

    public static String inputCommnet() {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        String s;
        try {
            while ((s = br.readLine()) != null) {
                return s;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Double inputPrice() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                Double d = sc.nextDouble();
                return d;
            } catch (Exception e) {
                System.out.println("输入错误，重新输入");
                sc.nextLine();
            }
        }
    }

    public static int inputInt(){
        Scanner input = new Scanner(System.in);
        do {
            try {
                int i = input.nextInt();
                return i;
            } catch (Exception e) {
                System.out.println("输入有误，请重新输入：");
                input.nextLine();
            }
        }while (true);
    }
  /*  public static String inputPassword(){
        while (true) {
            Scanner sc = new Scanner(System.in);
            String s = sc.next();
            if(s != null){
                if(!s.trim().contains(" ")
                        && s.trim().length() > 6
                        && s.trim().length() < 12){
                    return s.trim();
                }
            }
            sc.nextLine();
            return "输入错误，重新输入";
        }
    }*/

}
