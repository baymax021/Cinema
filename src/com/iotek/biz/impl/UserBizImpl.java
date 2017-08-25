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
        System.out.println("�������û���");
        user.setUserName(Input.inputNameOrPsd());
        if (userDao.getUserByName(user) != null) {
            System.out.println("�û����Ѵ��ڣ���ֱ�ӵ�¼");
            return false;
        }
        System.out.println("����������");
        user.setUserPassword(Input.inputNameOrPsd());
        System.out.println("�������ֻ�����");
        user.setUserPhone(Input.inputNameOrPsd());
        if (userDao.addUser(user)) {
            System.out.println("ע��ɹ�");
            return true;
        } else {
            System.out.println("ע��ʧ��");
            return false;
        }
    }

    @Override
    public User userLogin() {
        System.out.println("�������û���");
        String uname = Input.inputNameOrPsd();
        user.setUserName(uname);
        if (userDao.getUserByName(user) != null) {
            System.out.println("����������");
            String upasswd = Input.inputNameOrPsd();
            user.setUserPassword(upasswd);
            if (userDao.getUserByNameAndPassword(user) != null) {
                System.out.println("��¼�ɹ�");
                return userDao.getUserByNameAndPassword(user);
            } else {
                System.out.println("�������");
                return null;
            }
        } else {
            System.out.println("�û���������");
            return null;
        }
    }
}
