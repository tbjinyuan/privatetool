package com.zk.toolbox.biz;

import com.zk.toolbox.dao.SimpleDao;

/**
 * Created by zhengke on 16/9/3.
 */
public class SimpleService {

    public static String getServiceDescription(){
         return SimpleDao.getDaoDescription();
    }

}
