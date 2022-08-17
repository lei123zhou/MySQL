package cn.tedu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Demo07 {
    public static void main(String[] args) {
        //创建Scanner获取用户输入的页数和条数
        //获取数据库连接
        //查询数据,使用limit关键字
        //遍历查询结果把查询到的用户名在控制台输出
        Scanner input = new Scanner(System.in);
        System.out.println("请输入查询的页数:");
        int page = input.nextInt();
        System.out.println("请输入查询条数:");
        int count = input.nextInt();
        try (Connection conn = DBUtils.getCon();) {
            String sql = "select username from user limit ?,?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, (page - 1) * count);
            ps.setInt(2, count);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String username = rs.getString(1);
                System.out.println("使用者" + username);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
