package by.htp.carparking.web.listners;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SimpleSessionListener implements HttpSessionListener{

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		//	se.getSession().setMaxInactiveInterval(1);
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
	}

}
