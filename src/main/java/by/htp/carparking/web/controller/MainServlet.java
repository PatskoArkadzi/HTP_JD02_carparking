package by.htp.carparking.web.controller;

import java.io.IOException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import by.htp.carparking.web.action.ActionManagerContext;
import by.htp.carparking.web.action.BaseAction;
import static by.htp.carparking.web.util.WebConstantDeclaration.*;

public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MainServlet() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.process(request, response);
	}

	private void process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ServletContext servletContext=request.getServletContext();
		WebApplicationContext webApplicationContext=
				WebApplicationContextUtils.getWebApplicationContext(servletContext);
		String action = request.getParameter(REQUEST_PARAM_ACTION);
		BaseAction baseAction = ActionManagerContext.getAction(action,webApplicationContext);
		if (action != null) {
			String page = baseAction.executeAction(request);
			request.getRequestDispatcher(page).forward(request, response);
		} else {
			response.getWriter().println("Incorrect action");
		}
	}
}
