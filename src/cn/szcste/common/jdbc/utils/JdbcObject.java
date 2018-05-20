package cn.szcste.common.jdbc.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class JdbcObject {
	private PreparedStatement preparedStatement;
	private Connection connection;
	private String sql;
	private Object[] parameterValues;

	public PreparedStatement getPreparedStatement() {
		return preparedStatement;
	}

	public void setPreparedStatement(PreparedStatement preparedStatement) {
		this.preparedStatement = preparedStatement;
	}

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	public String getSql() {
		return sql;
	}

	public void setSql(String sql) {
		this.sql = sql;
	}

	public Object[] getParameterValues() {
		return parameterValues;
	}

	public void setParameterValues(Object[] parameterValues) {
		this.parameterValues = parameterValues;
	}

	public JdbcObject(PreparedStatement preparedStatement, Connection connection, String sql,
			Object[] parameterValues) {
		super();
		this.preparedStatement = preparedStatement;
		this.connection = connection;
		this.sql = sql;
		this.parameterValues = parameterValues;
	}

	public JdbcObject(String sql, Object[] parameterValues) {
		super();
		this.sql = sql;
		this.parameterValues = parameterValues;
	}

	public JdbcObject(String sql) {
		super();
		this.sql = sql;
	}

	
}
