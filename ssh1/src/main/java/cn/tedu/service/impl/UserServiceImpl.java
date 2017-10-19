package cn.tedu.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.tedu.dao.UserDao;
import cn.tedu.entity.User;
import cn.tedu.service.UserService;

@Service("userService")
public class UserServiceImpl 
	implements UserService{

	@Resource
	private UserDao userDao;
	
	@Transactional
	public List<User> list() {
		return userDao.findAll();
	}
	
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
	
	@Transactional
	public User get(Integer id) {
		if(id==null){
			throw new RuntimeException(
					"ID不能空!");
		}
		return userDao.findById(id); 
	}
	
	@Transactional
	public void update(Integer id, 
		String name, Integer age, 
		String address) {
		
		if(name==null||name.trim().isEmpty()){
			throw new EmptyNameException(
					"用户名不能空");
		}
		
		User user = userDao.findById(id);
		user.setAddress(address);
		user.getAge();
		user.setName(name);
		userDao.update(user);
	}

	@Override
	@Transactional
	public void deleteById(Integer id) {
		User user=userDao.deleteById(id);
		userDao.delete(user);
	}
	
}




