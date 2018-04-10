package by.htp.carparking.web.action.Impl;

import javax.servlet.http.HttpServletRequest;

import by.htp.carparking.domain.Car;
import by.htp.carparking.service.CarService;
import by.htp.carparking.service.ServiceFactory;
import by.htp.carparking.service.Impl.CarServiceImpl;
import by.htp.carparking.web.action.BaseAction;
import by.htp.carparking.web.util.HttpRequestParamFormatter;

import static by.htp.carparking.web.util.WebConstantDeclaration.*;
import static by.htp.carparking.web.util.HttpRequestParamFormatter.*;
public class CarUpdateAction implements BaseAction {
	// change to IoC, singleton
	private CarService carService = ServiceFactory.getCarService();
	//private CarService carService = new CarServiceImpl();

	@Override
	public String executeAction(HttpServletRequest request) {
		if (request.getMethod().toUpperCase().equals("POST")) {
			Car car = new Car(formatString(request.getParameter("id")), request.getParameter("brand"),
					request.getParameter("model"));
			carService.updateCar(car);
		}
		request.setAttribute(REQUEST_PARAM_CAR_LIST, carService.getCarList());
		return PAGE_USER_CAR_UPDATE;
	}
}
