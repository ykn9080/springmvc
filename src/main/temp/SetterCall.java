package com.fastcampus.ch2;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.util.StringUtils;

public class SetterCall {
	public static void main(String[] args) throws Exception{
		Map<String, String> map = new HashMap<>();
		map.put("year", "2021");
		map.put("month", "10");
		map.put("day", "1");
		
		Class<?> type = Class.forName("com.fastcampus.ch2.MyDate");

		// MyDate�ν��Ͻ��� �����ϰ�, map�� ������ �ʱ�ȭ�Ѵ�. 
		Object obj = dataBind(map, type);
		System.out.println("obj="+obj); // obj=[year=2021, month=10, day=1]
	} // main

	private static Object dataBind(Map<String, String> map, Class<?> clazz) throws Exception {
		// 1. MyDate�ν��Ͻ� ����
//		Object obj = clazz.newInstance(); // deprecated method
		Object obj = clazz.getDeclaredConstructor().newInstance(new Object[0]);

		// 2. MyDate�ν��Ͻ��� setter�� ȣ���ؼ�, map�� ������ MyDate�� �ʱ�ȭ
		// 	 2-1. MyDate�� ��� iv�� ���鼭 map�� �ִ��� ã�´�.
		// 	 2-2. ã����, ã�� ���� setter�� ��ü�� �����Ѵ�.
		Field[] ivArr = clazz.getDeclaredFields();
		
		for(int i=0;i<ivArr.length;i++) {
			String name = ivArr[i].getName();
			Class<?>  type = ivArr[i].getType();
			
			// map�� ���� �̸��� key�� ������ �����ͼ� setterȣ�� 
			Object value = map.get(name); // ��ã���� value�� ���� null
			Method method = null;
			
			try {   // map�� iv�� ��ġ�ϴ� Ű�� ���� ����, setter�� ȣ��
				if(value==null) continue;
				
				method = clazz.getDeclaredMethod(getSetterName(name), type); // setter�� ���� ���	
				System.out.println("method="+method);
				method.invoke(obj, convertTo(value, type)); // obj�� setter�� ȣ��
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		System.out.println(Arrays.toString(ivArr));
		
		return obj;
	}

	private static Object convertTo(Object value, Class<?> type) {
		// value�� Ÿ�԰� type�� Ÿ���� ������ �״�� ��ȯ
		if(value==null || type==null || type.isInstance(value))
			return value;
		
		// value�� Ÿ�԰� type�� �ٸ���, ��ȯ�ؼ� ��ȯ
		if(String.class.isInstance(value) && type==int.class) // String -> int
			return Integer.valueOf(""+value);

		return value;
	}

	// iv�� �̸����� setter�� �̸��� ���� ��ȯ�ϴ� �޼���("day" -> "setDay")
	private static String getSetterName(String name) {
//		return "set"+name.substring(0,1).toUpperCase()+name.substring(1);
		return "set" + StringUtils.capitalize(name); // org.springframework.util.StringUtils
	}
}

/*
[������]
method=public void com.fastcampus.ch2.MyDate.setYear(int)
method=public void com.fastcampus.ch2.MyDate.setMonth(int)
method=public void com.fastcampus.ch2.MyDate.setDay(int)
[private int com.fastcampus.ch2.MyDate.year, private int com.fastcampus.ch2.MyDate.month, private int com.fastcampus.ch2.MyDate.day]
obj=[year=2021, month=10, day=1]
 */