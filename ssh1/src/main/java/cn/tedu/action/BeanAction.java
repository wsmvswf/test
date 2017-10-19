package cn.tedu.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller// Bean ID: beanAction
@Scope("prototype")
public class BeanAction {	
	final int a=6;
	public String execute(){
		Thread t=Thread.currentThread();
		System.out.println(t); 
		System.out.println("Hello World!");
		return "success";
	}
}


