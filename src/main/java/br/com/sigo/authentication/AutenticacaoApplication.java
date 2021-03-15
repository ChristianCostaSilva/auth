package br.com.sigo.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.netflix.discovery.converters.Auto;

//@SpringBootApplication//(exclude = { SecurityAutoConfiguration.class }) // erro Initializing Spring DispatcherServlet 'dispatcherServlet'
//@ComponentScan // pra scanear as configs
//@EnableWebSecurity //Erro do bean do servlet de contexto
@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan
@EnableEurekaClient
//Serviço de autenticação pro SIGO

public class AutenticacaoApplication implements CommandLineRunner {

//	@Autowired
//	private BCryptPasswordEncoder passwordEncoder;
	
	public static void main(String[] args) {
		SpringApplication.run(AutenticacaoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		System.out.println("BCrypt Result: " + passwordEncoder.encode("madonna"));
		
	}

}
