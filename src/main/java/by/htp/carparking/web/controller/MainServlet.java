package by.htp.carparking.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.carparking.db.dao.impl.CarDBDaoImp;
import by.htp.carparking.domain.Car;

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
		if (request.getMethod().toUpperCase().equals("POST")) {
			if (request.getParameter("Search") != null) {
				Car car=new CarDBDaoImp().read(Integer.parseInt(request.getParameter("id")));
				System.out.println(car);
				request.setAttribute("carSearch", car.getModel());
			} else {
				Car car = new Car(Integer.parseInt(request.getParameter("id")), request.getParameter("brand"),
						request.getParameter("model"));
				if (request.getParameter("Update") != null) {
					new CarDBDaoImp().update(car);
				}
				if (request.getParameter("Delete") != null) {
					new CarDBDaoImp().delete(car);
				}
				if (request.getParameter("Create") != null) {
					new CarDBDaoImp().create(car);
				}
			}
		}
		List<Car> cars = new CarDBDaoImp().readAll();
		request.setAttribute("cars", cars);
		RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/crudcars.jsp");
		requestDispatcher.forward(request, response);
	}
}
