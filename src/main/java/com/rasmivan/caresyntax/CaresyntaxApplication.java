package com.rasmivan.caresyntax;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * The Class CaresyntaxApplication.
 */
@SpringBootApplication
@EnableAspectJAutoProxy
public class CaresyntaxApplication {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(CaresyntaxApplication.class, args);
	}

}
