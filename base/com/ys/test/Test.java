package com.ys.test;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Test {
	private Logger logger = Logger.getLogger(getClass() + "测试");
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BasicConfigurator.configure();  
        PropertyConfigurator.configure(System.getProperty("user.dir") + "/WebContent/WEB-INF/config/log4j.xml");  
          
        
		Test tt = new Test();
		tt.t();

	}
	
	public void t() {
		logger.debug("sdfafasfssss");
		logger.info("sdsdfs");
	}

}
