package by.htp.carparking.service.impl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import by.htp.carparking.db.dao.DaoFactory;
import by.htp.carparking.db.dao.OrderDao;
import by.htp.carparking.db.dao.impl.OrderDaoDataBaseImpl;
import by.htp.carparking.service.OrderService;

public class OrderServiceImpl implements OrderService {

	@Override
	public void orderCar(int userId, int carId) {
		ORDER_DAO.insertNewOrder(userId, carId);
	}

}
