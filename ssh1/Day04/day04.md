# SSH

## 添加用户功能

原理:

![](1.png)

1. 创建/WEB-INF/jsp/user/add.jsp

		<%@ page contentType="text/html; charset=utf-8"
		    pageEncoding="UTF-8"%>
		<%@ taglib prefix="c" 
			uri="http://java.sun.com/jsp/jstl/core" %>
		<!DOCTYPE html>
		<html>
		<head>
		<meta charset="UTF-8">
		<title>添加用户</title>
		</head>
		<body>
			<h1>添加用户</h1>
			<c:import url="/WEB-INF/jsp/header.jsp"/>
			<form action="save.action" method="post">
				<div>
					<label>姓名</label>
					<input name="name" type="text">
				</div>
				<div>
					<label>年龄</label>
					<input name="age" type="text">
				</div>
				<div>
					<label>地址</label>
					<input name="address" type="text">
				</div>
				<div>
					<input type="submit" value="保存">  
				</div>
			</form>
		</body>
		</html>
	
2. 抽取统一的导航菜单 /WEB-INF/jsp/header.jsp:

		<%@ page contentType="text/html; charset=utf-8"
		    pageEncoding="UTF-8"%>
			<div>
				<a href="list.action">全部用户</a>
				<a href="add.action">添加用户</a>
			</div> 

3. 添加控制器配置 struts-user.xml

		<!-- 显示添加界面 -->
		<action name="add">
			<result>
				/WEB-INF/jsp/user/add.jsp
			</result>
		</action>

4. 测试.

5. 添加控制器方法 UserAction

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
			userService.save(name, age, address);
			return "success";
		}

6.添加业务层 方法 UserService

		void save(String name, Integer age, String address);

7. 实现业务层方法:
	
		public void save(String name, 
				Integer age, 
				String address) {
			if(name==null || name.trim().isEmpty()){
				throw new EmptyNameException(
						"用户名不能空");
			}
			if(age==null){
				age = 0;
			}
			if(address == null){
				address = "";
			}
			//Integer maxId = userDao.findMaxId();
			//Integer id = maxId+1;
			User user = new User(null, name, age, address);
			userDao.save(user); 
			System.out.println(user); 
		}

8. 重构 User.hbm.xml, 增加主键生成策略

		<id type="int" name="id" column="t_id">
			<!-- 主键ID的生成器 -->
			<generator class="org.hibernate.id.IncrementGenerator"></generator>
		</id>

9. 配置控制器 struts-user.xml

		<!-- 保存数据到数据库 -->
		<action name="save" class="userAction"
			method="save">
			<result name="success" 
				type="redirectAction"> 
				list
			</result>
		</action>

10. 测试

## Hibernate 主键生成

