package cn.szcste.common.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JdbcUtil {
	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		
		ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource("second_config");

		return comboPooledDataSource.getConnection();
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
