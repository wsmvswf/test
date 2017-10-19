package cn.tedu.service;

import java.util.List;

import cn.tedu.entity.User;

public interface UserService {
	List<User> list();

	void save(String name, Integer age, String address);

	User get(Integer id);

	void update(Integer id, String name, Integer age, String address);

	void deleteById(Integer id);
}
