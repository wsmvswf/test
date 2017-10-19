package cn.tedu.action;

public class UserAction {

	private UserVo user;
	
	public void setUser(UserVo user) {
		this.user = user;
	}
	
	public UserVo getUser() {
		return user;
	}
	
	public String save(){
		//展示接收到的数据
		System.out.println(user);
		return "success";
	}
}









