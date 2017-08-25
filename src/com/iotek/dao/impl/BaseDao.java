package com.iotek.dao.impl;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.*;


/**
 * Created by baymax on 2017/8/21.
 * No cross no  crown.
 */
public class BaseDao {
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/cinema";
    private static final String USER = "root";
    private static final String PASSWORD = "123456";

    /**
     * 与数据库建立连接
     *
     * @return 数据库连接对象
     */
    public Connection getConn() {
        Connection conn = null;
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            System.out.println("未找到数据库驱动");
        }
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.out.println("连接数据库失败");
        }
        return conn;
    }

    private void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) {
        try {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    /**
     * 增删改
     *
     * @param sql
     * @param params
     * @return true 或 false
     */
    public boolean update(String sql, List<Object> params) {
        int res = 0;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = getConn();
            ps = conn.prepareStatement(sql);
            if (params != null) {
                for (int i = 0; i < params.size(); i++) {
                    ps.setObject(i + 1, params.get(i));
                }
            }
            res = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAll(rs, ps, conn);
        }
        return res > 0 ? true : false;
    }


    /**
     * 多表连查
     * @param sql
     * @param params
     * @return
     */
    public List<Map<Integer, Object>> queryTables(String sql, List<Object> params) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ResultSetMetaData rsmd = null;
        List<Map<Integer, Object>> data = new ArrayList<>();
        try {
            conn = getConn();
            ps = conn.prepareStatement(sql);
            if (params != null) {
                for (int i = 0; i < params.size(); i++) {
                    ps.setObject(i + 1, params.get(i));
                }
            }
            rs = ps.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            //把查询结果封装成对应的实体类对象
            rsmd = rs.getMetaData();//得到记录集元数据
            //通过此对象可以得到表的结构
            while (rs.next()) {
                Map map = new TreeMap();
                for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                    String label = rsmd.getColumnName(i);
                    Object o = rs.getObject(i);
                    map.put(i, o);
                }
                data.add(map);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAll(rs,ps,conn);
        }


        return data.size() > 0 ? data : null;
    }


    /**
     * 查询单个表格
     * 泛型和反射机制
     *
     * @param sql
     * @param params
     * @param cls
     * @param <T>
     * @return
     */
    public <T> List<T> query(String sql, List<Object> params, Class<T> cls) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ResultSetMetaData rsd = null;
        List<T> data = new ArrayList<T>();
        try {
            conn = getConn();
            ps = conn.prepareStatement(sql);
            if (params != null) {
                for (int i = 0; i < params.size(); i++) {
                    ps.setObject(i + 1, params.get(i));
                }
            }
            rs = ps.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            //把查询结果封装成对应的实体类对象
            rsd = rs.getMetaData();//得到记录集元数据
            //通过此对象可以得到表的结构
            while (rs.next()) {
                T t = cls.newInstance();
                for (int i = 0; i < rsd.getColumnCount(); i++) {
                    String columnName = rsd.getColumnName(i + 1);//获得列名
                    Object o = rs.getObject(columnName);
                    Field field = cls.getDeclaredField(getString(columnName));
                    field.setAccessible(true);
                    field.set(t, o);
                }
                data.add(t);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } finally {
            closeAll(rs, ps, conn);
        }
        return data.size() > 0 ? data : null;
    }


    public String getString(String s) {
        if (s == null) {
            System.out.println("字符串不能为空");
        }
        StringBuilder sb = new StringBuilder();
        s = s.toLowerCase();
        for (int i = 0; i < s.length(); ) {
            char c = s.charAt(i);
            if (c == '_') {
                c = Character.toUpperCase(s.charAt(i + 1));
                sb.append(c);
                i += 2;
            } else {
                sb.append(c);
                i++;
            }
        }
        s = sb.toString();
        s = s.replace("_", "");
        return s;
    }

    public void outPut(Object... List) {


    }
}
