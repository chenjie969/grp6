package sql;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

//import nc.jdbc.framework.mapping.IMappingMeta;
//import nc.jdbc.framework.mapping.MappingMetaManager;
//import nc.jdbc.framework.util.BeanConvertor;
//import nc.jdbc.framework.util.InOutUtil;
//import nc.vo.pub.BeanHelper;
//import nc.vo.pub.SuperVO;

import org.apache.commons.beanutils.Converter;

import com.mchange.util.ObjectCache;

/**
 * Created by IntelliJ IDEA. User: 贺扬 Date: 2005-1-14 Time: 15:10:03
 */
public class ProcessorUtils {

	private static class MethodAndTypes {
		public Method[] invokes = null;

		public int[] types = null;

		public Converter[] converters = null;

	}

	/**
	 * 结果集转换成数组
	 * 
	 * @param rs
	 * @return
	 * @throws SQLException
	 */
	static public Object[] toArray(ResultSet rs) throws SQLException {
		ResultSetMetaData meta = rs.getMetaData();
		int cols = meta.getColumnCount();
		Object[] result = new Object[cols];

		for (int i = 0; i < cols; i++) {
			result[i] = rs.getObject(i + 1);
		}

		return result;
	}

	/**
	 * 结果集转换成HashMap
	 * 
	 * @param rs
	 * @return
	 * @throws SQLException
	 */
	static public Map toMap(ResultSet rs) throws SQLException {
		// Map result = new HashMap();
		// ResultSetMetaData rsmd = rs.getMetaData();
		// int cols = rsmd.getColumnCount();
		// for (int i = 1; i <= cols; i++) {
		// result.put(rsmd.getColumnName(i).toLowerCase(), rs.getObject(i));
		// }
		//
		// return result;

		// modify by cch,becaz here getValue just use getObject
		ResultSetMetaData metaData = rs.getMetaData();
		int cols = metaData.getColumnCount();
		Map<String, Object> rsValues = new HashMap<String, Object>();
		for (int i = 1; i <= cols; i++) {
			Object value = getColumnValue(metaData.getColumnType(i), rs, i);
			String columnName = getMethodNameForMap(metaData.getColumnName(i).toLowerCase());
			rsValues.put(columnName, value);
		}
		return rsValues;
	}

	/**
	 * 结果集合转换成java bean
	 * 
	 * @param resultSet
	 * @param type
	 * @return
	 * @throws SQLException
	 */
	static public Object toBean(ResultSet resultSet, Class type, Connection conn) throws SQLException {
		if (resultSet == null)
			throw new SQLException("toBean(resultSet,type) : resultset is null");
		return createBean(type, resultSet, conn);// toBeanInner(resultSet, type,
													// null);
	}

	private static <T> T createBean(Class<T> calss, ResultSet resultSet, Connection conn) {
		T object = null;
		try {
			object = calss.newInstance();
		} catch (InstantiationException | IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			DatabaseMetaData dbmd = conn.getMetaData();
			ResultSet rsImportedKeys = dbmd.getImportedKeys(null, null, calss.getSimpleName());
			String fkColumnName = "";
			String pkTablenName = "";
			String pkColumnName = "";
			while (rsImportedKeys.next()) {
				fkColumnName = rsImportedKeys.getString("FKCOLUMN_NAME"); // 主表外键
				pkTablenName = rsImportedKeys.getString("PKTABLE_NAME"); // 外键表名称
				pkColumnName = rsImportedKeys.getString("PKCOLUMN_NAME"); // 外间表id
			}

			ResultSetMetaData metaData = resultSet.getMetaData();
			int cols = metaData.getColumnCount();
			// 获取字段
			Field[] fields = calss.getDeclaredFields();

			while (resultSet.next()) {
				// 遍历fields
				for (Field field : fields) {
					// 获取字段名
					String fieldName = field.getName();
					if (!fieldName.equalsIgnoreCase("serialVersionUID")) {
						// 获取方法名
						String setMethodName = "set" + (char) (fieldName.charAt(0) - 32) + fieldName.substring(1);// getMethodName(fieldName);
						// 获取field类型
						Class type = field.getType();
						try {
							Method method = calss.getDeclaredMethod(setMethodName, type);
							String fname = "";
							for (int i = 1; i <= cols; i++) {
								// Object value =
								// getColumnValue(metaData.getColumnType(i), rs,
								// i);
								fname = metaData.getColumnName(i).toLowerCase();
								String columnName = getMethodNameForMap(metaData.getColumnName(i).toLowerCase());
								if (columnName.equals(fieldName.toLowerCase())) {
									break;
								}
							}
							Object fieldVlaue = getFieldVlaueValue(type, fname, resultSet);

							if (null != fkColumnName && fname.equals(fkColumnName.toLowerCase())&&pkTablenName.equals(fieldName)) {// 匹配外键
								String sql = "select * from " + pkTablenName + " where " + pkColumnName + " = "
										+ fieldVlaue;
								PreparedStatement preStatement = conn.prepareStatement(sql);
								Object a = createSonBean(preStatement);
								method.invoke(object, (province)a);
							}else{
								method.invoke(object, fieldVlaue);
							}
							// System.out.println(setMethodName + ":" +
							// fieldVlaue);
							
						} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (NoSuchMethodException | SecurityException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}

				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// System.out.println();
		// System.out.println(object);
		return object;
	}

	private static Object createSonBean(PreparedStatement preStatement) {
		Object object = null;
		try {
			ResultSet resultSet = preStatement.executeQuery();
			// 返回结果集ResultSet
			Class c = Class.forName("sql.province");
			object = c.newInstance();

			ResultSetMetaData metaData = resultSet.getMetaData();
			int cols = metaData.getColumnCount();
			// 获取字段
			Field[] fields = c.getDeclaredFields();

			while (resultSet.next()) {
				// 遍历fields
				for (Field field : fields) {
					// 获取字段名
					String fieldName = field.getName();
					if (!fieldName.equalsIgnoreCase("serialVersionUID")) {
						// 获取方法名
						String setMethodName = "set" + (char) (fieldName.charAt(0) - 32) + fieldName.substring(1);// getMethodName(fieldName);
						// 获取field类型
						Class type = field.getType();
						// try {
						Method method = c.getDeclaredMethod(setMethodName, type);
						String fname = "";
						for (int i = 1; i <= cols; i++) {
							// Object value =
							// getColumnValue(metaData.getColumnType(i), rs, i);
							fname = metaData.getColumnName(i).toLowerCase();
							String columnName = getMethodNameForMap(metaData.getColumnName(i).toLowerCase());
							if (columnName.equals(fieldName.toLowerCase())) {
								break;
							}
						}
						Object fieldVlaue = getFieldVlaueValue(type, fname, resultSet);

						// System.out.println(setMethodName + ":" +
						// fieldVlaue);
						method.invoke(object, fieldVlaue);
					}

				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException | IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return object;

	}

	/**
	 * 结果集合转换成java bean
	 * 
	 * @param resultSet
	 * @param type
	 * @return
	 * @throws SQLException
	 */
	// static public Object toBean(ResultSet resultSet, Class type, IMappingMeta
	// meta) throws SQLException {
	//
	// if ((meta == null) || (resultSet == null))
	// throw new SQLException("toBean(resultSet,type,meta): meta is null or
	// resultSet is null");
	// return toBeanInner(resultSet, type, meta);
	// }

	/*
	 * 进行Bean的转换
	 */
	private static Object toBeanInner(ResultSet resultSet, Class type, IMappingMeta meta) throws SQLException {
		Object target = null;
		MethodAndTypes methodAndTypes = getBeanInvokeAndTypes(type, resultSet, meta, null);
		if (resultSet.next()) {
			target = newInstance(type);
			for (int i = 1; i <= methodAndTypes.types.length; i++) {
				Object value = getColumnValue(methodAndTypes.types[i - 1], resultSet, i);
				if (value == null)
					continue;
				Method invoke = methodAndTypes.invokes[i - 1];
				if (invoke == null) {
					// 如果是null则不赋值
					continue;
				}
				Converter converter = methodAndTypes.converters[i - 1];
				if (converter != null)
					value = converter.convert(invoke.getParameterTypes()[0], value);
				BeanHelper.invokeMethod(target, invoke, value);
			}
		} // end if
		return target;
	}

	/**
	 * 结果集转换成java bean 数组
	 * 
	 * @param resultSet
	 * @param type
	 * @return
	 * @throws SQLException
	 */
	@SuppressWarnings("unchecked")
	static public List toBeanList(ResultSet resultSet, Class type, Connection conn) throws SQLException {
		if (resultSet == null)
			throw new SQLException("toBeanList(resultSet,type) : resultset is null");
		return createBeanList(type, resultSet);// toBeanListInner(resultSet,
												// type, null, null);
	}

	private static <T> List<T> createBeanList(Class<T> calss, ResultSet resultSet) {
		List<T> ts = new ArrayList<>();
		// 获取字段
		Field[] fields = calss.getDeclaredFields();
		try {
			ResultSetMetaData metaData = resultSet.getMetaData();
			// DatabaseMetaData dbmd = (DatabaseMetaData)
			// resultSet.getMetaData();

			int cols = metaData.getColumnCount();
			while (resultSet.next()) {
				T object = calss.newInstance();
				// 遍历fields
				for (Field field : fields) {
					// 获取字段名
					String fieldName = field.getName();
					if (!fieldName.equalsIgnoreCase("serialVersionUID")) {
						// 获取方法名
						String setMethodName = "set" + (char) (fieldName.charAt(0) - 32) + fieldName.substring(1);// getMethodName(fieldName);
						// 获取field类型
						Class type = field.getType();
						try {
							Method method = calss.getDeclaredMethod(setMethodName, type);
							String fname = "";
							for (int i = 1; i <= cols; i++) {
								String tablename = metaData.getTableName(1);
								// dbmd.getSuperTables("test", null, tablename);
								// Object value =
								// getColumnValue(metaData.getColumnType(i), rs,
								// i);
								fname = metaData.getColumnName(i).toLowerCase();
								String columnName = getMethodNameForMap(metaData.getColumnName(i).toLowerCase());
								if (columnName.equals(fieldName)) {
									break;
								}
							}
							Object fieldVlaue = getFieldVlaueValue(type, fname, resultSet);

							method.invoke(object, fieldVlaue);
						} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (NoSuchMethodException | SecurityException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
				ts.add(object);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		// System.out.println();
		// System.out.println(object);
		return ts;
	}

	// @SuppressWarnings("unchecked")
	// private static List toBeanListInner(ResultSet resultSet, Class type,
	// IMappingMeta meta, String columns[])
	// throws SQLException {
	// MethodAndTypes methodAndTypes = getBeanInvokeAndTypes(type, resultSet,
	// meta, columns);
	// List list = new ArrayList();
	// while (resultSet.next()) {
	// Object target = newInstance(type);
	// for (int i = 1; i <= methodAndTypes.types.length; i++) {
	// Object value = getColumnValue(methodAndTypes.types[i - 1], resultSet, i);
	// if (value == null)
	// continue;
	// Method invoke = methodAndTypes.invokes[i - 1];
	// if (invoke == null) {
	// // 如果是null则不赋值
	// continue;
	// }
	// Converter converter = methodAndTypes.converters[i - 1];
	// if (converter != null)
	// value = converter.convert(invoke.getParameterTypes()[0], value);
	// BeanHelper.invokeMethod(target, invoke, value);
	// }
	// list.add(target);
	// }
	// return list;
	// }

	private static MethodAndTypes getBeanInvokeAndTypes(Class type, ResultSet resultSet, IMappingMeta meta,
			String[] columns) throws SQLException {
		MethodAndTypes retResult = new MethodAndTypes();

		Object bean = newInstance(type);
		boolean isSuperBean = false;
		if (bean instanceof SuperVO) {
			isSuperBean = true;
		}
		ResultSetMetaData metaData = resultSet.getMetaData();
		int cols = metaData.getColumnCount();
		Method[] invokes = new Method[cols];
		String[] colName = new String[cols];
		Converter[] converters = new Converter[cols];
		int[] types = new int[cols];
		for (int i = 0; i < cols; i++) {
			types[i] = metaData.getColumnType(i + 1);
			if (columns != null)
				colName[i] = columns[i].toLowerCase();
			else
				colName[i] = metaData.getColumnName(i + 1).toLowerCase();
			String propName = colName[i];
			if (meta != null) {
				propName = MappingMetaManager.getMapingMeta(meta).getAttributeName(colName[i]);
				if (propName == null)
					continue;
				propName = propName.toLowerCase();
			}

			if (isSuperBean) {
				invokes[i] = getSuperBeanInvokeMethod(bean, propName);
			} else {
				invokes[i] = BeanHelper.getMethod(bean, propName);
			}
			if (invokes[i] != null)
				converters[i] = BeanConvertor.getConVerter(invokes[i].getParameterTypes()[0]);
		}
		retResult.invokes = invokes;
		retResult.types = types;
		retResult.converters = converters;
		return retResult;
	}

	private static Method getSuperBeanInvokeMethod(Object bean, String colName) {

		Method m = BeanHelper.getMethod(bean, colName);
		if (m != null)
			return m;
		String pkFiledName = ((SuperVO) bean).getPKFieldName();
		if (pkFiledName == null)
			return null;
		pkFiledName = pkFiledName.toLowerCase();
		if (pkFiledName.equals(colName)) {
			return BeanHelper.getMethod(bean, "primarykey");
		}
		return null;

	}
	//
	// @SuppressWarnings("unchecked")
	// static public List toBeanList(ResultSet resultSet, Class type, int skip,
	// int size) throws SQLException {
	// MethodAndTypes methodAndTypes = getBeanInvokeAndTypes(type, resultSet,
	// null, null);
	// List list = new ArrayList();
	// int index = -1;
	// while (index < skip && resultSet.next()) {
	// index++;
	// }
	// if (index < skip)
	// return list;
	// int offset = 0;
	// do {
	// offset++;
	// Object target = newInstance(type);
	// for (int i = 1; i <= methodAndTypes.types.length; i++) {
	// Object value = getColumnValue(methodAndTypes.types[i - 1], resultSet, i);
	// if (value == null)
	// continue;
	// Method invoke = methodAndTypes.invokes[i - 1];
	// if (invoke == null) {
	// // 如果是null则不赋值
	// continue;
	// }
	// Converter converter = methodAndTypes.converters[i - 1];
	// if (converter != null)
	// value = converter.convert(invoke.getParameterTypes()[0], value);
	// BeanHelper.invokeMethod(target, invoke, value);
	// // populate(target, value, methodAndTypes.invokes[i - 1]);
	// }
	// list.add(target);
	// } while (resultSet.next() && offset < size);
	//
	// return list;
	// }

	/**
	 * 结果集转换成java bean 数组
	 * 
	 * @param resultSet
	 * @param type
	 * @return
	 * @throws SQLException
	 */
	// static public List toBeanList(ResultSet resultSet, Class type,
	// IMappingMeta meta) throws SQLException {
	// if ((meta == null) || (resultSet == null))
	// throw new SQLException("toBeanList(resultSet,type,meta): meta is null or
	// resultSet is null");
	// return toBeanListInner(resultSet, type, meta, null);
	// }
	//
	// /**
	// * 结果集转换成java bean 数组
	// *
	// * @param resultSet
	// * @param type
	// * @return
	// * @throws SQLException
	// */
	// @SuppressWarnings("unchecked")
	// static public List toBeanList(ResultSet resultSet, Class type,
	// IMappingMeta meta, String columns[])
	// throws SQLException {
	// if ((meta == null) || (resultSet == null))
	// throw new SQLException("toBeanList(resultset,type,meta,columns): meta is
	// null or resultSet is null");
	// return toBeanListInner(resultSet, type, meta, columns);
	// }

	/**
	 * 结果集转换成向量集合
	 * 
	 * @param rs
	 * @return
	 * @throws SQLException
	 */
	@SuppressWarnings("unchecked")
	static public Vector toVector(ResultSet rs) throws SQLException {
		Vector v = new Vector();
		ResultSetMetaData rsmd = rs.getMetaData();
		int nColumnCount = rsmd.getColumnCount();

		while (rs.next()) {
			Vector tmpV = new Vector();
			for (int i = 1; i <= nColumnCount; i++) {
				Object o;
				if (rsmd.getColumnType(i) == Types.CHAR || rsmd.getColumnType(i) == Types.VARCHAR) {
					o = rs.getString(i);

				} else {
					o = rs.getObject(i);
				}

				tmpV.addElement(o);
			}
			v.addElement(tmpV);
		}
		return v;
	}

	private static String getMethodName(String fieldName) throws SQLException {
		String s2 = fieldName.substring(0, 2);
		String setMethodName = "";
		String methodName = "";
		if (fieldName.equals("id")) {
			setMethodName = "set" + (char) (fieldName.charAt(0) - 32) + fieldName.substring(1);
		} else if (s2.equals("cf")) {
			methodName = setMethodName.substring(2, setMethodName.length());
			setMethodName = "set" + (char) (methodName.charAt(0) - 32) + methodName.substring(1);
		} else {
			methodName = setMethodName.substring(1, setMethodName.length());
			setMethodName = "set" + (char) (methodName.charAt(0) - 32) + methodName.substring(1);
		}
		return setMethodName;
	}

	/**
	 * 
	 * @param fieldName
	 *            fname ==> name
	 * @return
	 * @throws SQLException
	 */
	private static String getMethodNameForMap(String fieldName) throws SQLException {
		String s2 = fieldName.substring(0, 2);
		String setMethodName = fieldName;
		if (s2.equals("cf")) {
			setMethodName = fieldName.substring(2, fieldName.length());
		} else if (s2.contains("f")) {
			setMethodName = fieldName.substring(1, fieldName.length());
		}
		return setMethodName;
	}

	/**
	 * 
	 * @param type
	 * @param fieldName
	 * @param resultSet
	 * @return
	 * @throws SQLException
	 */
	private static Object getFieldVlaueValue(Class type, String fieldName, ResultSet resultSet) throws SQLException {
		Object fieldVlaue = "";
		if (type.toString().equals("int") || type.toString().equals("Integer"))
			fieldVlaue = Integer.parseInt(resultSet.getString(fieldName));
		else if (type.toString().equals("long") || type.toString().equals("Long"))
			fieldVlaue = Long.parseLong(resultSet.getString(fieldName));
		else if (type.toString().equals("double") || type.toString().equals("Double"))
			fieldVlaue = Double.parseDouble(resultSet.getString(fieldName));
		else
			fieldVlaue = resultSet.getString(fieldName);

		return fieldVlaue;
	}

	public static Object getColumnValue(int type, ResultSet resultSet, int i) throws SQLException {
		Object value;
		switch (type) {
		case Types.VARCHAR:
		case Types.CHAR:
			value = resultSet.getString(i);
			break;
		// case Types.INTEGER:
		// case Types.DECIMAL:
		// value = new Integer(resultSet.getInt(i));
		// break;
		case Types.INTEGER:
		case Types.BIGINT:
			value = new Integer(resultSet.getInt(i));
			break;
		case Types.DECIMAL:
			value = new Double(resultSet.getDouble(i));
			break;
		// case Types.BLOB:
		// case Types.LONGVARBINARY:
		// case Types.VARBINARY:
		// case Types.BINARY:
		// value = InOutUtil.deserialize(resultSet.getBytes(i));
		// break;
		case Types.CLOB:
			value = getClob(resultSet, i);
			break;
		default:
			value = resultSet.getObject(i);
			break;
		}
		return value;
	}

	/**
	 * @param c
	 * @return
	 * @throws SQLException
	 */
	static private Object newInstance(Class c) throws SQLException {
		try {
			return c.newInstance();

		} catch (InstantiationException e) {
			throw new SQLException("Cannot create " + c.getName() + ": " + e.getMessage());

		} catch (IllegalAccessException e) {
			throw new SQLException("Cannot create " + c.getName() + ": " + e.getMessage());
		}
	}

	/**
	 * @param rs
	 * @param columnIndex
	 * @return
	 * @throws SQLException
	 */
	static public String getClob(ResultSet rs, int columnIndex) throws SQLException {
		Reader rsReader = rs.getCharacterStream(columnIndex);
		if (rsReader == null)
			return null;
		BufferedReader reader = new BufferedReader(rsReader);
		// Reader reader = rs.getCharacterStream(columnIndex);
		StringBuffer buffer = new StringBuffer();
		try {
			while (true) {
				String c = reader.readLine();
				if (c == null) {
					break;
				}
				buffer.append(c);
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return buffer.toString();
	}

	/**
	 * @param rs
	 * @param columnIndex
	 * @return
	 * @throws SQLException
	 */
	static public byte[] getBlob(ResultSet rs, int columnIndex) throws SQLException {
		return rs.getBytes(columnIndex);
	}
}
