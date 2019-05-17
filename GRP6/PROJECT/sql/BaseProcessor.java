package sql;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User: 贺扬<br>
 * Date: 2005-1-14<br>
 * Time: 13:43:06<br>
 * 抽象结果集处理对象，用于自动关闭ResultSet对象，子类需要实现processResultSet方法
 */
public abstract class BaseProcessor implements ResultSetProcessor {

	public Object handleResultSet(ResultSet rs, Connection conn) throws SQLException {
		if (rs == null)
			throw new IllegalArgumentException("resultset parameter can't be null");
		try {
			return processResultSet(rs,conn);
		} catch (SQLException e) {
			throw new SQLException("the resultsetProcessor error!" + e.getMessage(), e.getSQLState());
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (Exception e) {

				}
		}

	}

	/**
	 * 处理结果集返回需要的对象
	 *
	 * @param rs
	 *            结果集
	 * @return 需要的对象
	 * @throws SQLException如果发生错误
	 */
	public abstract Object processResultSet(ResultSet rs, Connection conn) throws SQLException;

	/**
	 * 处理结果集返回需要的对象
	 * 
	 * @param rs
	 *            结果集
	 * @return 需要的对象
	 * @throws SQLException如果发生错误
	 */
	public abstract Object processResultSet2(ResultSet rs,Connection conn) throws SQLException;

	public Object executeQuery(String sql, BaseProcessor processor,Connection conn) throws SQLException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		String url = "jdbc:mysql://127.0.0.1:3306/test";
		conn = DriverManager.getConnection(url, "root", "root");
		
		PreparedStatement preStatement = conn.prepareStatement(sql);
		ResultSet rs = preStatement.executeQuery();// 返回结果集ResultSet
		try {
			return processor.processResultSet2(rs,conn);
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (Exception e) {

				}
		}
	}

}
