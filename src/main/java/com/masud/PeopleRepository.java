package com.masud;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "people", path = "people")
public interface PeopleRepository extends MongoRepository<People, String> {
	List<People> findByLastName(@Param("last_name") String lname);
}
