package sql;

import java.io.Serializable;


/**
 * @author hey
 *
 * 值对象与数据库的映射接口
 *
 */
public interface IMappingMeta extends Serializable {
    /**
     * 得到该数据库表的主键名称
     * @return 主键名称
     *
     */
    public abstract String getPrimaryKey();

    /**
     * 得到值对象对应的表名
     * @return  表名
     */
    public abstract String getTableName();

    /**
     * 得到值对象的属性数组
     * @return
     */
    public abstract String[] getAttributes();

    /**
     * 得到值对象的属性数组一一对应的表的列名数组
     * @return
     */
    public abstract String[] getColumns();

}