package sql;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

public class BeanHelper
{
  protected static final Object[] NULL_ARGUMENTS = new Object[0];

  private static Map<String, ReflectionInfo> cache = new HashMap();

  private static BeanHelper bhelp = new BeanHelper();

  private ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();

  public static BeanHelper getInstance() {
    return bhelp;
  }

  public static List<String> getPropertys(Object bean)
  {
    return Arrays.asList(getInstance().getPropertiesAry(bean));
  }

  public String[] getPropertiesAry(Object bean)
  {
    ReflectionInfo reflectionInfo = null;
    this.rwl.readLock().lock();
    try {
      reflectionInfo = cachedReflectionInfo(bean.getClass());
      Set propertys = new HashSet();
      for (String key : reflectionInfo.writeMap.keySet()) {
        if (reflectionInfo.writeMap.get(key) != null) {
          propertys.add(key.toLowerCase());
        }
      }
      ??? = (String[])propertys.toArray(new String[0]);
      return ???; } finally { this.rwl.readLock().unlock(); } throw localObject;
  }

  public static Object getProperty(Object bean, String propertyName) {
    String errStr;
    try {
      Method method = getInstance().getMethod(bean, propertyName, false);
      if ((propertyName != null) && (method == null))
        return null;
      if (method == null) {
        return null;
      }
      return method.invoke(bean, NULL_ARGUMENTS);
    } catch (Exception e) {
      errStr = "Failed to get property: " + propertyName;
    }
    throw new RuntimeException(errStr, e);
  }

  public static Method getMethod(Object bean, String propertyName)
  {
    return getInstance().getMethod(bean, propertyName, true);
  }

  private Method getMethod(Object bean, String propertyName, boolean isSetMethod)
  {
    Method method = null;
    this.rwl.readLock().lock();
    ReflectionInfo reflectionInfo = null;
    try {
      reflectionInfo = cachedReflectionInfo(bean.getClass());
      if (isSetMethod)
        method = reflectionInfo.getWriteMethod(propertyName);
      else {
        method = reflectionInfo.getReadMethod(propertyName);
      }
      Method localMethod1 = method;
      return localMethod1; } finally { this.rwl.readLock().unlock(); } throw localObject;
  }

  private ReflectionInfo cachedReflectionInfo(Class<?> beanCls)
  {
    return cacheReflectionInfo(beanCls, null);
  }

  private ReflectionInfo cacheReflectionInfo(Class<?> beanCls, List<PropDescriptor> pdescriptor)
  {
    String key = beanCls.getName();
    ReflectionInfo reflectionInfo = (ReflectionInfo)cache.get(key);
    if (reflectionInfo == null) {
      this.rwl.readLock().unlock();
      this.rwl.writeLock().lock();
      this.rwl.readLock().lock();
      try {
        reflectionInfo = (ReflectionInfo)cache.get(key);
        if (reflectionInfo == null) {
          reflectionInfo = new ReflectionInfo();
          List propDesc = new ArrayList();
          if (pdescriptor != null)
            propDesc.addAll(pdescriptor);
          else {
            propDesc = getPropertyDescriptors(beanCls);
          }
          for (PropDescriptor pd : propDesc) {
            Method readMethod = pd.getReadMethod(beanCls);
            Method writeMethod = pd.getWriteMethod(beanCls);
            if (readMethod != null) {
              reflectionInfo.readMap.put(pd.getName().toLowerCase(), readMethod);
            }

            if (writeMethod != null) {
              reflectionInfo.writeMap.put(pd.getName().toLowerCase(), writeMethod);
            }
          }
          cache.put(key, reflectionInfo);
        }
      } finally {
        this.rwl.writeLock().unlock();
      }
    }
    return reflectionInfo;
  }

  public static void invokeMethod(Object bean, Method method, Object value)
  {
    try {
      if (method == null)
        return;
      Object[] arguments = { value };
      method.invoke(bean, arguments);
    } catch (Exception e) {
      String errStr = "Failed to set property: " + method.getName();
      throw new RuntimeException(errStr, e);
    }
  }

  public static void setProperty(Object bean, String propertyName, Object value)
  {
    try {
      Method method = getInstance().getMethod(bean, propertyName, true);
      if ((propertyName != null) && (method == null))
      {
        return;
      }if (method == null) {
        return;
      }
      Object[] arguments = { value };
      method.invoke(bean, arguments);
    } catch (Exception e) {
      String errStr = "Failed to set property: " + propertyName + " on bean: " + bean.getClass().getName() + " with value:" + value;

      throw new RuntimeException(errStr, e);
    }
  }

  public Method[] getAllGetMethod(Class<?> beanCls, String[] fieldNames)
  {
    Method[] methods = null;
    ReflectionInfo reflectionInfo = null;
    List al = new ArrayList();
    this.rwl.readLock().lock();
    try {
      reflectionInfo = cachedReflectionInfo(beanCls);
    } finally {
      this.rwl.readLock().unlock();
    }
    for (String str : fieldNames) {
      al.add(reflectionInfo.getReadMethod(str));
    }
    methods = (Method[])al.toArray(new Method[al.size()]);
    return methods;
  }

  private List<PropDescriptor> getPropertyDescriptors(Class<?> clazz) {
    List descList = new ArrayList();
    List superDescList = new ArrayList();
    List propsList = new ArrayList();
    Class propType = null;
    for (Method method : clazz.getDeclaredMethods()) {
      if (method.getName().length() < 4) {
        continue;
      }
      if ((method.getName().charAt(3) < 'A') || (method.getName().charAt(3) > 'Z'))
      {
        continue;
      }
      if (method.getName().startsWith("set")) {
        if (method.getParameterTypes().length != 1) {
          continue;
        }
        if (method.getReturnType() != Void.TYPE) {
          continue;
        }
        propType = method.getParameterTypes()[0]; } else {
        if ((!method.getName().startsWith("get")) || 
          (method.getParameterTypes().length != 0)) {
          continue;
        }
        propType = method.getReturnType();
      }

      String propname = method.getName().substring(3, 4).toLowerCase();
      if (method.getName().length() > 4) {
        propname = propname + method.getName().substring(4);
      }
      if (propname.equals("class")) {
        continue;
      }
      if (propsList.contains(propname)) {
        continue;
      }
      propsList.add(propname);

      descList.add(new PropDescriptor(clazz, propType, propname));
    }

    Class superClazz = clazz.getSuperclass();
    if (superClazz != null) {
      superDescList = getPropertyDescriptors(superClazz);
      descList.addAll(superDescList);
      if (!isBeanCached(superClazz)) {
        cacheReflectionInfo(superClazz, superDescList);
      }
    }
    return descList;
  }

  private boolean isBeanCached(Class<?> bean) {
    String key = bean.getName();
    ReflectionInfo cMethod = (ReflectionInfo)cache.get(key);
    if (cMethod == null) {
      this.rwl.readLock().lock();
      try {
        cMethod = (ReflectionInfo)cache.get(key);
        if (cMethod == null) {
          int i = 0;
          return i;
        } } finally { this.rwl.readLock().unlock();
      }
    }
    return true;
  }

  static class ReflectionInfo
  {
    Map<String, Method> readMap = new HashMap();

    Map<String, Method> writeMap = new HashMap();

    Method getReadMethod(String prop) {
      return prop == null ? null : (Method)this.readMap.get(prop.toLowerCase());
    }

    Method getWriteMethod(String prop) {
      return prop == null ? null : (Method)this.writeMap.get(prop.toLowerCase());
    }
  }
}