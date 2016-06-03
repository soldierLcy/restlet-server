package com.lcy.server.obj;

public class Teacher {
	
	public String name;//名字
	
	public String identify;//身份
	
	public int salary;//薪资
	
	
	@Override
	public String toString(){
		StringBuilder builder = new StringBuilder();
		builder.append("name=").append(name).append("&")
			.append("identify=").append(identify).append("&")
			.append("salary=").append(salary);
		return builder.toString();
	}
}