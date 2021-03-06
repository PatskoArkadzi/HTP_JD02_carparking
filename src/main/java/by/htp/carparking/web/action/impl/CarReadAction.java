package by.htp.carparking.web.action.impl;

import javax.servlet.http.HttpServletRequest;

import by.htp.carparking.service.CarService;
import by.htp.carparking.web.action.BaseAction;

import static by.htp.carparking.web.util.WebConstantDeclaration.*;
import static by.htp.carparking.web.util.HttpRequestParamFormatter.*;

public class CarReadAction implements BaseAction {
	CarService carService;

	public CarService getCarService() {
		return carService;
	}

	public void setCarService(CarService carService) {
		this.carService = carService;
	}

	public CarReadAction() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String executeAction(HttpServletRequest request) {
		if (request.getMethod().toUpperCase().equals("POST"))
			request.setAttribute(RESULT_CAR_SEARCH,
					carService.readCar(formatStringToInt(request.getParameter(REQUEST_PARAM_CAR_ID))));

		return PAGE_USER_CAR_READ;
	}

}
