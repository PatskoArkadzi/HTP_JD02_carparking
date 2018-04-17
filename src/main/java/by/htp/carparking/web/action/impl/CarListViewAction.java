package by.htp.carparking.web.action.impl;

import static by.htp.carparking.web.util.WebConstantDeclaration.*;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import by.htp.carparking.domain.Car;
import by.htp.carparking.service.CarService;
import by.htp.carparking.service.OrderService;
import by.htp.carparking.service.Service;
import by.htp.carparking.service.ServiceFactory;
import by.htp.carparking.service.impl.CarServiceImpl;
import by.htp.carparking.service.impl.OrderServiceImpl;
import by.htp.carparking.web.action.BaseAction;
import by.htp.carparking.web.util.HttpRequestParamFormatter;

import static by.htp.carparking.web.util.HttpRequestParamFormatter.*;

public class CarListViewAction implements BaseAction {
	private CarService carService;

	public CarListViewAction() {
	}
	public CarService getCarService() {
		return carService;
	}
	public void setCarService(CarService carService) {
		this.carService = carService;
	}
	
	@Override
	public String executeAction(HttpServletRequest request) {		
		List<Car> cars = carService.getCarList();
		request.setAttribute(REQUEST_PARAM_CAR_LIST, cars);

		return PAGE_USER_MAIN;
	}
}
