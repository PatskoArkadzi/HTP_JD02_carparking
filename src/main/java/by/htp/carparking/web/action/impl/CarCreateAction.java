package by.htp.carparking.web.action.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import by.htp.carparking.domain.Car;
import by.htp.carparking.service.CarService;
import by.htp.carparking.service.impl.CarServiceImpl;
import by.htp.carparking.web.action.BaseAction;

import static by.htp.carparking.web.util.WebConstantDeclaration.*;
import static by.htp.carparking.web.util.HttpRequestParamFormatter.*;

public class CarCreateAction implements BaseAction {

	@Override
	public String executeAction(HttpServletRequest request) {
		if (request.getMethod().toUpperCase().equals("POST")) {
			Car car = new Car(formatString(request.getParameter(REQUEST_PARAM_CAR_ID)),
					request.getParameter(REQUEST_PARAM_CAR_BRAND), request.getParameter(REQUEST_PARAM_CAR_MODEL));
			CAR_SERVICE.createCar(car);
		}
		return PAGE_USER_CAR_CREATE;
	}

}
