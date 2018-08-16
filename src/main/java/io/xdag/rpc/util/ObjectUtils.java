package io.xdag.rpc.util;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Map;

/**
 * 
 * @author zpcsa
 *
 */
public class ObjectUtils  {

	/**
	 * 判断对象说有字段都为空
	 * @param obj
	 * @return 为空返回true
	 * @throws Exception
	 */
	@SuppressWarnings("rawtypes")
	public static boolean isAllFieldNull(Object obj){
        Class stuCla = (Class) obj.getClass();// 得到类对象
        Field[] fs = stuCla.getDeclaredFields();//得到属性集合
        boolean flag = true;
        for (Field f : fs) {//遍历属性
            f.setAccessible(true); // 设置属性是可以访问的(私有的也可以)
            String name=f.getName();
            Object val = null;
			try {
				val = f.get(obj);
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}// 得到此属性的值
            if(!name.equals("serialVersionUID")&&val!=null) {//只要有1个属性不为空,那么就不是所有的属性值都为空
                flag = false;
                break;
            }
        }
        return flag;
    }
	/**
	 * 是否检测错误
	 * 
	 * @param ex
	 * @return
	 */
	public static boolean isCheckedException(Throwable ex) {
		return (!(ex instanceof RuntimeException)) && (!(ex instanceof Error));
	}

	/**
	 * 判断是否为数组
	 * 
	 * @param obj
	 * @return
	 */
	public static boolean isArray(Object obj) {
		return (obj != null) && (obj.getClass().isArray());
	}

	/**
	 * 判断数组是否为空
	 * 
	 * @param array
	 * @return
	 */
	public static boolean isEmpty(Object[] array) {
		return (array == null) || (array.length == 0);
	}

	/**
	 * 判断对象是否为空
	 * 
	 * @param obj
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static boolean isEmpty(Object obj) {
		if (obj == null) {
			return true;
		}

		if (obj.getClass().isArray()) {
			return Array.getLength(obj) == 0;
		}
		if ((obj instanceof CharSequence)) {
			return ((CharSequence) obj).length() == 0;
		}
		if ((obj instanceof Collection)) {
			return ((Collection) obj).isEmpty();
		}
		if ((obj instanceof Map)) {
			return ((Map) obj).isEmpty();
		}

		return false;
	}

	/**
	 * 对象不为空为true
	 * 
	 * @param obj
	 * @return
	 */
	public static boolean isNotEmpty(Object obj) {
		if (!isEmpty(obj)) {
			return true;
		}
		return false;

	}
	
}
