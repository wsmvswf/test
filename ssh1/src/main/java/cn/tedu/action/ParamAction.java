package cn.tedu.action;

public class ParamAction {
	private Integer score;
	private String user;
	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		this.score = score;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	
	/**
	 * 流程控制器方法 
	 * Struts2 会在执行控制器方法之前调用
	 * getXXX, setXXX 注入用户提交的参数!
	 */
	public String execute(){
		//展示从浏览器接收到参数
		System.out.println("score:"+score);
		System.out.println("user:"+user);
		return "success";
	}
}









