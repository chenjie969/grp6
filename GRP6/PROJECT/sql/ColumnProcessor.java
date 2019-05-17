package sql;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by IntelliJ IDEA. User: 贺扬 Date: 2005-1-14 Time: 16:03:36
 * 列值处理器，返回一个Java对象，结果集中只有一行数据，该对象对应与结果集中某一列的值，该处理器通过结果集列的序号或名称来确定列
 */
public class ColumnProcessor extends BaseProcessor {

	/**
	 * <code>serialVersionUID</code> 的注释
	 */
	private static final long serialVersionUID = -2578646856668989095L;

	private int columnIndex = 1;

	private String columnName = null;

	public ColumnProcessor() {
		super();
	}

	public ColumnProcessor(int columnIndex) {
		this.columnIndex = columnIndex;
	}

	public ColumnProcessor(String columnName) {
		this.columnName = columnName;
	}

	public Object processResultSet(ResultSet rs) throws SQLException {

		if (rs.next()) {
			if (this.columnName == null) {
				return rs.getObject(this.columnIndex);
			} else {
				return rs.getObject(this.columnName);
			}

		} else {
			return null;
		}
	}

	@Override
	public Object processResultSet2(ResultSet rs) throws SQLException {
		if (rs.next()) {
			if (this.columnName == null) {
				return rs.getObject(this.columnIndex);
			} else {
				return rs.getObject(this.columnName);
			}

		} else {
			return null;
		}
	}
}
