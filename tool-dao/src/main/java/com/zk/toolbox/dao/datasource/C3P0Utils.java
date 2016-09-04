//package com.alibaba.alinwdp.odin.metadata.datasource;
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
// * Created by zhengke on 16/8/22.
// */
//public class C3P0Utils {
//
//
//     private static DataSource dataSource = new ComboPooledDataSource();
//
//
//     //从池中获取一个连接
//     public static Connection getConnection() throws SQLException {
//          return dataSource.getConnection();
//     }
//
//     public static void closeAll(ResultSet rs,Statement stmt,Connection conn){
//          if(rs!=null){
//               try {
//                    rs.close();
//               } catch (SQLException e) {
//                    e.printStackTrace();
//               }
//          }
//
//          if(stmt!=null){
//               try {
//                    stmt.close();
//               } catch (SQLException e) {
//                    e.printStackTrace();
//               }
//          }
//
//          if(conn!=null){
//               try {
//                    conn.close();//关闭
//               } catch (SQLException e) {
//                    e.printStackTrace();
//               }
//          }
//     }
//
//     public static void main(String[] args) {
//           Connection connection = null;
//
//           Statement statement = null;
//
//           ResultSet resultSet = null;
//          try {
//               connection  = getConnection();
//
//               statement = connection.createStatement();
//               resultSet = statement.executeQuery("select sysdate() as nowtime from dual");
//               while (resultSet.next()){
//                    System.out.println(Thread.currentThread().getId() + "---------------开始" + resultSet.getString("nowtime"));
//               }
//
//          }catch (Exception e){
//
//          }
//          finally {
//
//               closeAll(resultSet,statement,connection);
//          }
//
//          System.out.println(Thread.currentThread().getId() + "--------结束");
//     }
//}
