package com.lti.airfuselage.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lti.airfuselage.model.SystemAdmin;
import com.lti.airfuselage.model.User;

//@Component
@Repository
public class UserRepositoryImpl implements UserRepository {

	@PersistenceContext
	EntityManager em;

	@Override
	@Transactional
	public boolean isUserPresent(String email) {
		return (Long) em.createQuery("select count(u.userId) from User u where u.email =: e")
				.setParameter("e", email)
				.getSingleResult() == 1 ? true : false;
	}

	@Override
	@Transactional
	public void add(User user) {
		em.merge(user);

	}

	@Override
	@Transactional
	public void addAdmin(SystemAdmin admin) {
		em.merge(admin);

	}
	
	@Override
	public User findById(int userId) {
		return em.find(User.class, userId);
	}
	
	@Override
	public SystemAdmin findByadminId(int id) {
		return em.find(SystemAdmin.class, id);
	}
	
	@Override
	public int login(String email, String password) {
		return (Integer) em.createQuery("select u.userId from User u where u.email= :e and u.password= :pw")
				.setParameter("e", email)
				.setParameter("pw", password)
				.getSingleResult();
	}
	
	@Override
	public int adminlogin(String email, String password) {
		return (Integer) em.createQuery("select u.id from SystemAdmin u where u.email= :e and u.password= :pw")
				.setParameter("e", email)
				.setParameter("pw", password)
				.getSingleResult();
	}

}
