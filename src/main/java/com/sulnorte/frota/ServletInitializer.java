package com.sulnorte.frota;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

public class ServletInitializer extends SpringBootServletInitializer {//NOSONAR veio na criação do projeto Spring Boot e não sei se o mesmo pode ser excluído.

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(FrotaApplication.class);
	}

}
