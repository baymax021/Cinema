package com.iotek.biz.impl;

import com.iotek.biz.IAdminBiz;
import com.iotek.dao.IAdminDao;
import com.iotek.dao.impl.AdminDaoImpl;
import com.iotek.entity.Admin;
import com.iotek.util.Input;

/**
 * Created by baymax on 2017/8/21.
 * No cross no  crown.
 */
public class AdminBizImpl implements IAdminBiz {
    private IAdminDao adminDao = null;

    public AdminBizImpl() {
        adminDao = new AdminDaoImpl();
    }

    Admin admin = new Admin();

    @Override
    public boolean adminLogin() {
        System.out.println("�������û���");
        String aname = Input.inputNameOrPsd();
        System.out.println("����������");
        String apasswd = Input.inputNameOrPsd();
        admin.setAdminName(aname);
        admin.setAdminPassword(apasswd);
        if (adminDao.getAdminByNameAndPassword(admin) != null) {
            System.out.println("��¼�ɹ�");
            return true;
        }
        System.out.println("��¼ʧ��");
        return false;
    }

}
