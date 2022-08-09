package com.atguigu4.connection;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.testng.annotations.Test;

import javax.sql.DataSource;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class DBCPTest {
	/**
	 * @Description 测试DBCP的数据库连接池技术
	 * @author shkstart
	 * @throws SQLException 
	 * @date 下午3:20:50
	 */
	//方式一：不推荐
	@Test
	public void testGetConnection() throws SQLException{
		//1.创建了DBCP的数据库连接池
		BasicDataSource source = new BasicDataSource();
		//2.设置基本信息
		source.setDriverClassName("com.mysql.cj.jdbc.Driver");
		source.setUrl("jdbc:mysql://localhost:3306/test?" +
				"characterEncoding=utf8&useSSL=false&serverTimezone=UTC" +
				"&rewriteBatchedStatements=true" );
		source.setUsername("root");
		source.setPassword("abc123");
		//3.还可以设置其他涉及数据库连接池管理的相关属性：
		source.setInitialSize(10);
		source.setMaxActive(10);
		//。。。
		Connection conn = source.getConnection();
		System.out.println(conn);
	}

	//方式二：推荐：使用配置文件
	@Test
	public void testGetConnection1() throws Exception{
		Properties pros = new Properties();
		//方式1：
//		InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("dbcp.properties");
		//方式2：
		FileInputStream is = new FileInputStream(new File("src/dbcp.properties"));
		pros.load(is);
		DataSource source = BasicDataSourceFactory.createDataSource(pros);
		Connection conn = source.getConnection();
		System.out.println(conn);
	}
}
