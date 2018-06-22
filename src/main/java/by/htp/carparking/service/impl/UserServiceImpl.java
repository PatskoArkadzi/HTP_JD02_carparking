package by.htp.carparking.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import by.htp.carparking.db.dao.UserDao;
import by.htp.carparking.domain.User;
import by.htp.carparking.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserDao userDao;

	public UserServiceImpl() {
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public List<User> getUserList() {
		return userDao.readAll();
	}

	@Override
	public void createUser(User user) {
		userDao.create(user);
	}

	@Override
	public User readUser(int id) {
		return userDao.read(id);

	}

	@Override
	public void updateUser(User user) {
		userDao.update(user);

	}

	@Override
	public void deleteUser(User user) {
		userDao.delete(user);
	}

}
