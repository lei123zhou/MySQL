package cn.tedu;

import com.alibaba.druid.pool.DruidDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class Demo02 {

    public static void main(String[] args) throws SQLException {
        //创建数据库连接池
        DruidDataSource dds = new DruidDataSource();
        //设置数据库链接信息
        dds.setUrl("jdbc:mysql://localhost:3306/newdb3?" +
                "characterEncoding=utf8&" +
                "serverTimezone=Asia/Shanghai");
        dds.setUsername("root");
        dds.setPassword("520927zl");
        dds.setInitialSize(3);//设置初始链接数量;
        dds.setMaxActive(5);//设置最大连接数量
        //从链接池中获取链接 异常抛出
        Connection coon = dds.getConnection();
        System.out.println(coon);
    }
}
