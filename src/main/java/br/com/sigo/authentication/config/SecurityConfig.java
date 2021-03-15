package br.com.sigo.authentication.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import br.com.sigo.authentication.security.jwt.JwtConfigurer;
import br.com.sigo.authentication.security.jwt.JwtTokenProvider;


@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	
	
	private JwtTokenProvider tokenProvider;
	
	@Autowired
	public SecurityConfig(JwtTokenProvider tokenProvider) {
	    	this.tokenProvider = tokenProvider;
	}

	//preciso para encriptar a senha pois estava dando erro na hora de buscar, pois a senha estava vindo como digitada	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
	BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
	return bCryptPasswordEncoder;
		
	}

//preciso desse bean pois o controller reclamou não bastando colocar o @Autowired
	@Override
	@Bean
	 public AuthenticationManager authenticationManagerBean() throws Exception {
		 return super.authenticationManagerBean();
	 }
	
//Se não configurar, o mapeamento do serviço no authcontroller não funciona e cai sempre no servlet context do TomCat	
//	@Override
    protected  void configure(HttpSecurity http ) throws Exception {
//    	http.authorizeRequests().antMatchers("auth/signin", "api-docs", "swagger-ui.html").permitAll();
    	
    	http.httpBasic().disable()
    	.csrf().disable()
    	.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
    	.and().authorizeRequests()
     	.antMatchers(HttpMethod.POST, "/authentication/signin", "v2/api-docs", "swagger-ui.html").permitAll()
 //	    .antMatchers("/authentication/**").authenticated()
    	.anyRequest().authenticated().and()
    	.apply(new JwtConfigurer(tokenProvider));

    }
  
}



