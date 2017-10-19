package cn.tedu.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller
@Scope("prototype")
public class CurrnAction {
	String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String execute() throws Exception{
		Thread t = Thread.currentThread();
		Thread.sleep(10000);
		System.out.println(t); 
		System.out.println(name);
		return "success";
	}
}
