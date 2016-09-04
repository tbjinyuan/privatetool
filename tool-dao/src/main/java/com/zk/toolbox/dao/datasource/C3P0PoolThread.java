//package com.zk.toolbox.dao.datasource;
//
//import java.sql.Statement;
//import java.sql.Connection;
//import java.sql.ResultSet;
//
///**
// * Created by zhengke on 16/8/24.
// */
//public class C3P0PoolThread extends Thread {
//
//
//    private Connection connection;
//
//    private Statement statement;
//
//    private ResultSet resultSet;
//
//
//    @Override
//    public void run() {
//
//        try {
//            connection  = C3P0ConnectionPool.getInstance().getConnection();
//
//            statement = connection.createStatement();
//            resultSet = statement.executeQuery("select sysdate() as nowtime from dual");
//            while (resultSet.next()){
//                System.out.println(Thread.currentThread().getId() + "---------------开始" + resultSet.getString("nowtime"));
//            }
//
//        }catch (Exception e){
//
//        }
//        finally {
//
//            C3P0ConnectionPool.closeAll(resultSet,statement,connection);
//        }
//
//        System.out.println(Thread.currentThread().getId() + "--------结束");
//
//
//
//    }
//}
