package com.zk.toolbox.dao;

import java.sql.*;

/**
 * Created by zhengke on 16/9/3.
 */
public class SimpleDao {

    public static String getDaoDescription(){


        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            // conn = DbcpUtils.getConnection();



            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "kevin");

            stmt = conn.createStatement();
            rs = stmt.executeQuery("select * from json_test");
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

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAll(rs,stmt, conn);
        }
        return "this is a simple dao";
    }


    //释放一个连接
    public static void closeAll(ResultSet rs,Statement stmt,Connection conn){
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
}
