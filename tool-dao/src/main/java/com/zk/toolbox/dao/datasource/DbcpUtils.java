//package com.zk.toolbox.dao.datasource;
//
//import org.apache.commons.dbcp.BasicDataSourceFactory;
//
//import javax.sql.DataSource;
//import java.sql.Connection;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.Properties;
//
///**
// * Created by zhengke on 16/8/21.
// */
//public class DbcpUtils {
//
//    //定义一个连接池对象
//    private static DataSource ds;
//
//    static {
//
//        try {
//
//            Properties pro  = new Properties();
//            pro.load(DbcpUtils.class.getClassLoader().getResourceAsStream("dbcpconfig.properties"));
//            ds = BasicDataSourceFactory.createDataSource(pro);//得到一个连接池对象
//
//        }catch (Exception e){
//            System.out.println("数据库连接失败，请检查配置:"+e.getMessage());
//            throw new ExceptionInInitializerError("数据库连接失败，请检查配置");
//        }
//
//    }
//
//
//    //获取一个连接
//
//    public static Connection getConnection() throws SQLException {
//        return ds.getConnection();
//    }
//
//
//    //释放一个连接
//    public static void closeAll(ResultSet rs,Statement stmt,Connection conn){
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
//
//}
