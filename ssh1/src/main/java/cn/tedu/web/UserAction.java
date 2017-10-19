package cn.tedu.web;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import org.apache.struts2.interceptor.RequestAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.tedu.entity.User;
import cn.tedu.service.UserService;
import cn.tedu.service.impl.EmptyNameException;

@Controller
@Scope("prototype")
public class UserAction implements RequestAware {
	
	private Map<String, Object> request;
	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}
	
	@Resource
	private UserService userService;
	
	private List<User> list;
	public List<User> getList() {
		return list;
	}
	public void setList(List<User> list) {
		this.list = list;
	}
	public String list(){
		list=userService.list();
		return "list";
	}
	
	private String name;
	private Integer age;
	private String address;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String save(){
		try{
			userService.save(name, age, address);
			return "success";
		}catch(EmptyNameException e){
			//获得request对象
			//HttpServletRequest req= 
			//  ServletActionContext.getRequest();
			//req.setAttribute(
			//	"nameError", e.getMessage());
			request.put("nameError",e.getMessage());
			e.printStackTrace();
			return "add";
		}catch(Exception e){
			request.put("error", e.getMessage());
			e.printStackTrace(); 
			return "error";
		}
	}
	
	
	//UserAction
	private Integer id;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	private User user;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	public String edit(){
		user = userService.get(id);
		return "edit";
	}
	
	//UserAction
	
	public String update(){
		//id name age address
		try{
			//userService.update(
			//	id, name, age, address);
			userService.update(user.getId(),user.getName(), user.getAge(),user.getAddress());
			return "list";
		}catch(EmptyNameException e){
			e.printStackTrace();
			request.put("nameError",e.getMessage());
			//user = new User(id, name, age, address);
			return "edit";
		}catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
	public String delete(){
		userService.deleteById(id);
		return "delete";
	}
}








