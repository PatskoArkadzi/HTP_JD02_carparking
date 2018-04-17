package by.htp.carparking.web.action;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import by.htp.carparking.service.CarService;
import by.htp.carparking.service.OrderService;
import by.htp.carparking.service.impl.CarServiceImpl;
import by.htp.carparking.service.impl.OrderServiceImpl;

public interface BaseAction {
	/*static final ApplicationContext APP_CONTEXT = new ClassPathXmlApplicationContext("carparking-context.xml");
	static final CarService CAR_SERVICE = APP_CONTEXT.getBean(CarServiceImpl.class);
	static final OrderService ORDER_SERVICE= APP_CONTEXT.getBean(OrderServiceImpl.class);*/
	
	String executeAction(HttpServletRequest request);
}
