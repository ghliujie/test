package com.ljlover.travel.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * @Program travel
 * @Descriptiion jdbc工具类
 *
 * @Author ljlover
 * @Date 2019/8/7 7:55
 * All rights reserved.
 */

public class JDBCUtils {


    private static DataSource dataSource;

    static {
        InputStream is = JDBCUtils.class.getResourceAsStream("/druid.properties");
        Properties properties = new Properties();
        try {
            properties.load(is);
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 定义得到数据源方法
     * @return 数据源
     */
    public static DataSource getDataSource(){
        return dataSource;
    }


    /**
     * 定义得到数据库连接对象的方法
     * @return 数据库连接对象
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    public static void close(Connection conn, Statement stmt, ResultSet rs){

        try{
            if (conn!=null) {
                conn.close();
            }
            if (stmt!=null) {
                stmt.close();
            }
            if (rs!=null) {
                rs.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public static void close(Connection conn, Statement stmt){

        try{
            if (conn!=null) {
                conn.close();
            }
            if (stmt!=null) {
                stmt.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
