package com.zk.toolbox.dao.datasource;

import com.alibaba.druid.pool.DruidDataSource;

import java.sql.*;
import java.util.Properties;

/**
 * Created by zhengke on 16/8/24.
 *
 * Druid不仅是一个数据库连接池，还包含一个ProxyDriver、一系列内置的JDBC组件库、一个SQL Parser。
 *支持所有JDBC兼容的数据库，包括Oracle、MySql、Derby、Postgresql、SQL Server、H2等。
 *Druid针对Oracle和MySql做了特别优化，比如：
 *MySql的ping检测优化
 *Druid提供了MySql、Oracle、Postgresql、SQL-92的SQL的完整支持，这是一个手写的高性能SQL Parser，支持Visitor模式，使得分析SQL的抽象语法树很方便。
 *简单SQL语句用时10微秒以内，复杂SQL用时30微秒。
 *通过Druid提供的SQL Parser可以在JDBC层拦截SQL做相应处理，比如说分库分表、审计等。Druid防御SQL注入攻击的WallFilter，就是通过Druid的SQL *Parser分析语义实现的
 */

public class DruidUtils {

    private static DruidDataSource ds ;


    static {
        ds = new DruidDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/test");
        ds.setUsername("root");
        ds.setPassword("kevin");

        Properties properties = new Properties();
 //       properties.put("connectTimeout",1000);
        properties.put("characterEncoding","utf8");
        //properties.put("autoReconnect",true);
        //properties.put("failOverReadOnly",false);
        //properties.put("socketTimeout",12000);
        ds.setConnectProperties(properties);

        ds.setInitialSize(3);
        ds.setMaxActive(10);
        ds.setMaxWait(1500);

    }


    //从池中获取一个连接
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

    public static void closeAll(ResultSet rs, Statement stmt, Connection conn){
        if(rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(stmt!=null){
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(conn!=null){
            try {
                conn.close();//关闭
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Connection connection = null;

        Statement statement = null;

        ResultSet rs = null;
        try {
            connection  = getConnection();
            System.out.println(connection);


            statement = connection.createStatement();

            rs = statement.executeQuery("select * from json_test");
            while (rs.next()) {
                int uid = rs.getInt(1);
                String data = rs.getString(2);
                String userName = rs.getString(3);

                System.out.println("uid:" + uid + ", data:" + data + ", userName " + userName);
            }

            ResultSetMetaData rsmd = rs.getMetaData();
            int numberOfColumns = rsmd.getColumnCount();

            System.out.println("numberOfColumns :" + numberOfColumns);
            System.out.println("catalogName :" + rsmd.getCatalogName(2));
            System.out.println("ColumnClassName :" + rsmd.getColumnClassName(2));
            System.out.println("ColumnType :" + rsmd.getColumnType(2));
            System.out.println("ColumnType :" + rsmd.getColumnTypeName(2));
            System.out.println("tabName :" + rsmd.getTableName(2));


        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        finally {

            closeAll(rs,statement,connection);
        }

        System.out.println(Thread.currentThread().getId() + "--------结束");
    }


}
