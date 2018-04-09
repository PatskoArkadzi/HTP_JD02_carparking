package by.htp.carparking.web.action.Impl;

import javax.servlet.http.HttpServletRequest;

import by.htp.carparking.web.action.BaseAction;

import static by.htp.carparking.web.util.WebConstantDeclaration.*;
public class ReturnCarAction implements BaseAction{

	@Override
	public String executeAction(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return ACTION_NAME_RETURN_CAR;
	}

}
