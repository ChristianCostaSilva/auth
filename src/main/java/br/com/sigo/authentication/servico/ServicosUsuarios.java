package br.com.sigo.authentication.servico;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.sigo.authentication.repositorio.RepositorioUsuarios;

@Service
public class ServicosUsuarios implements UserDetailsService {

	@Autowired
	private final RepositorioUsuarios RepositorioUsuarios;
	
	public ServicosUsuarios(RepositorioUsuarios repositorio) {
//		super();
		this.RepositorioUsuarios = repositorio;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		var user = RepositorioUsuarios.findByUserName(username);
		if ( user != null) {
			return user;
		}else
			throw new UsernameNotFoundException("Usuário " + user + "não encontrado");
//		return null;
	} 
	
}
