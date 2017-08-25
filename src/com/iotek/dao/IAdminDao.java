package com.iotek.dao;

import com.iotek.entity.Admin;

/**
 * Created by baymax on 2017/8/21.
 * No cross no  crown.
 */
public interface IAdminDao {
    Admin getAdminByNameAndPassword(Admin admin);
}
