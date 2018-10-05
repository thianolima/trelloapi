package br.com.teltelecom;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import br.com.teltelecom.util.TrelloUtil;

@SpringBootApplication
public class TrelloapiApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(TrelloapiApplication.class, args);
	}
	
	@Bean
	public TrelloUtil trello() {
		TrelloUtil util = new TrelloUtil();
		return util;
	}
}
