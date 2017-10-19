package cn.tedu.dao.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import cn.tedu.dao.UserDao;
import cn.tedu.entity.User;

@Repository("userDao")
public class UserDaoImpl implements UserDao {
	
	@Resource
	private HibernateTemplate hibernateTemplate;
	
	@Transactional
	public List<User> findAll() {
		return (List<User>)hibernateTemplate.find("from User");
	}
	
	@Transactional
	public void save(User user) {
		hibernateTemplate.save(user);
	}
	@Transactional
	public void delete(User user) {
		hibernateTemplate.delete(user);
	}
	@Transactional
	public void update(User user){
		hibernateTemplate.update(user); 
	}
	
	@Transactional
	public List<User> findByAddress(
			String address) {
		String hql="from User "
				+ "where address=?";
		return (List<User>)hibernateTemplate.find(hql, address); 
	}
	@Transactional
	public Integer findMaxId() {
		//SQL: select max(t_id) from t_user
		//HQL: select max(id) from User
		String hql = "select max(id) from User";
		List<Number> list= (List<Number>)
				hibernateTemplate.find(hql);
		return list.get(0).intValue();
	}
	
	public User findById(Integer id) {
		return hibernateTemplate.get(User.class, id); 
	}

	@Override
	public User deleteById(Integer id) {
		String HQL="from User where id=?";
		List<User> list=(List<User>)hibernateTemplate.find(HQL,id);
		return list.get(0);
	}
	
}




