package com.ys.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Test {
	private Logger logger = Logger.getLogger(getClass() + "测试");
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Test tt = new Test();
//		tt.t();
		tt.t1();
	}
	
	public void t1() {
//		ApplicationContext applicationContext = new FileSystemXmlApplicationContext(System.getProperty("user.dir") + "/WebContent/WEB-INF/config/spring/applicationContext.xml");
//		Object o = applicationContext.getBean("");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection o = DriverManager.getConnection("jdbc:mysql://111.231.15.108:3306/bioanalysis", "bioanalysis", "bioanalysis");
			Statement s = o.createStatement();
			ResultSet rs = s.executeQuery("select * from user_info");
			if(rs.next()) {
				System.out.println(rs.getString("user_name"));
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void t() {
		BasicConfigurator.configure();  
        PropertyConfigurator.configure(System.getProperty("user.dir") + "/WebContent/WEB-INF/config/log4j.xml");  
		logger.debug("sdfafasfssss");
		logger.info("sdsdfs");
	}

}
