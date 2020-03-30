package com.social.imageApp.account.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.social.imageApp.account.dao.UserDao;
import com.social.imageApp.account.dto.User;

public class UserTestCase {
	private static AnnotationConfigApplicationContext context;
	private static UserDao userDao;
	private User user;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.social.imageApp.account");
		context.refresh();
		userDao = (UserDao) context.getBean(UserDao.class);
	}

	/*
	 * @Test public void testSaveUser() { user =new User(); user.setUserId(1);
	 * user.setUserFirstName("Besta"); user.setUserLastName("Shashidhar");
	 * user.setUserName("B Shashidhar"); user.setUserEmail("shashi.2346@gmail.com");
	 * user.setUserPassword("1234567890"); user.setProfilePicture("shashi.png");
	 * assertEquals("Saved in to table",user.getUserId(),userDao.save(user)); }
	 */
	/*
	 * @Test public void testGetUser() { user=userDao.get(1);
	 * assertEquals("Adding fine...","B Shashidhar",user.getUserName()); }
	 */
	
	/*
	 * @Test public void testUpdateUser() { user = userDao.get(2);
	 * user.setUserFirstName("Besta");
	 * assertEquals("Updating fine...",true,userDao.update(user)); }
	 */
	
	
	@Test
	public void testDeleteUser() {
		user = userDao.get(2);
		assertEquals("Deleting fine...", true, userDao.delete(user));
	}
	 
	 
	/*
	 * @Test public void testListUser() { assertEquals("Listing is fine...", 2,
	 * userDao.list().size()); }
	 */
}
