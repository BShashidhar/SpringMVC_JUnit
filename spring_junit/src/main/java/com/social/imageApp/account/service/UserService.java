package com.social.imageApp.account.service;

import java.util.List;

import com.social.imageApp.account.dto.User;

public interface UserService {

	int save(User user);

	User get(int userId);

	List<User> list();

	boolean update(User user);

	boolean delete(User user);

}
