package com.lcy.server;

import java.io.IOException;

import org.restlet.representation.Representation;
import org.restlet.resource.ClientResource;

import com.lcy.server.obj.Constant;
import com.lcy.server.obj.Student;

public class Test{
	private StringBuilder builder;
	public static void main(String[] args){
		Test test = new Test();
		test.builder = new StringBuilder();
		String result="111";
		
//		result = test.addStudentTest();//添加学生信息
		result = test.queryStudents();//查看所有学生信息
		System.err.println(result);
	}
	
	/*
	 * 添加学生信息
	 */
	private String addStudentTest(){
		Student student = new Student();
		student.student_ID = "6479734";
		student.name = "JiangBing";
		student.headmaster = "luckey";
		student.grade = "二(6)";
		student.studies = "优";
		
		builder.append(Constant.SERVER_HOST).append(":").append(Constant.PROTOCOL)
		.append(Constant.STUDENT_LINK).append("?action=").append("ADD&").append(student.toQueryString());

		ClientResource client = new ClientResource(builder.toString());
		
		Representation represent = client.get();
		try {
			return represent.getText();
		} catch (IOException e) {
			e.printStackTrace();
			return "get fail";
		}
	}
	
	private String queryStudents(){
		builder.append(Constant.SERVER_HOST).append(":").append(Constant.PROTOCOL)
		.append(Constant.STUDENT_LINK).append("?action=").append("GETS");
		System.err.println(builder.toString());
		ClientResource client = new ClientResource(builder.toString());
		Representation represent = client.get();
		try {
			return represent.getText();
		} catch (IOException e) {
			e.printStackTrace();
			return "get fail";
		}
	}
}
