//package com.zk.toolbox.dao.datasource;
//
//import com.mchange.v2.c3p0.ComboPooledDataSource;
//
//import javax.sql.DataSource;
//import java.sql.Connection;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//
///**
// * Created by zhengke on 16/8/24.
// */
//public class C3P0ConnectionPool {
//
//    private static C3P0ConnectionPool pool;
//
//    private DataSource ds;
//
//    private C3P0ConnectionPool() {
//        ds = new ComboPooledDataSource();
//    }
//
//    public static synchronized final C3P0ConnectionPool getInstance() {
//        if (pool == null) {
//            try {
//                pool = new C3P0ConnectionPool();
//
//            } catch (Exception e) {
//                //TODO
//            }
//
//        }
//        return pool;
//
//    }
//
//    // synchronized保证每个pool线程请求返回的都是不同的Connection
//    public synchronized final Connection getConnection() {
//        try {
//            Connection connection = ds.getConnection();
//            // 1)将配置文件中的c3p0.initialPoolSize，c3p0.minPoolSize，c3p0.maxPoolSize都改为1，然后执行查看结果
//            // 2)将配置文件中的c3p0.initialPoolSize，c3p0.minPoolSize，c3p0.maxPoolSize都改为较小的值，加大线程数，然后执行查看结果
//            System.out.println(" **** current connection number: " + ((ComboPooledDataSource)ds).getNumConnections()
//                    + " busy connection number: " + ((ComboPooledDataSource)ds).getNumBusyConnections()
//                    + " Idle connection nmuber: " + ((ComboPooledDataSource)ds).getNumIdleConnections());
//            return connection;
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        return null;
//    }
//
//
//
//    public static void closeAll(ResultSet rs, Statement stmt, Connection conn){
//        if(rs!=null){
//            try {
//                rs.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//
//        if(stmt!=null){
//            try {
//                stmt.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//
//        if(conn!=null){
//            try {
//                conn.close();//关闭
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//}
