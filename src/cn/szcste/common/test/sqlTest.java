package cn.szcste.common.test;

import java.sql.ResultSet;
import java.util.List;

import cn.szcste.common.jdbc.CommonDao;
import cn.szcste.common.jdbc.handler.BeanPackageHandler;
import cn.szcste.common.jdbc.interfaces.CommonDaoHandler;


public class sqlTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*String sql = "UPDATE stu SET NAME=? WHERE id=?;";
		Object[] parameterValues = {"liming", 3};
		CommonDao commonDao = new CommonDao();
		int update = commonDao.update(sql, parameterValues);
		System.out.println(update);*/
		
		String sql = "SELECT * FROM stu;";
		Object[] parameterValues = {3};
		CommonDao commonDao = new CommonDao();
		CommonDaoHandler commonDaoHandler = new BeanPackageHandler();
		
		List<Stu> query = commonDao.multipleDataQuery(sql, null, commonDaoHandler, Stu.class);
		for (Stu stu : query) {
			System.out.println(stu);
		}
		
		Stu singleDataQuery = commonDao.singleDataQuery(sql, parameterValues, commonDaoHandler, Stu.class);
		System.out.println(singleDataQuery);
		
		commonDao.multipleDataQuery(sql, parameterValues, new CommonDaoHandler() {
			
			@Override
			public <T> T singleHandler(ResultSet executeQuery, Class<T> clazz) throws Exception {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public <T> List<T> multipleHandler(ResultSet executeQuery, Class<T> clazz) throws Exception {
				// TODO Auto-generated method stub
				return null;
			}
		}, Stu.class);
	}

}
