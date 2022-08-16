package cn.tedu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo01 {
    public static void main(String[] args) throws SQLException {
        //获取数据库链接 异常抛出
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/newdb3?" +
                        "characterEncoding=utf8&" +
                        "serverTimezone=Asia/Shanghai",
                "root", "520927zl");
        System.out.println(conn);
        //创建执行SQL语句的对象
        Statement s=conn.createStatement();
        //执行SQL语句
        s.execute("create table jdb1(id int)");
        //关闭资源
        conn.close();
    }
}
