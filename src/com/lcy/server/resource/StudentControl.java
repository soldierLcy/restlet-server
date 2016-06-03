package com.lcy.server.resource;

import java.util.List;

import org.restlet.data.Form;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

import com.lcy.server.obj.Constant;
import com.lcy.server.obj.MapUtil;
import com.lcy.server.obj.Student;

public class StudentControl extends ServerResource{
	
	@Get
	public String process(){
		Form form = getRequest().getResourceRef().getQueryAsForm();
		String action = form.getFirstValue("action");
		Student student = null;
		String where;
		String equals;
		switch(action){
		
			case Constant.GET:
				where = form.getFirstValue("where");
				equals = form.getFirstValue("equals");
				return queryS(where,equals);
			case Constant.GETS:
				return MapUtil.getMapUtil().getStudents().toString();
			case Constant.ADD:
				student = createS(form,student);
				MapUtil.getMapUtil().getStudents().add(student);
				return student.toString();
				
			case Constant.DELETE:
				where = form.getFirstValue("where");
				equals = form.getFirstValue("equals");
				return deleteS(where,equals);
				
			case Constant.CHANGE:
				
				break;
			default:
				break;
		
		}
		return " What do you want ??";
	}
	//查看
	private String queryS(String where,String equals){
		List<Student> students = MapUtil.getMapUtil().getStudents();
		int size = students.size();
		switch(where){
			case "student_ID":
				for(int i=0;i<size;i++){
					if(students.get(i).student_ID.equals(equals)){
						return students.get(i).toString();
					}
				}
				return equals+"not found!";
			case "name":
				for(int i=0;i<size;i++){
					if(students.get(i).name.equals(equals)){
						return students.get(i).toString();
					}
				}
				return equals+"not found!";
			default:
				break;
		}
		return "No such student !";
	}
	//添加
	private Student createS(Form form,Student student){
		student = new Student();
		student.student_ID = form.getFirstValue("student_ID");
		student.name = form.getFirstValue("name");
		student.headmaster = form.getFirstValue("headmaster");
		student.grade = form.getFirstValue("grade");
		student.studies = form.getFirstValue("studies");
		return student;
	}
	
	//删除
	private String deleteS(String where,String equals){
		
		List<Student> students = MapUtil.getMapUtil().getStudents();
		int size = students.size();
		String result=where+" can't be found !";
		switch(where){
			case "student_ID":
				for(int i=0;i<size;i++){
					if(students.get(i).student_ID.equals(equals)){
						students.remove(i);
						result = "delete success !";
						break;
					}
				}
				result = "student_ID \""+equals+"\" not found !";
				break;
			case "name":
				for(int i=0;i<size;i++){
					if(students.get(i).name.equals(equals)){
						students.remove(i);
						result = "delete success!";
						break;
					}
				}
				result = "name \""+equals+"\" not found !";
				break;
			default:
				break;
		}
		
		return result;
	}
	
	
	
	
}










