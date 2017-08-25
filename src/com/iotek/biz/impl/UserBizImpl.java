package com.iotek.biz.impl;

import com.iotek.biz.IUserBiz;
import com.iotek.dao.IUserDao;
import com.iotek.dao.impl.UserDaoImpl;
import com.iotek.entity.User;
import com.iotek.util.Input;

/**
 * Created by baymax on 2017/8/21.
 * No cross no  crown.
 */
public class UserBizImpl implements IUserBiz {
    private IUserDao userDao = null;

    public UserBizImpl() {
        userDao = new UserDaoImpl();
    }

    User user = new User();

    @Override
    public boolean userRegister() {
        System.out.println("请输入用户名");
        user.setUserName(Input.inputNameOrPsd());
        if (userDao.getUserByName(user) != null) {
            System.out.println("用户名已存在，请直接登录");
            return false;
        }
        System.out.println("请输入密码");
        user.setUserPassword(Input.inputNameOrPsd());
        System.out.println("请输入手机号码");
        user.setUserPhone(Input.inputNameOrPsd());
        if (userDao.addUser(user)) {
            System.out.println("注册成功");
            return true;
        } else {
            System.out.println("注册失败");
            return false;
        }
    }

    @Override
    public User userLogin() {
        System.out.println("请输入用户名");
        String uname = Input.inputNameOrPsd();
        user.setUserName(uname);
        if (userDao.getUserByName(user) != null) {
            System.out.println("请输入密码");
            String upasswd = Input.inputNameOrPsd();
            user.setUserPassword(upasswd);
            if (userDao.getUserByNameAndPassword(user) != null) {
                System.out.println("登录成功");
                return userDao.getUserByNameAndPassword(user);
            } else {
                System.out.println("密码错误");
                return null;
            }
        } else {
            System.out.println("用户名不存在");
            return null;
        }
    }
}
