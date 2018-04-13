package by.htp.carparking.web.action.impl;

import javax.servlet.http.HttpServletRequest;

import by.htp.carparking.service.CarService;
import by.htp.carparking.service.ServiceFactory;
import by.htp.carparking.service.impl.CarServiceImpl;
import by.htp.carparking.web.action.BaseAction;
import by.htp.carparking.web.util.HttpRequestParamFormatter;

import static by.htp.carparking.web.util.WebConstantDeclaration.*;
import static by.htp.carparking.web.util.HttpRequestParamFormatter.*;

public class CarReadAction implements BaseAction {

	@Override
	public String executeAction(HttpServletRequest request) {
		if (request.getMethod().toUpperCase().equals("POST"))
			request.setAttribute(RESULT_CAR_SEARCH, CAR_SERVICE.readCar(formatString(request.getParameter(REQUEST_PARAM_CAR_ID))));

		return PAGE_USER_CAR_READ;
	}

}
