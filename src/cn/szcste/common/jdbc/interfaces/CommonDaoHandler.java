package cn.szcste.common.jdbc.interfaces;

import java.sql.ResultSet;
import java.util.List;

public interface CommonDaoHandler {
	
	public <T> T singleHandler(ResultSet executeQuery, Class<T> clazz) throws Exception;
	
	public <T> List<T> multipleHandler(ResultSet executeQuery, Class<T> clazz) throws Exception;
}
