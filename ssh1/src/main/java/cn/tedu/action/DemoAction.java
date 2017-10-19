package cn.tedu.action;

/**
 * Struts2 的控制器类
 * 就是普通Java类
 */
public class DemoAction {
	
	/**
	 * 控制器中的 流程控制方法 一般是execute方法
	 * 返回值 success 代表JSP页面的名称 
	 */
	public String execute(){
		System.out.println("Hello World!");
		return "success";
	}
}

