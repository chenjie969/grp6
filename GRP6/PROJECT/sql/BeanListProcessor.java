package sql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * User: 贺扬<br>
 * Date: 2005-1-14<br>
 * Time: 15:31:45 <br>
 * 值对象集合处理器，返回一个ArrayList集合，集合中的每一个元素是一个javaBean,每个javaBean对应结果集合中一行数据，其中每个JavaBean中的数据映射关系和BeanProcess同理
 */
public class BeanListProcessor extends  BaseProcessor {
    /**
	 * <code>serialVersionUID</code> 的注释
	 */
	private static final long serialVersionUID = 2260963403278654726L;
	private Class type = null;

    public BeanListProcessor(Class type) {
        this.type = type;
    }

    public Object processResultSet(ResultSet rs, Connection conn) throws SQLException {
        return ProcessorUtils.toBeanList(rs, type,conn);
    }

	@Override
	public Object processResultSet2(ResultSet rs, Connection conn) throws SQLException {
		return ProcessorUtils.toBeanList(rs, type,conn);
	}
}
