package cn.szcste.common.jdbc.handler;

import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;

import cn.szcste.common.jdbc.JdbcUtil;
import cn.szcste.common.jdbc.utils.JdbcObject;

public class SQLHandler {
	public static void prepareSQL(JdbcObject jdbcObject) throws Exception {

		Object[] parameterValues = jdbcObject.getParameterValues();

		jdbcObject.setConnection(JdbcUtil.getConnection());

		jdbcObject.setPreparedStatement(jdbcObject.getConnection().prepareStatement(jdbcObject.getSql()));

		PreparedStatement prepareStatement = jdbcObject.getPreparedStatement();

		ParameterMetaData parameterMetaData = prepareStatement.getParameterMetaData();

		int parameterCount = parameterMetaData.getParameterCount();

		if (parameterValues != null) {
			if (parameterValues.length > 0) {
				for (int parameterIndex = 0; parameterIndex < parameterCount; parameterIndex++) {
					prepareStatement.setObject(parameterIndex + 1, parameterValues[parameterIndex]);
				}
			}
		}
	}
}
