package cn.tedu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo02 {
    public static void main(String[] args) throws SQLException {
        Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/newdb3?" +
                        "characterEncoding=utf8&" +
                        "serverTimezone=Asia/Shanghai",
                "root", "520927zl");
        Statement t=conn.createStatement();
        t.execute("drop table jdb1");
        conn.close();
    }
}
