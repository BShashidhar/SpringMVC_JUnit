package com.social.imageApp.account.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.social.imageApp.account.dto.User;

@Repository
@Transactional
public class UserDaoImp implements UserDao {
	@Autowired
	private SessionFactory sessionFactory;

	public int save(User user) {
		sessionFactory.getCurrentSession().save(user);
		return user.getUserId();
	}

	@Override
	public User get(int userId) {
		return sessionFactory.getCurrentSession().get(User.class, userId);
	}

	@Override
	public List<User> list() {
		String activeUser="FROM User WHERE isActive= :active";
		Query quary=sessionFactory.getCurrentSession().createQuery(activeUser);
		quary.setParameter("active", true);
		return quary.getResultList();
		
		/*
		 * Session session = sessionFactory.getCurrentSession(); CriteriaBuilder cb =
		 * session.getCriteriaBuilder(); CriteriaQuery<User> cq =
		 * cb.createQuery(User.class); Root<User> root = cq.from(User.class);
		 * cq.select(root); Query<User> query = session.createQuery(cq); return
		 * query.getResultList();
		 */
	}
	@Override 
	public boolean update(User user) {
		try {
			sessionFactory.getCurrentSession().update(user);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	/*
	 * @Override public void update(int userId, User user) { Session session =
	 * sessionFactory.getCurrentSession(); User uu =
	 * session.byId(User.class).load(userId);
	 * 
	 * uu.setProfilePicture(user.getProfilePicture());
	 * uu.setUserEmail(user.getUserEmail());
	 * uu.setUserFirstName(user.getUserFirstName());
	 * uu.setUserLastName(user.getUserLastName());
	 * uu.setUserName(user.getUserName());
	 * uu.setUserPassword(user.getUserPassword()); session.flush(); }
	 */

	/*
	 * @Override public void update(int userId, User user) { Session session =
	 * sessionFactory.getCurrentSession(); User uu =
	 * session.byId(User.class).load(userId);
	 * 
	 * uu.setProfilePicture(user.getProfilePicture());
	 * uu.setUserEmail(user.getUserEmail());
	 * uu.setUserFirstName(user.getUserFirstName());
	 * uu.setUserLastName(user.getUserLastName());
	 * uu.setUserName(user.getUserName());
	 * uu.setUserPassword(user.getUserPassword()); session.flush(); }
	 */

	@Override
	public boolean delete(User user) {
		user.setActive(false);
		try {
			sessionFactory.getCurrentSession().update(user);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
		
		/*
		 * Session session = sessionFactory.getCurrentSession(); User user =
		 * session.byId(User.class).load(userId); session.delete(user);
		 */
	}

}
