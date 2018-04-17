package by.htp.carparking.web.action.impl;

import javax.servlet.http.HttpServletRequest;

import by.htp.carparking.domain.Car;
import by.htp.carparking.service.CarService;
import by.htp.carparking.service.OrderService;
import by.htp.carparking.service.ServiceFactory;
import by.htp.carparking.service.impl.CarServiceImpl;
import by.htp.carparking.web.action.BaseAction;
import by.htp.carparking.web.util.HttpRequestParamFormatter;

import static by.htp.carparking.web.util.WebConstantDeclaration.*;
import static by.htp.carparking.web.util.HttpRequestParamFormatter.*;

public class CarDeleteAction implements BaseAction {
	private CarService carService;	
	@Override
	public String executeAction(HttpServletRequest request) {
		if (request.getMethod().toUpperCase().equals("POST")) {
			Car car = new Car(formatString(request.getParameter(REQUEST_PARAM_CAR_ID)),
					request.getParameter(REQUEST_PARAM_CAR_BRAND), request.getParameter(REQUEST_PARAM_CAR_MODEL));
			carService.deleteCar(carService.readCar(formatString(request.getParameter(REQUEST_PARAM_CAR_ID))));
		}
		request.setAttribute(REQUEST_PARAM_CAR_LIST, carService.getCarList());
		
		return PAGE_USER_CAR_DELETE;
	}

}
