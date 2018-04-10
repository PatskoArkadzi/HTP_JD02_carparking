package by.htp.carparking.web.action.Impl;

import static by.htp.carparking.web.util.WebConstantDeclaration.*;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import by.htp.carparking.domain.Car;
import by.htp.carparking.service.CarService;
import by.htp.carparking.service.ServiceFactory;
import by.htp.carparking.service.Impl.CarServiceImpl;
import by.htp.carparking.web.action.BaseAction;
import by.htp.carparking.web.util.HttpRequestParamFormatter;

import static by.htp.carparking.web.util.HttpRequestParamFormatter.*;
public class CarListViewAction implements BaseAction {
	// change to IoC, singleton
	private CarService carService = ServiceFactory.getCarService();
	// private CarService carService=new CarServiceImpl();

	@Override
	public String executeAction(HttpServletRequest request) {
		if (request.getMethod().toUpperCase().equals("POST")) {
			int userId=formatString(request.getParameter(REQUEST_PARAM_USER_ID));
			int carId=formatString(request.getParameter(REQUEST_PARAM_CAR_ID));
			ServiceFactory.getOrderService().orderCar(userId,carId);
		}
		List<Car> cars = carService.getCarList();
		request.setAttribute(REQUEST_PARAM_CAR_LIST, cars);

		return PAGE_USER_MAIN;
	}
}
