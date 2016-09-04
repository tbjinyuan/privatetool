package com.zk.toolbox.dao.datasource;

import java.sql.Connection;
import java.util.LinkedList;

/**
 * Created by zhengke on 16/8/21.
 */
public class SimplePoolConnection {


    //创建一个连接池

    private static LinkedList<Connection> poolConns= new LinkedList<Connection>();

    //初始化10个连接池

    static{

        try {
            for(int i = 0;i < 10; i++){
                poolConns.add(DbUtils.getConnetion());
            }
        }catch (Exception e){
            throw new ExceptionInInitializerError("数据库连接失败，请检查配置");

        }

    }


    //获取一个连接

    public static Connection getConnection(){
       return  poolConns.removeFirst();
    }


    //释放一个资源
    public static void release(Connection conn){
        poolConns.addLast(conn);
    }
}
