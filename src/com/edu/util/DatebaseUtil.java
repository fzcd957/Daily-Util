package com.edu.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//数据库的操作工具
public class DatebaseUtil {
	private static DatebaseUtil me;
	private Connection connection;
	public DatebaseUtil() {
		try {
			String driver = PropertiesParser.value("driver");
			String url = PropertiesParser.value("url");
			String user = PropertiesParser.value("user");
			String password = PropertiesParser.value("password");
			Class.forName(driver);//????什么意思
			connection = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//懒汉模式 延时加载
	public static DatebaseUtil newInstance() {
		if(me == null)
			me = new DatebaseUtil();
	return me;
	}
	
	//对数据库表的查询操作
	public ResultSet executeQuery(String sqlString) {
		PreparedStatement state;
		try {
			state = connection.prepareStatement(sqlString);
			return state.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	//对数据库的增删改操作
	public int executeUpdate(String sqslString) {
		try {
			PreparedStatement state = connection.prepareStatement(sqslString);
			return state.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
	}
	
	// 通过传过来的类类型和关键字,自动生成并执行查询指定记录的操作
//	public <T> T get(Class<?> klass,Object id){
//		//通过klass得到类表映射
//		ClassTable classTable = ClassTableFactory.getClassTable(klass);
//		if(classTable == null) {
//			return null;
//		}
//		
//		//生成SQL语句
//		
//	} 
}
