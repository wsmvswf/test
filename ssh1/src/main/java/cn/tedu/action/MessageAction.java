package cn.tedu.action;

public class MessageAction {
	private String message;
	public void setMessage(String message) {
		this.message = message;
	}
	public String getMessage() {
		return message;
	}
	public String execute(){
		message = "Hello World!";
		return "success";
	}
}
