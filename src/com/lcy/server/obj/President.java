package com.lcy.server.obj;

public class President{
	
	private static President president;
	
	private President(){}
	
	public String name;
	
	public String task;
	
	public static President getPresident(){
		if(president == null){
			synchronized(President.class){
				president = new President();
			}
		}
		return president;
	}
}