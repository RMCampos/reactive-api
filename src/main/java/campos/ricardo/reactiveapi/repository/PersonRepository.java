package campos.ricardo.reactiveapi.repository;

import campos.ricardo.reactiveapi.model.Person;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends ReactiveCrudRepository<Person, Long> {

}