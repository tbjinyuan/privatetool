package com.zk.toolbox.dao.datasource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by zhengke on 16/8/21.
 */
public class DbUtils {

    private static final String url = "jdbc:mysql://localhost:3306/test";

    private static final String user = "root";

    private static final String password = "kevin";

    public static Connection getConnetion() {

        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException e) {
            //TODO
        } catch (SQLException e) {

        }

        return conn;

    }

}
