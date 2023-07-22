package com.rest.webservices.restfulwebservices.restfulwebservices.helloworld;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

//REST API

@RestController
public class HelloWorldController {
	// hello-world
	private MessageSource messageSource;

	public HelloWorldController(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

	@GetMapping(path = "hello-world")
	public String helloWorld() {
		return "Hello world";
	}

	@GetMapping(path = "hello-world-bean")

	public HelloWordBean helloWorldBean() {
		return new HelloWordBean("Hello world");
	}

	@GetMapping(path = "/hello-wordl/path-variable/{name}")

	public HelloWordBean helloWorldPathVariable(@PathVariable String name) {
		return new HelloWordBean(String.format("Hello World, %s ", name));
	}

	@GetMapping(path = "hello-world-internationalized")
	public String helloWorldInternationalized() {
		Locale locale = LocaleContextHolder.getLocale();
		return messageSource.getMessage("good.morning.message", null, "Default Message", locale);
		// return "Hello world v2";
	}

}
