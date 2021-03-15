package br.com.sigo.authentication.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.sigo.authentication.model.Permission;

public interface RepositorioPermission extends JpaRepository<Permission, Long>{

	@Query ( "SELECT p FROM Permission p WHERE p.description =:description")
	Permission findBydescription ( @Param("description") String description);
	 
}
