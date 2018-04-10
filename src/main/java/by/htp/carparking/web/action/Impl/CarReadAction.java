package by.htp.carparking.web.action.Impl;

import javax.servlet.http.HttpServletRequest;

import by.htp.carparking.service.CarService;
import by.htp.carparking.service.ServiceFactory;
import by.htp.carparking.service.Impl.CarServiceImpl;
import by.htp.carparking.web.action.BaseAction;
import by.htp.carparking.web.util.HttpRequestParamFormatter;

import static by.htp.carparking.web.util.WebConstantDeclaration.*;
import static by.htp.carparking.web.util.HttpRequestParamFormatter.*;
public class CarReadAction implements BaseAction {
	// change to IoC, singleton
	private CarService carService = ServiceFactory.getCarService();
	//private CarService carService = new CarServiceImpl();

	@Override
	public String executeAction(HttpServletRequest request) {
		if (request.getMethod().toUpperCase().equals("POST"))
			request.setAttribute(RESULT_CAR_SEARCH, carService.readCar(formatString(request.getParameter("id"))));

		return PAGE_USER_CAR_READ;
	}

}
