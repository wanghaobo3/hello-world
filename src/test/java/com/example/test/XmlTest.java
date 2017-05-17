package com.example.test;

import com.example.bean.Student;
import com.example.util.JaxbUtil;

public class XmlTest {
	public static void main(String[] args) {
		//注意Student类必须加上注解@XmlRootElement(name="student")
		Student student = new Student();
		student.setName("whbo3");
		student.setSno("123");
		student.setSex("male");
		String convertObj2Xml = JaxbUtil.convertObj2Xml(student, "UTF-8", true);
		System.out.println(convertObj2Xml);
	}
}
