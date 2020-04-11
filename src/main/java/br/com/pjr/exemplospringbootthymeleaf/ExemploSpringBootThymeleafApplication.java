package br.com.pjr.exemplospringbootthymeleaf;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.FixedLocaleResolver;

@SpringBootApplication
public class ExemploSpringBootThymeleafApplication extends SpringBootServletInitializer  {

	public static void main(String[] args) {
		SpringApplication.run(ExemploSpringBootThymeleafApplication.class, args);
	}

	@Bean
	public LocaleResolver localeResolver() {
		return new FixedLocaleResolver(new Locale("pt", "BR"));
	}
}

