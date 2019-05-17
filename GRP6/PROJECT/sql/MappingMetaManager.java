package sql;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @nopublish Created by IntelliJ IDEA. User: hey Date: 2005-12-12 Time:
 *            11:30:28 To change this template use File | Settings | File
 *            Templates.
 * fangj 20080407进行修改，对于实现了IAttributeMapping接口的类不在需要进行缓存
 */
public class MappingMetaManager {
	private static Map<Object, AttributeMapping> metaCache = new ConcurrentHashMap<Object, AttributeMapping>();

	static public AttributeMapping getMapingMeta(IMappingMeta meta) {
		if (meta instanceof IAttributeMapping) {
			return ((IAttributeMapping) meta).getAttributeMapping();
		} else {
			String key = meta.getClass().getName() + meta.getTableName();
			AttributeMapping value = metaCache.get(key);
			if (value == null) {
				value = new AttributeMapping();
				value.addMapping(meta.getAttributes(), meta.getColumns());
				metaCache.put(key, value);
			}
			return value;
		}
	}
}
