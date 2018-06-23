package by.htp.carparking.web.util;

import java.math.BigDecimal;

public class HttpRequestParamFormatter {

	private HttpRequestParamFormatter() {
	}

	public static int formatStringToInt(String param) {
		return Integer.parseInt(param);
	}
	public static boolean formatStringToBoolean(String param) {
		return Boolean.parseBoolean(param);
	}
	public static BigDecimal formatStringToBigDecimal(String param) {
		return new BigDecimal(param);
	}
}
