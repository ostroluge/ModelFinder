package org.acteacademie.modelfinder.repositories;

import java.util.Collection;

import org.acteacademie.modelfinder.domain.Response;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

public interface CustomResponseRepository extends Repository<Response, Long> {

	@Query(value = "select * from R_RESPONSE, SERVICE "
			+ "where R_RESPONSE.annonce_id = SERVICE.id_annonce "
			+ "and SERVICE.etudiant_id = :student_id", nativeQuery = true)
	Collection<Response> getByStudent(@Param("student_id") Long student_id);
}
