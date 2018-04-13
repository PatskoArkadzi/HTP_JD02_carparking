package by.htp.carparking.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import by.htp.carparking.db.dao.CarDao;
import by.htp.carparking.db.dao.OrderDao;
import by.htp.carparking.db.dao.impl.CarDaoDataBaseImpl;
import by.htp.carparking.db.dao.impl.OrderDaoDataBaseImpl;
import by.htp.carparking.service.impl.CarServiceImpl;
import by.htp.carparking.service.impl.OrderServiceImpl;

public interface Service {
	static final ApplicationContext APP_CONTEXT = new ClassPathXmlApplicationContext("carparking-context.xml");
	static final CarDao CAR_DAO = APP_CONTEXT.getBean(CarDaoDataBaseImpl.class);
	static final OrderDao ORDER_DAO= APP_CONTEXT.getBean(OrderDaoDataBaseImpl.class);
}
