package by.htp.carparking.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import by.htp.carparking.db.DataBaseConnection;
import by.htp.carparking.db.dao.aop.CarDaoAspectImpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Arrays;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Aspect
@Component
public class CarAspect {
	private static final Logger logger = LogManager.getLogger();

	/*
	 * @Before("execution(* by.htp.carparking.service.impl.CarServiceImpl.getCarList(..))"
	 * ) private void doSmth() { System.out.println("-------------------");
	 * System.out.println("method CarServiceImpl.getCarList(..)"); }
	 * 
	 * @Before("execution(* by.htp.carparking.web.controller.CarController.cars(..))"
	 * ) private void doSmth2() { System.out.println("-------------------");
	 * System.out.println("method CarController.cars(..)"); }
	 * 
	 * @Before("execution(* by.htp.carparking.web.controller.*.*(..))") private void
	 * logControllerMethodNameWithArgs(JoinPoint joinpoint) {
	 * logger.info("controllerName = " +
	 * joinpoint.getTarget().getClass().getSimpleName() + " | " + "methodName = " +
	 * joinpoint.getSignature().getName() + " | " + "args = " +
	 * Arrays.asList(joinpoint.getArgs())); }
	 * 
	 * @Before("execution(* by.htp.carparking.service.impl.*.*(..))") private void
	 * logServiceMethodNameWithArgs(JoinPoint joinpoint) {
	 * logger.info("serviceName = " +
	 * joinpoint.getTarget().getClass().getSimpleName() + " | " + "methodName = " +
	 * joinpoint.getSignature().getName() + " | " + "args = " +
	 * Arrays.asList(joinpoint.getArgs())); }
	 * 
	 * @AfterReturning(pointcut =
	 * "execution(* by.htp.carparking.web.controller.*.*(..)) ", returning =
	 * "retVal") private void afterReturningMethod(Object retVal) {
	 * System.out.println("@AfterReturning advice " + retVal); }
	 * 
	 * @AfterThrowing(pointcut =
	 * "execution(* by.htp.carparking.web.controller.*.*(..)) ", throwing = "ex")
	 * private void afterThrowingMethod(Exception ex) { logger.error(ex);
	 * System.out.println("@AfterThrowing advice " + ex); }
	 * 
	 * @After("execution(* by.htp.carparking.web.controller.*.*(..)) ") private void
	 * afterMethod() { System.out.println("@After(finaly) advice"); }
	 * 
	 * @Around("execution(* by.htp.carparking.web.controller.*.*(..)) ") private
	 * Object aroundMethod(ProceedingJoinPoint pjp) throws Throwable {
	 * System.out.println("@Around advice " + pjp.getSignature()); return
	 * pjp.proceed(); }
	 */

	@Around("execution(* by.htp.carparking.db.dao.aop.CarDaoAspectImpl.purchase(..)) ")
	private Object beforeTransaction(ProceedingJoinPoint point) throws SQLException {
		try {
			CarDaoAspectImpl.con = DataBaseConnection.connect();
			CarDaoAspectImpl.con.setAutoCommit(false);

			return point.proceed();

		} catch (Throwable e) {
			System.out.println("rollback");
			CarDaoAspectImpl.con.rollback();
		} finally {
			if (CarDaoAspectImpl.con != null)
				CarDaoAspectImpl.con.commit();
				CarDaoAspectImpl.con.close();
		}
		return null;
	}

}
