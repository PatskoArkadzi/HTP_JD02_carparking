package by.htp.carparking.web.action.Impl;

import javax.servlet.http.HttpServletRequest;

import by.htp.carparking.domain.Car;
import by.htp.carparking.service.OrderService;
import by.htp.carparking.service.ServiceFactory;
import by.htp.carparking.service.Impl.OrderServiceImpl;
import by.htp.carparking.web.action.BaseAction;

import static by.htp.carparking.web.util.WebConstantDeclaration.*;

import java.util.List;

import static by.htp.carparking.web.util.HttpRequestParamValidator.*;
import static by.htp.carparking.web.util.HttpRequestParamFormatter.*;
public class OrderCarAction implements BaseAction{
	//TODO to IoC
	private OrderService orderService=ServiceFactory.getOrderService();
//	private OrderService orderService=new OrderServiceImpl();
	
	@Override
	public String executeAction(HttpServletRequest request) {
		String carId=request.getParameter(REQUEST_PARAM_CAR_ID);
		String userId=request.getParameter(REQUEST_PARAM_USER_ID);
		validateRequestParamNotNull(carId,userId);
		orderService.orderCar(formatString(userId),formatString(carId));
				
		List<Car> cars = ServiceFactory.getCarService().getCarList();
		request.setAttribute(REQUEST_PARAM_CAR_LIST, cars);
		request.setAttribute(REQUEST_MSG_SUCCESS, "The car was ordered succesfully");
		return PAGE_USER_MAIN;
	}
}
