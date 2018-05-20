package cn.szcste.common.jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cn.szcste.common.jdbc.handler.SQLHandler;
import cn.szcste.common.jdbc.interfaces.CommonDaoHandler;
import cn.szcste.common.jdbc.interfaces.CommonDaoInterface;
import cn.szcste.common.jdbc.utils.JdbcObject;

public class CommonDao implements CommonDaoInterface {

	public int update(String sql, Object[] parameterValues) {

		int executeUpdate = 0;

		JdbcObject jdbcObject = new JdbcObject(sql, parameterValues);

		PreparedStatement preparedStatement = null;

		try {
			SQLHandler.prepareSQL(jdbcObject);

			preparedStatement = jdbcObject.getPreparedStatement();

			executeUpdate = preparedStatement.executeUpdate();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtil.closeAll(jdbcObject.getConnection(), preparedStatement);
		}

		return executeUpdate;
	}

	public <T> List<T> multipleDataQuery(String sql, Object[] parameterValues, CommonDaoHandler commonDaoHandler, Class<T> clazz) {

		JdbcObject jdbcObject = new JdbcObject(sql, parameterValues);

		PreparedStatement preparedStatement = null;

		List<T> list = new ArrayList<T>();

		try {
			SQLHandler.prepareSQL(jdbcObject);

			preparedStatement = jdbcObject.getPreparedStatement();

			ResultSet executeQuery = preparedStatement.executeQuery();

			list = commonDaoHandler.multipleHandler(executeQuery, clazz);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtil.closeAll(jdbcObject.getConnection(), preparedStatement);
		}

		return list;
	}

	public <T> T singleDataQuery(String sql, Object[] parameterValues, CommonDaoHandler commonDaoHandler, Class<T> clazz) {

		JdbcObject jdbcObject = new JdbcObject(sql, parameterValues);

		PreparedStatement preparedStatement = null;

		T newInstance = null;
		
		try {
			newInstance = clazz.newInstance();
			
			SQLHandler.prepareSQL(jdbcObject);

			preparedStatement = jdbcObject.getPreparedStatement();

			ResultSet executeQuery = preparedStatement.executeQuery();

			newInstance = commonDaoHandler.singleHandler(executeQuery, clazz);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtil.closeAll(jdbcObject.getConnection(), preparedStatement);
		}

		return newInstance;
	}

}
