package com.iotek.dao;

import com.iotek.entity.User;

/**
 * Created by baymax on 2017/8/21.
 * No cross no  crown.
 */
public interface IUserDao {
    boolean addUser(User user);
    User getUserById(String id);
    User getUserByName(User user);
    User getUserByNameAndPassword(User user);
}
