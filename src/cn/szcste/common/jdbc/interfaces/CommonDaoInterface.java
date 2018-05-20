package cn.szcste.common.jdbc.interfaces;

import java.util.List;

public interface CommonDaoInterface {

	public <T> List<T> multipleDataQuery(String sql, Object[] parameterValues, CommonDaoHandler commonDaoHandler, Class<T> clazz);
	
	public <T> T singleDataQuery(String sql, Object[] parameterValues, CommonDaoHandler commonDaoHandler, Class<T> clazz);
	
}
