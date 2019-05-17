package sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class sqlson extends BaseProcessor {

	@Override
	public Object processResultSet(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object processResultSet2(ResultSet rs) throws SQLException {
//		try {
//			Class.forName("com.mysql.jdbc.Driver");
//			String url = "jdbc:mysql://127.0.0.1:3306/test";
//			String sql = "select * from user where id=1";
//			Connection conn = DriverManager.getConnection(url, "root", "root");
//			PreparedStatement preStatement = conn.prepareStatement(sql);
//			rs = preStatement.executeQuery();// 返回结果集ResultSet
//		} catch (SQLException e) {
//			throw new SQLException("the resultsetProcessor error!" + e.getMessage(), e.getSQLState());
//		} catch (ClassNotFoundException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		} finally {
//			if (rs != null)
//				try {
//					rs.close();
//				} catch (Exception e) {
//
//				}
//
//		}
		return null;//processResultSet2(rs);
	}

}
