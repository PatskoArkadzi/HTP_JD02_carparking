package by.htp.carparking.web.action.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import by.htp.carparking.domain.Car;
import by.htp.carparking.service.CarService;
import by.htp.carparking.service.OrderService;
import by.htp.carparking.service.ServiceFactory;
import by.htp.carparking.service.impl.CarServiceImpl;
import by.htp.carparking.service.impl.OrderServiceImpl;
import by.htp.carparking.web.action.BaseAction;

import static by.htp.carparking.web.util.WebConstantDeclaration.*;

import java.util.List;

import static by.htp.carparking.web.util.HttpRequestParamValidator.*;
import static by.htp.carparking.web.util.HttpRequestParamFormatter.*;

public class OrderCarAction implements BaseAction {
	CarService carService;
	OrderService orderService;

	public OrderCarAction() {
	}

	public CarService getCarService() {
		return carService;
	}

	public void setCarService(CarService carService) {
		this.carService = carService;
	}

	public OrderService getOrderService() {
		return orderService;
	}

	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}

	@Override
	public String executeAction(HttpServletRequest request) {
		String carId = request.getParameter(REQUEST_PARAM_CAR_ID);
		String userId = request.getParameter(REQUEST_PARAM_USER_ID);
		validateRequestParamNotNull(carId, userId);
		orderService.orderCar(formatString(userId), formatString(carId));

		List<Car> cars = carService.getCarList();
		Car orderCar = carService.readCar(formatString(carId));
		StringBuilder orderedCarMessage = new StringBuilder();
		orderedCarMessage.append(orderCar.getBrand()).append(" ").append(orderCar.getModel())
				.append(" was ordered succesfully");

		request.setAttribute(REQUEST_PARAM_CAR_LIST, cars);
		request.setAttribute(REQUEST_MSG_SUCCESS, orderedCarMessage);
		return PAGE_USER_MAIN;
	}
}
