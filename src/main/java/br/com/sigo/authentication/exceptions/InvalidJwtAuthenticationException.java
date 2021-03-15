package br.com.sigo.authentication.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus( code = HttpStatus.BAD_REQUEST  )
public class InvalidJwtAuthenticationException extends AuthenticationException{

	public InvalidJwtAuthenticationException(String excecao) {
		super(excecao);
	}

	private static final long serialVersionUID = 1L;

}
