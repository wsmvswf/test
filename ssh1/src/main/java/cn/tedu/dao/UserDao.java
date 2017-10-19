package cn.tedu.dao;

import java.util.List;

import cn.tedu.entity.User;

public interface UserDao {
	public List<User> findAll();
	public void save(User user);
	public void delete(User user);
	public void update(User user);
	public List<User> findByAddress(
			String address);
	public Integer findMaxId();
	public User findById(Integer id);
	public User deleteById(Integer id);	 
}


