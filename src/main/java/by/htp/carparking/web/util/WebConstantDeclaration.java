package by.htp.carparking.web.util;

public final class WebConstantDeclaration {
	public static final String REQUEST_PARAM_ACTION="action";
	public static final String REQUEST_PARAM_CAR_LIST="carlist";
	
	public static final String ACTION_NAME_VIEW_CAR_LIST = "view_car_list";
	public static final String ACTION_NAME_CREATE_CAR = "car_create";
	public static final String ACTION_NAME_READ_CAR = "car_read";
	public static final String ACTION_NAME_UPDATE_CAR = "car_update";
	public static final String ACTION_NAME_DELETE_CAR = "car_delete";
	
	public static final String PAGE_USER_MAIN = "/WEB-INF/page/user/main.jsp";
	public static final String PAGE_USER_CAR_CREATE = "/WEB-INF/page/user/carcreate.jsp";
	public static final String PAGE_USER_CAR_READ = "/WEB-INF/page/user/carread.jsp";
	public static final String PAGE_USER_CAR_UPDATE = "/WEB-INF/page/user/carupdate.jsp";
	public static final String PAGE_USER_CAR_DELETE = "/WEB-INF/page/user/cardelete.jsp";

	
	public static final String RESULT_CAR_SEARCH = "found_car";
	public WebConstantDeclaration() {
	}
	
}
