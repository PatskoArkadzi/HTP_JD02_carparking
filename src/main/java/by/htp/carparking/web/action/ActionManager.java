package by.htp.carparking.web.action;

import java.util.HashMap;
import java.util.Map;

import by.htp.carparking.web.action.impl.CarCreateAction;
import by.htp.carparking.web.action.impl.CarDeleteAction;
import by.htp.carparking.web.action.impl.CarListViewAction;
import by.htp.carparking.web.action.impl.CarReadAction;
import by.htp.carparking.web.action.impl.CarUpdateAction;
import by.htp.carparking.web.action.impl.OrderCarAction;
import by.htp.carparking.web.action.impl.ReturnCarAction;

import static by.htp.carparking.web.util.WebConstantDeclaration.*;

public class ActionManager {

	private static Map<String, BaseAction> actions;

	static {
		actions=new HashMap<>();
		actions.put(ACTION_NAME_VIEW_CAR_LIST,new CarListViewAction());
		actions.put(ACTION_NAME_CREATE_CAR,new CarCreateAction());
		actions.put(ACTION_NAME_READ_CAR,new CarReadAction());
		actions.put(ACTION_NAME_UPDATE_CAR,new CarUpdateAction());
		actions.put(ACTION_NAME_DELETE_CAR,new CarDeleteAction());
		
		actions.put(ACTION_NAME_ORDER_CAR,new OrderCarAction());
		actions.put(ACTION_NAME_RETURN_CAR,new ReturnCarAction());
		
	}
	
	public ActionManager() {
	}

	public static BaseAction getAction(String action) {
		return actions.get(action);
	}
}
