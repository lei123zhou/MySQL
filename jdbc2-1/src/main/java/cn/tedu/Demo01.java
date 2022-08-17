package cn.tedu;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo01 {
    public static void main(String[] args) {
        //获取链接
        try (Connection conn = DBUtils.getCon();) {
            //创建执行队形
            Statement t = conn.createStatement();
            ResultSet rs = t.executeQuery("select name,sal from emp");
            while (rs.next()) {
                //getString()里面的参数有两种:1.字段名，2.字段位置
                String name = rs.getString(1);
                double sal = rs.getDouble(2);
                System.out.println(name + ":" + sal);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
