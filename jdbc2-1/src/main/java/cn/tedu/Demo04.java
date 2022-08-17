package cn.tedu;

import java.sql.*;
import java.util.Scanner;

public class Demo04 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入用户名:");
        String username = input.nextLine();
        System.out.println("请输入密码:");
        String password = input.nextLine();
        //获取链接
        try (Connection conn = DBUtils.getCon();) {
//            Statement t = conn.createStatement();
//            String sql = "select count(*) from user where username='" + username + "'and password='" + password + "'";
//            ResultSet rs = t.executeQuery(sql);
            //********************解决SQL注入问题**************************

            //使用问号把位置先站住
            String sql="select count(*) from user"+
                    "where username=? and password=?";
            //创建执行SQL语句对象
            PreparedStatement ps=conn.prepareStatement(sql);
            //替换SQL语句中的?
            ps.setString(1,username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            //不管用户输入什么,都会有结果不用判断是否有吓一跳
            rs.next();
            int count = rs.getInt(1);
            if (count > 0) {
                System.out.println("登录成功");
            } else {
                System.out.println("登录失败,账号或密码错误");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
