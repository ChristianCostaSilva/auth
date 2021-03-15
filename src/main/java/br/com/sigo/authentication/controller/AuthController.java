package br.com.sigo.authentication.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.sigo.authentication.model.User;
import br.com.sigo.authentication.repositorio.RepositorioUsuarios;
import br.com.sigo.authentication.security.AccountCredentialsVO;
import br.com.sigo.authentication.security.jwt.JwtTokenProvider;
import br.com.sigo.authentication.servico.ServicosUsuarios;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api( description = "Endpoint para o serviço de autenticação", tags = "Serviço de autenticação " )
@RestController
@RequestMapping( value = "/authentication")


public class AuthController {
	
	@Autowired
    AuthenticationManager authenticationManager;
    
    @Autowired
 	JwtTokenProvider tokenProvider;
	
    @Autowired
	RepositorioUsuarios repositorio;
	
	@Autowired
	ServicosUsuarios servico;
	
	@GetMapping
	public ResponseEntity teste() {
		return ResponseEntity.ok().build();
	}
	
	@ApiOperation (value = "Autenticar usuário e prover token")
	@PostMapping ( value ="/signin")// Só funcionou a partir do momento que implementou o SecurityConfig
	public ResponseEntity signin ( @RequestBody AccountCredentialsVO conta) throws Exception {
//        conta.getUsername();
		try {
			var username = conta.getUsername();
			var password = conta.getPassword();
			

			User usuario = repositorio.findByUserName(username);
			if (usuario == null) {
				return ResponseEntity.notFound().build();
				
			}else {
				authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
				
				var token = "";
				token = tokenProvider.createToken(username, usuario.getRoles());
				Map<Object, Object> model = new HashMap<>();
				model.put("username", username);
				model.put("token", token);
// se quiser buscar mais atributos, é aqui que deve inserir				
				return ResponseEntity.ok(model);
			}
		} catch (AuthenticationException e) {
//			return ResponseEntity.notFound().build();
			throw new BadCredentialsException("Senha inválida!!");
		}

	}

}
