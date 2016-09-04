//package com.zk.toolbox.dao.datasource;
//
///**
// * Created by zhengke on 16/8/24.
// */
//public class C3P0Main {
//
//    public static void main(String[] args) {
//        System.out.println("数据库连接池模拟开始");
//
//        C3P0PoolThread[] connThreads = new C3P0PoolThread[100];
//
//        for (int i = 0; i < connThreads.length; i++) {
//            connThreads[i] = new C3P0PoolThread();
//        }
//
//        for (int i = 0; i < connThreads.length; i++) {
//            connThreads[i].start();
//        }
//    }
//}
//
//
