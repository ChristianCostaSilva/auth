package br.com.sigo.authentication.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.sigo.authentication.model.User;

@Repository
public interface RepositorioUsuarios extends JpaRepository<User, Long>{

	@Query ( "SELECT u FROM User u WHERE u.userName =:userName")
	User findByUserName ( @Param("userName") String userName);
	
	
}






