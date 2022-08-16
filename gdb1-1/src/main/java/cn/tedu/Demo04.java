package cn.tedu;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo04 {
    public static void main(String[] args) {
        //获取工具类在的链接
        try (Connection conn=DBUtils.getCon()){
//创建执行SQL语句的对象
            Statement t=conn.createStatement();
            //执行查询
            ResultSet rs=t.executeQuery("select name from emp");
            while (rs.next()) {
                String name = rs.getString(1);
                System.out.println(name);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
