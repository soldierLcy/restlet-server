package com.lcy.server.obj;

import java.util.ArrayList;
import java.util.List;

public final class MapUtil{
	
	private MapUtil(){}
	
	private static MapUtil map_util;
	
	private static final List<Student> STUDENT_MAP = new ArrayList<Student>();
	
	private static final List<Teacher> TEACHER_MAP = new ArrayList<Teacher>();
	
	
	public static MapUtil getMapUtil(){
		if(map_util == null){
			synchronized(MapUtil.class){
				map_util = new MapUtil();
			}
		}
		return map_util;
	}
	
	public List<Student> getStudents(){
		
		return STUDENT_MAP;
	}
	
	public List<Teacher> getTeachers(){
		
		return TEACHER_MAP;
	}
}