package cn.tedu;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Demo03 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入用户名:");
        String username = input.nextLine();
        System.out.println("请输入密码:");
        String password = input.nextLine();
        //获取链接
        try (Connection conn = DBUtils.getCon();) {
            //创建执行SQL的对象
            Statement t = conn.createStatement();
            //准备插入数据
            ResultSet rs = t.executeQuery("select id from user where name+'" + username + "'");
            if (rs.next()) {
                System.out.println("用户名已经存在");
                return;
            }
            String sql = "insert into user values(null,'" + username + "','" + password + "')";
            t.executeUpdate(sql);
            System.out.println("执行完毕");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
