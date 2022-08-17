package cn.tedu;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo05 {
    public static void main(String[] args) {
        //获取链接
        try(Connection conn=DBUtils.getCon();) {
            String sql1 = "insert into user values(null,'aaa','aaa')";
            String sql2 = "insert into user values(null,'bbb','bbb')";
            String sql3 = "insert into user values(null,'ccc','ccc')";
            //SQL语音中没有变量使用Statement 有变量必须使用PreparedStatement
            //也可以全部使用PreparedStatement
            Statement s=conn.createStatement();
            //执行SQL语句  逐条执行 进行三次网络传输
//            s.executeUpdate(sql1);
//            s.executeUpdate(sql2);
//            s.executeUpdate(sql3);
            //批量操作 三次合并成一次数据传输
            s.addBatch(sql1);
            s.addBatch(sql2);
            s.addBatch(sql3);
            s.executeBatch();//执行批量操作
            System.out.println("执行完毕");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
