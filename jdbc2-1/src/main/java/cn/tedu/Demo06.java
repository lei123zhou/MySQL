package cn.tedu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Demo06 {
    public static void main(String[] args) {
        //获取连接
        try (Connection conn = DBUtils.getCon();) {
            String sql = "insert into user values(null,?,?)";
            //因为SQL语句中有变量所以使用预编译的对象
            PreparedStatement ps = conn.prepareStatement(sql);
            for (int i = 1; i <= 100; i++) {
                ps.setString(1, "name" + i);
                ps.setString(2, "pw" + i);
                //添加批量操作
                ps.addBatch();
                if (i % 20 == 0) {
                    //每隔20秒执行一次,避免内存溢出
                    ps.executeBatch();
                }
            }
            //执行批量操作
            ps.executeBatch();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
