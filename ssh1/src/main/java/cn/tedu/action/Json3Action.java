package cn.tedu.action;

public class Json3Action {
	private JsonResult result;
	public JsonResult getResult() {
		return result;
	}
	public void setResult(JsonResult result) {
		this.result = result;
	}
	public String execute(){
		result = 
			new JsonResult("Hello World!");
		return "json";
	}
}


