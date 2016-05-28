package com.hq.demo.loginsys.services.hibernate;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Service;

import com.hq.demo.loginsys.domains.User;
import com.hq.demo.loginsys.servies.UserCRUD;
@Service("UserCRUDHibernate")
public class UserCRUDHibernate  implements UserCRUD{
	private HibernateTemplate ht;
	
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory){
		ht=new HibernateTemplate(sessionFactory);
	}
	@Override
   public User getById(Long id){
		return ht.get(User.class, id);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public User getByName(String name){
		//return ht.get(User.class, name);
		List<User> users=(List<User>) ht.find("from User where name=?", name);
		if(users.size()>0)
			return users.get(0);
		else
			return null;
	}
	
		@SuppressWarnings("unchecked")
		@Override
	public User getByPassword(String password){
		//return ht.get(User.class,password);
			List<User> users=(List<User>) ht.find("from User where password=?", password);
			if(users.size()>0)
				return users.get(0);
			else
				return null;
		}

	@Override
	@Transactional
	public void add(User user){
		ht.save(user);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<User> getAll(){
		List<User> users=(List<User>)ht.find("from User");
		return users;
	}

}
