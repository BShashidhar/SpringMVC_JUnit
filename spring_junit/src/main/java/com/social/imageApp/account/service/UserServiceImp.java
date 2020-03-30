package com.social.imageApp.account.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.social.imageApp.account.dao.UserDao;
import com.social.imageApp.account.dto.User;

@Service("UserService")
@Transactional(readOnly = true)
public class UserServiceImp implements UserService {

	@Autowired(required = true)
	private UserDao userDao;

	@Transactional
	@Override
	public int save(User user) {
		return userDao.save(user);
	}

	@Override
	public User get(int userId) {
		return userDao.get(userId);
	}

	@Override
	public List<User> list() {
		return userDao.list();
	}

	@Override
	public boolean update(User user) {
		try {
			userDao.update(user);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(User user) {
		try {
			userDao.delete(user);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

}
