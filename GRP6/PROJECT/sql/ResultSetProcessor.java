package sql;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by IntelliJ IDEA.
 * User: 贺扬
 * Date: 2005-1-14
 * Time: 13:41:47
 * 结果集处理接口
 */
public interface ResultSetProcessor extends Serializable {
	
    /**
     * 处理结果集并返回需要的数据结构
     * @param rs      数据库结果集
     * @return        结果对象
     * @throws SQLException如果出错抛出
     */
    public Object handleResultSet(ResultSet rs,Connection  conn) throws SQLException;
    
    /** 执行一个无参数的SQL查询
	 * 
	 * @param sql
	 *            查询的SQL语句
	 * @param processor
	 *            结果集处理器
	 * @return
     * @throws SQLException ss
	 * @throws BusinessException
	 *             查询出错则抛出异常
	 */
	public Object executeQuery(String sql, BaseProcessor processor,Connection  conn) throws SQLException;
}
