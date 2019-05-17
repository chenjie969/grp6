package sql;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by IntelliJ IDEA.
 * User: 贺扬<br>
 * Date: 2005-1-14<br>
 * Time: 13:43:06<br>
 * 数组处理器，返回一个对象数组，结果集中只有一行数据，其中结果集中每一列对应数组的一个元素。
 */
public class ArrayProcessor extends  BaseProcessor {
	
    /**
	 * <code>serialVersionUID</code> 的注释
	 */
	private static final long serialVersionUID = 2544096068863958453L;

	public Object processResultSet(ResultSet rs) throws SQLException {
        return rs.next() ? ProcessorUtils.toArray(rs) : null;     
    }

	@Override
	public Object processResultSet2(ResultSet rs) throws SQLException {
		return rs.next() ? ProcessorUtils.toArray(rs) : null;
	}

}
