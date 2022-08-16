package cn.tedu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {
    //获取链接的方法
    public static Connection getCon() throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/newdb3?" +
                        "characterEncoding=utf8&" +
                        "serverTimezone=Asia/Shanghai",
                "root", "520927zl");
        return conn;
    }
}
