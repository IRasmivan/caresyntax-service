package com.rasmivan.caresyntax.aop;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class CustomLogger {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Before("execution(* com.rasmivan.caresyntax.service.*.*(..))")
	public void before(JoinPoint joinPoint){
		logger.info("Before execution of {}", joinPoint);
	}
	
	@After(value = "execution(* com.rasmivan.caresyntax.service.*.*(..))")
	public void after(JoinPoint joinPoint) {
		logger.info("After execution of {}", joinPoint);
	}
	
}
