package com.zk.toolbox.dao;

import com.zk.toolbox.dao.datasource.DruidUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;

/**
 * Created by zhengke on 16/9/3.
 */
public class SimpleDao {

    private static final Logger log = LoggerFactory.getLogger(SimpleDao.class);

    public static String getDaoDescription(){


        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            // conn = DbcpUtils.getConnection();



            conn = DruidUtils.getConnection();

            stmt = conn.createStatement();
            stmt = conn.createStatement();

            rs = stmt.executeQuery("select sum(json_extract(data,'$.amount')) as totolAmount,user_name from json_test  where user_name is not  null  group by user_name");
            while (rs.next()) {
                int totolAmount = rs.getInt(1);
                String userName = rs.getString(2);

                //System.out.println("totolAmount:" + totolAmount + ", userName " + userName);
                log.debug("[totolAmount]" + totolAmount + ", [userName] " + userName);
            }
            ResultSetMetaData rsmd = rs.getMetaData();
            int numberOfColumns = rsmd.getColumnCount();

//            System.out.println("numberOfColumns :" + numberOfColumns);
//            System.out.println("catalogName :" + rsmd.getCatalogName(2));
//            System.out.println("ColumnClassName :" + rsmd.getColumnClassName(2));
//            System.out.println("ColumnType :" + rsmd.getColumnType(2));
//            System.out.println("ColumnType :" + rsmd.getColumnTypeName(2));
//            System.out.println("tabName :" + rsmd.getTableName(2));

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
