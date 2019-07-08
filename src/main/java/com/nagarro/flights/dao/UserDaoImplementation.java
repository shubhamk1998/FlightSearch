package com.nagarro.flights.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.nagarro.flights.models.User;

@Repository
public class  UserDaoImplementation implements UserDao {
	
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}
	
	@Override
	public User getUserDetails(String username) {
		Session session = this.sessionFactory.getCurrentSession();
		return (User) session.load(User.class, username);
	}
	
	@Override
	public Boolean userAuthentication(String username, String password) {
               Session session = this.sessionFactory.getCurrentSession();
               try {
            	   User user = (User) session.get(User.class, username);
                   if (user.getUsername() != null && user.getPassword().equals(password))
                	   return true;
                   else
                	   return false;
            	   
               }
               catch(Exception e) {
            	   return false;
               }
               
    }


}
