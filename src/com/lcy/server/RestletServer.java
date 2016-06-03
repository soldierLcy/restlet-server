package com.lcy.server;

import org.restlet.Application;
import org.restlet.Component;
import org.restlet.Context;
import org.restlet.Restlet;
import org.restlet.Server;
import org.restlet.data.Protocol;
import org.restlet.routing.Router;

import com.lcy.server.obj.Constant;
import com.lcy.server.resource.PresidentControl;
import com.lcy.server.resource.StudentControl;
import com.lcy.server.resource.TeacherControl;

public class RestletServer{
	
	public static void main(String[] arg){
		
		Context context = new Context();
		context.getParameters().set("maxThreads", "100");
		context.getParameters().set("maxConnectionsPerHost", "1000");
		context.getParameters().set("maxTotalConnections", "1000");
		
		Server server = new Server(context,Protocol.HTTP,Constant.PROTOCOL);
				
		Component component = new Component();
		component.getServers().add(server);
		component.getDefaultHost().attach(new MyApplication(context));
		
		try {
			component.start();
		} catch (Exception e) {
			System.out.println("RestletServer start failed !");
			e.printStackTrace();
		}
	}
	
	static class MyApplication extends Application{
		
		private Context context;
		public MyApplication(Context context){
			super(context);
			this.context = context;
		}
		@Override
		public Restlet createInboundRoot(){
			
			Router router = new Router(context);
			router.attach(Constant.STUDENT_LINK, StudentControl.class);
			router.attach(Constant.TEACHER_LINK, TeacherControl.class);
			router.attach(Constant.PRESIDENT_LINK, PresidentControl.class);
	
			return router;
		}
	}
}