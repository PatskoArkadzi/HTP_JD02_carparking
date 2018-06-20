package by.htp.carparking.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CarAspect {

	@Before("execution(* by.htp.carparking.service.CarService.getCarList(..))")
	public void doSmth() {
		System.out.println("-------------------");
		System.out.println("Service method getCar()");
	}
	@Before("execution(* by.htp.carparking.web.controller.CarController.cars(..))")
	public void doSmth2() {
		System.out.println("-------------------");
		System.out.println("Service method getCar() in controller");
	}

}
