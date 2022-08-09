package com.atguigu4.connection;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.testng.annotations.Test;
import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

public class DruidTest {
	@Test
	public void getConnection() throws Exception{
		//1.定义一个库文件
		Properties pros = new Properties();
		//2.加载配置文件
		InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("druid.properties");
		pros.load(is);
		//3.以配置文件的方式创建数据库连接池
		DataSource source = DruidDataSourceFactory.createDataSource(pros);
		//4.从连接池中取出一个连接
		Connection conn = source.getConnection();
		System.out.println(conn);
	}
}
