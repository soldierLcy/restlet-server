package com.lcy.server.obj;

public class Student {
	
	public String student_ID; //学号
	
	public String name;//名字
	
	public String headmaster;//班主任
	
	public String grade;//年级   二(5)
	
	public String studies;//学习情况  优、良、中、差
	
	public String toQueryString(){
		StringBuilder builder = new StringBuilder();
		builder.append("student_ID=").append(student_ID).append("&")
			.append("name=").append(name).append("&")
			.append("headmaster=").append(headmaster).append("&")
			.append("grade=").append(grade).append("&")
			.append("studies=").append(studies);
		return builder.toString();
	}
	
	@Override
	public String toString(){
		StringBuilder builder = new StringBuilder();
		builder.append(" Student { student_ID : ").append(student_ID).append(" , ")
				.append("name : ").append(name).append(" , ")
				.append("headmaster : ").append(headmaster).append(" , ")
				.append("grade : ").append(grade).append(" , ")
				.append("studies : ").append(studies).append(" }");
		return builder.toString();
	}
}