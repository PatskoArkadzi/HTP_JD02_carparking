package by.htp.carparking.web.action;

import java.util.HashMap;
import java.util.Map;
import static by.htp.carparking.web.util.WebConstantDeclaration.*;

import by.htp.carparking.web.action.Impl.CarCreateAction;
import by.htp.carparking.web.action.Impl.CarDeleteAction;
import by.htp.carparking.web.action.Impl.CarListViewAction;
import by.htp.carparking.web.action.Impl.CarReadAction;
import by.htp.carparking.web.action.Impl.CarUpdateAction;

public class ActionManager {

	private static Map<String, BaseAction> actions;

	static {
		actions=new HashMap<>();
		actions.put(ACTION_NAME_VIEW_CAR_LIST,new CarListViewAction());
		actions.put(ACTION_NAME_CREATE_CAR,new CarCreateAction());
		actions.put(ACTION_NAME_READ_CAR,new CarReadAction());
		actions.put(ACTION_NAME_UPDATE_CAR,new CarUpdateAction());
		actions.put(ACTION_NAME_DELETE_CAR,new CarDeleteAction());
		
	}
	
	public ActionManager() {
	}

	public static BaseAction getAction(String action) {
		return actions.get(action);
	}
}
