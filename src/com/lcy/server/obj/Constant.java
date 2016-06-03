package com.lcy.server.obj;

public class Constant{
	
	String get = "http://localhost:1991/lcy/restlet/student_control?action=GET&where=name&equals=SuiQi";
	String gets = "http://localhost:1991/lcy/restlet/student_control?action=GETS";
	String add = "http://localhost:1991/lcy/restlet/student_control?action=ADD&"+new Student().toQueryString();
	String delete = "http://localhost:1991/lcy/restlet/student_control?action=DELETE&where=name&equals=sunqi";
	String change = "http://localhost:1991/lcy/restlet/student_control?action=CHANGE&where=name&"
			+ "equals=lifang&change=studies&values=良";
	
	public static final String GET = "GET";//单个
	public static final String GETS = "GETS";//list
	public static final String ADD = "ADD";
	public static final String DELETE = "DELETE";
	public static final String CHANGE = "CHANGE";
	
	public static final int PROTOCOL = 1991;
	
	public static final String SERVER_HOST = "http://localhost";
	
	public static final String BASE_LINK = "/lcy/restlet/";
	
	public static final String STUDENT_LINK = "/lcy/restlet/student_control";
	public static final String TEACHER_LINK = "/lcy/restlet/teacher_control";
	public static final String PRESIDENT_LINK = "/lcy/restlet/president_control";
	
}