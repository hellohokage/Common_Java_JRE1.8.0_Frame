package cn.szcste.common.jdbc.handler;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import cn.szcste.common.jdbc.interfaces.CommonDaoHandler;

public class BeanPackageHandler implements CommonDaoHandler {

	@Override
	public <T> List<T> multipleHandler(ResultSet executeQuery, Class<T> clazz) throws Exception {

		ResultSetMetaData metaData = executeQuery.getMetaData();

		int columnCount = metaData.getColumnCount();

		List<T> list = new ArrayList<T>();

		if (clazz != null) {
			T bean = null;
			while (executeQuery.next()) {
				bean = clazz.newInstance();
				for (int column = 1; column <= columnCount; column++) {
					String columnName = metaData.getColumnName(column);
					Object value = executeQuery.getObject(columnName);
					BeanUtils.setProperty(bean, columnName, value);
				}
				list.add(bean);
			}
		}

		return list;
	}

	@Override
	public <T> T singleHandler(ResultSet executeQuery, Class<T> clazz) throws Exception {
		// TODO Auto-generated method stub
		ResultSetMetaData metaData = executeQuery.getMetaData();

		T bean = null;

		if (clazz != null) {

			bean = clazz.newInstance();

			int columnCount = metaData.getColumnCount();

			if(executeQuery.next()) {
				for (int column = 1; column <= columnCount; column++) {
					String columnName = metaData.getColumnName(column);
					Object value = executeQuery.getObject(columnName);
					BeanUtils.setProperty(bean, columnName, value);
				}
			}	
		}

		return bean;
	}
}
