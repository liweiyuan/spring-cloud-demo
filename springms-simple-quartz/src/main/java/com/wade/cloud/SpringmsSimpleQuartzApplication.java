package com.wade.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("applicationContext.xml")
public class SpringmsSimpleQuartzApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringmsSimpleQuartzApplication.class, args);
	}

	/*@Bean
	public EmbeddedServletContainerFactory servletContainer() {
		TomcatEmbeddedServletContainerFactory factory = new TomcatEmbeddedServletContainerFactory();
		factory.setPort(port);
		factory.setSessionTimeout(sessionTimeout, TimeUnit.SECONDS);
		return factory;
	}*/
}
