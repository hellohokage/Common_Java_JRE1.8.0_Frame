package cn.szcste.common.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import cn.szcste.common.jdbc.utils.ParseProperties;

public class JdbcUtil {
	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub

		ParseProperties parseProperties = new ParseProperties();

		Class.forName(parseProperties.driver);

		Connection connection = DriverManager.getConnection(parseProperties.url, parseProperties.user,
				parseProperties.password);

		return connection;
	}

	public static void closeAll(Connection connection, PreparedStatement prepareStatement) {
		try {
			if (connection != null) {
				connection.close();
			}
			if (prepareStatement != null) {
				prepareStatement.close();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
