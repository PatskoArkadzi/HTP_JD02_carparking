package by.htp.carparking.web.action.Impl;

import static by.htp.carparking.web.util.WebConstantDeclaration.*;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import by.htp.carparking.domain.Car;
import by.htp.carparking.service.CarService;
import by.htp.carparking.service.Impl.CarServiceImpl;
import by.htp.carparking.web.action.BaseAction;

public class CarListViewAction implements BaseAction {
	//change to IoC, singleton
	private CarService carService=new CarServiceImpl();
	
	@Override
	public String executeAction(HttpServletRequest request) {
		List<Car> cars=carService.getCarList();
		request.setAttribute(REQUEST_PARAM_CAR_LIST, cars);
		
		return PAGE_USER_MAIN;
	}
}
