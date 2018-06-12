package by.htp.carparking.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import by.htp.carparking.domain.Car;

@Controller
@RequestMapping(value = "/cars")
public class CarController {

	@RequestMapping( method = RequestMethod.GET)
	public List<Car> cars() {
		List<Car> cars=new ArrayList<>();
		cars.add(new Car(0,"BMV", "x5"));
		cars.add(new Car(0,"Audi","s1"));
		
		return cars;
	}

	

}