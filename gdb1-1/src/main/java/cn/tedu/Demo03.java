package cn.tedu;

import org.junit.Test;

import java.sql.*;

public class Demo03 {
    @Test
    public void insert() throws SQLException {
        System.out.println("insert");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/newdb3?" +
                        "characterEncoding=utf8&" +
                        "serverTimezone=Asia/Shanghai",
                "root", "520927zl");
        Statement t = conn.createStatement();
        t.execute("insert into emp(name) values('刘德华')");
        t.close();
        System.out.println("执行完毕");
    }

    @Test
    public void update() throws SQLException {
        System.out.println("update");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/newdb3?" +
                        "characterEncoding=utf8&" +
                        "serverTimezone=Asia/Shanghai",
                "root", "520927zl");
        Statement t = conn.createStatement();
        t.executeUpdate
                ("update emp set name='张学友' where name='刘德华'");
        conn.close();
        System.out.println("执行完毕");
    }

    @Test
    public void delete() throws SQLException {
        System.out.println("delete");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/newdb3?" +
                        "characterEncoding=utf8&" +
                        "serverTimezone=Asia/Shanghai",
                "root", "520927zl");
        Statement t = conn.createStatement();
        t.executeUpdate("delete from emp where name='张学友'");
        conn.close();
    }

    @Test
    public void select() throws SQLException {
        System.out.println("select");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/newdb3?" +
                        "characterEncoding=utf8&" +
                        "serverTimezone=Asia/Shanghai",
                "root", "520927zl");
        Statement t = conn.createStatement();
        //执行查询的SQK语句 ResultSet结果集,里面装着查询回来的数据
        ResultSet rs = t.executeQuery("select name,sal from emp");
//遍历结果集对象 rs.next()返回值布尔值表示是否有下一条数据,同时游标向下移动
        while (rs.next()) {
            //获取当前按游标指向的数据
            //通过查询字段的名获取数据
//            String name=rs.getString("name");
//            double sal=rs.getDouble("sal");
            //通过查询字段的位置获取数据
            String name = rs.getString(1);
            double sal = rs.getDouble(2);
            System.out.println(name + ":" + sal);
        }
        conn.close();
    }
}
