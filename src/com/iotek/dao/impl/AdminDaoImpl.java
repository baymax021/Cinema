package com.iotek.dao.impl;

import com.iotek.dao.IAdminDao;
import com.iotek.entity.Admin;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by baymax on 2017/8/21.
 * No cross no  crown.
 */
public class AdminDaoImpl extends BaseDao implements IAdminDao {
    @Override
    public Admin getAdminByNameAndPassword(Admin admin) {
        String s = "select * from admin where admin_name=? and admin_password=?";
        List<Object> params = new ArrayList<>();
        params.add(admin.getAdminName());
        params.add(admin.getAdminPassword());
        List<Admin> result = query(s, params, Admin.class);
        if (result != null) {
            return result.get(0);
        }
        return null;
    }
}
