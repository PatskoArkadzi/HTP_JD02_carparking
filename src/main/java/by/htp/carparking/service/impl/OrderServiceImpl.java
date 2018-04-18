package by.htp.carparking.service.impl;

import java.sql.Date;
import java.util.List;

import by.htp.carparking.db.dao.OrderDao;
import by.htp.carparking.domain.Order;
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
	public void orderCar(int userId, int carId, Date dateStart, Date dateEnd) {
		System.out.println("dateStart"+dateStart);
		System.out.println("dateEnd"+dateEnd);
		orderDao.insertNewOrder(userId, carId, dateStart, dateEnd);
	}

	public boolean isCarFree(int carId, Date start, Date end) {
		List<Order> list = orderDao.readAll(String.format("where car_id=" + carId));
		for (Order order : list) {
			if ((start.after(order.getDateStart()) && start.before(order.getDateEnd()))
					|| (end.before(order.getDateStart()) && end.after(order.getDateStart()))) {
				System.out.println("Ошибка");
				System.out.println("start" + start);
				System.out.println("dateEnd" + order.getDateEnd());
				System.out.println("end" + end);
				System.out.println("dateStart" + order.getDateStart());
				return false;
			}
		}
		return true;
	}
}
