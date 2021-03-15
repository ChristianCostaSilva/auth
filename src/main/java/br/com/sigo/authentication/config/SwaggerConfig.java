package br.com.sigo.authentication.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import io.swagger.models.Contact;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	@Primary
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select().apis(RequestHandlerSelectors.basePackage("br.com.sigo.authentication"))
				.paths(PathSelectors.any())
				.build()
				.apiInfo(ApiInfo());
	}

	@SuppressWarnings("deprecation")
	private ApiInfo ApiInfo() {
		
		springfox.documentation.service.Contact contato = 
				new springfox.documentation.service.Contact("Christian Costa", 
						"inxtexbr.com.br", "christian_eletronica@yahoo.com.br");
		
		
		return new ApiInfo("API Autenticação", 
				"API correspondente ao serviço de autenticação",
				"v1",
				"Termos do Serviço",
				contato, 
				"Licença API", 
				"Licença URL", 
				Collections.emptyList());
	}
}
