package by.htp.carparking.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Aspect
@Component
public class CarAspect {
	private static final Logger logger = LogManager.getLogger();

	@Before("execution(* by.htp.carparking.service.impl.CarServiceImpl.getCarList(..))")
	public void doSmth() {
		System.out.println("-------------------");
		System.out.println("method CarServiceImpl.getCarList(..)");
	}

	@Before("execution(* by.htp.carparking.web.controller.CarController.cars(..))")
	public void doSmth2() {
		System.out.println("-------------------");
		System.out.println("method CarController.cars(..)");
	}

	@Before("execution(* by.htp.carparking.web.controller.*.*(..))")
	private void logMethodNameWithArgs(JoinPoint joinpoint) {
		logger.info("controllerName = " + joinpoint.getTarget().getClass().getSimpleName() + " | " + "methodName = "
				+ joinpoint.getSignature().getName() + " | " + "args = " + Arrays.asList(joinpoint.getArgs()));
	}

}
