package com.iotek.dao.impl;

import com.iotek.dao.IUserDao;
import com.iotek.entity.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by baymax on 2017/8/21.
 * No cross no  crown.
 */
public class UserDaoImpl extends BaseDao implements IUserDao {
    @Override
    public boolean addUser(User user) {
        String s = "insert into user(user_name,user_password,user_phone) values (?,?,?)";
        List<Object> params = new ArrayList<>();
        params.add(user.getUserName());
        params.add(user.getUserPassword());
        params.add(user.getUserPhone());
        return update(s,params);
    }

    @Override
    public User getUserById(String  id) {
        String s = "select * from user where user.id = ?";
        List<Object> params = new ArrayList<>();
        params.add(id);
        List<User> result = query(s, params, User.class);
        return result.size()>0?result.get(0):null;
    }

    @Override
    public User getUserByName(User user) {
        String s = "select * from user where user_name=? ";
        List<Object> params = new ArrayList<>();
        params.add(user.getUserName());
        List<User> result = query(s, params, User.class);
        if(result != null){
            return result.get(0);
        }
        return null;
    }

    @Override
    public User getUserByNameAndPassword(User user) {
        String s = "select * from user where user_name=? and user_password=?";
        List<Object> params = new ArrayList<>();
        params.add(user.getUserName());
        params.add(user.getUserPassword());
        List<User> result = query(s, params, User.class);
        if(result != null){
            return result.get(0);
        }
        return null;
    }
}
