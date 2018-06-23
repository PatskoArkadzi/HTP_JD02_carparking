package by.htp.carparking.web.util;

public final class WebConstantDeclaration {
	public static final String REQUEST_PARAM_ACTION = "action";
	public static final String REQUEST_PARAM_CAR_LIST = "carlist";
	public static final String REQUEST_PARAM_USER_ID = "user_id";
	public static final String REQUEST_PARAM_CAR_ID = "car_id";
	public static final String REQUEST_PARAM_CAR_BRAND = "car_brand";
	public static final String REQUEST_PARAM_CAR_MODEL = "car_model";
	public static final String REQUEST_PARAM_CAR_LEASED = "car_leased";
	public static final String REQUEST_PARAM_CAR_DAY_PRICE = "car_day_price";
	public static final String REQUEST_PARAM_ORDERED_CAR = "ordered_car";
	public static final String REQUEST_PARAM_MSG_ORDER_CAR_SUCCESS = "msg_order_car_success";
	public static final String REQUEST_PARAM_MSG_ERROR = "msg_error";
	public static final String REQUEST_PARAM_USER = "user";

	public static final String ACTION_NAME_VIEW_CAR_LIST = "view_car_list";
	public static final String ACTION_NAME_CREATE_CAR = "car_create";
	public static final String ACTION_NAME_READ_CAR = "car_read";
	public static final String ACTION_NAME_UPDATE_CAR = "car_update";
	public static final String ACTION_NAME_DELETE_CAR = "car_delete";
	public static final String ACTION_NAME_ORDER_CAR = "car_order";
	public static final String ACTION_NAME_RETURN_CAR = "return_car";

	public static final String PAGE_USER_MAIN = "/WEB-INF/page/user/main.jsp";
	public static final String PAGE_USER_CAR_CREATE = "/WEB-INF/page/user/carcreate.jsp";
	public static final String PAGE_USER_CAR_READ = "/WEB-INF/page/user/carread.jsp";
	public static final String PAGE_USER_CAR_UPDATE = "/WEB-INF/page/user/carupdate.jsp";
	public static final String PAGE_USER_CAR_DELETE = "/WEB-INF/page/user/cardelete.jsp";
	public static final String PAGE_USER_CAR_ORDER = "/WEB-INF/page/user/carorder.jsp";
	public static final String PAGE_ERROR = "/WEB-INF/page/error.jsp";

	public static final String SQL_QUERY_CAR_CREATE = "INSERT INTO `cars`(`brand`, `model`, `leased`, `pricePerDay`) VALUES (?,?,?,?)";
	public static final String SQL_QUERY_CAR_READ = "SELECT id, brand, model, leased, pricePerDay FROM `cars` WHERE id=?";
	public static final String SQL_QUERY_CAR_UPDATE = "UPDATE `cars` " + "SET `brand`=?,`model`=?,`leased`=?,`pricePerDay`=? WHERE id=?";
	public static final String SQL_QUERY_CAR_DELETE = "DELETE FROM `cars` WHERE id=?";
	public static final String SQL_QUERY_CAR_READ_ALL = "SELECT id, brand, model, leased, pricePerDay FROM `cars`";
	public static final String SQL_QUERY_ORDER_READ_ALL = "SELECT id, user_id, car_id, dateStart, dateEnd FROM `orders`";

	public static final String SQL_QUERY_COLUMN_NAME_CAR_ID = "id";
	public static final String SQL_QUERY_COLUMN_NAME_CAR_BRAND = "brand";
	public static final String SQL_QUERY_COLUMN_NAME_CAR_MODEL = "model";
	public static final String SQL_QUERY_COLUMN_NAME_CAR_LEASED = "leased";
	public static final String SQL_QUERY_COLUMN_NAME_CAR_PRICE_PER_DAY = "pricePerDay";

	public static final String SQL_QUERY_COLUMN_NAME_ORDER_ID = "id";
	public static final String SQL_QUERY_COLUMN_NAME_ORDER_USER_ID = "user_id";
	public static final String SQL_QUERY_COLUMN_NAME_ORDER_CAR_ID = "car_id";
	public static final String SQL_QUERY_COLUMN_NAME_ORDER_DATE_START = "dateStart";
	public static final String SQL_QUERY_COLUMN_NAME_ORDER_DATE_END = "dateEnd";

	public static final String RESULT_CAR_SEARCH = "found_car";

	public WebConstantDeclaration() {
	}

}
