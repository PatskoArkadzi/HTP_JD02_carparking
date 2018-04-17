package by.htp.carparking.service.impl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import by.htp.carparking.db.dao.DaoFactory;
import by.htp.carparking.db.dao.OrderDao;
import by.htp.carparking.db.dao.impl.OrderDaoDataBaseImpl;
import by.htp.carparking.service.OrderService;

public class OrderServiceImpl implements OrderService {
	OrderDao orderDao;

	public OrderServiceImpl() {
	}

	public OrderDao getOrderDao() {
		return orderDao;
	}

	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}

	@Override
	public void orderCar(int userId, int carId) {
		orderDao.insertNewOrder(userId, carId);
	}

}
