package by.htp.carparking.service.impl;

import java.util.List;

import by.htp.carparking.db.dao.UserDao;
import by.htp.carparking.domain.User;
import by.htp.carparking.service.UserService;

public class UserServiceImpl implements UserService {
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
	public List<User> getCarList() {
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
