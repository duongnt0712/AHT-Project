package com.aht.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class EmployeeServiceAspect {
	
	@Before("execution(* com.aht.aop.service.EmployeeServiceImpl.*(..)) and args(empId, fname, sname)")
	public void beforeAdvice(JoinPoint joinPoint, String empId, String fname, String sname) {
		System.out.println("Before method: ");
		System.out.println("Create Employee with fname = " + fname + ", sname = " + sname + ", id = " + empId);
	}
	
	@Around("execution(* com.aht.aop.service.EmployeeServiceImpl.displayEmployee(..))")
	public void aroundAdvice(ProceedingJoinPoint pjp) {
		System.out.println("The method aroundAdvice() before invokation of the method: " + pjp.getSignature().getName() + " method.");
		try {
			pjp.proceed();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	}
	
	@After("execution(* com.aht.aop.service.EmployeeServiceImpl.*(..)) and args(empId, fname, sname)")
	public void afterAdvice(JoinPoint joinPoint, String empId, String fname, String sname) {
		System.out.println("After method: ");
		System.out.println("Create Employee with fname = " + fname + ", sname = " + sname + ", id = " + empId);	
	}
}
