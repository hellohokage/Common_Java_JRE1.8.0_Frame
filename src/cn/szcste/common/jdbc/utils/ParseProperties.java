package cn.szcste.common.jdbc.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import cn.szcste.common.jdbc.JdbcUtil;

public class ParseProperties {

	private Properties properties;

	public String driver;
	public String url;
	public String user;
	public String password;

	public ParseProperties() {
		super();
		
		
		InputStream resourceAsStream = JdbcUtil.class.getClassLoader().getResourceAsStream("db.properties");

		properties = new Properties();

		try {
			properties.load(resourceAsStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.driver = properties.getProperty("jdbc.driver");
		this.url =  properties.getProperty("jdbc.url");
		this.user = properties.getProperty("jdbc.username");
		this.password = properties.getProperty("jdbc.password");
	}

}
