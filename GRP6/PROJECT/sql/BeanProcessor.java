package sql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by IntelliJ IDEA.
 * User: 贺扬<br>
 * Date: 2005-1-14<br>
 * Time: 15:29:48<br>
 *
 * 值对象处理器，返回一个JavaBean，结果集中只有一行数据，该处理器能自动把结果集中的值按列的名称映射到javaBean中，如结果集中有名称为”name”的字段，那么只要该java对象中有getName()方法就能把结果集合中”name”对应的值映射到对象中
 */
public class BeanProcessor extends BaseProcessor {

    /**
	 * <code>serialVersionUID</code> 的注释
	 */
	private static final long serialVersionUID = -6448041138120901285L;
	private Class type = null;

    public BeanProcessor(Class type) {
        this.type = type;
    }

	@Override
	public Object processResultSet(ResultSet rs, Connection conn) throws SQLException {
		 return ProcessorUtils.toBean(rs, this.type,conn) ;
	}

	@Override
	public Object processResultSet2(ResultSet rs, Connection conn) throws SQLException {
		 return ProcessorUtils.toBean(rs, this.type,conn) ;
	}

}
