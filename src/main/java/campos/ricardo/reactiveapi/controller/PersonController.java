package campos.ricardo.reactiveapi.controller;

import campos.ricardo.reactiveapi.exception.ErrorCode;
import campos.ricardo.reactiveapi.exception.ErrorResponse;
import campos.ricardo.reactiveapi.exception.UserNotFoundException;
import campos.ricardo.reactiveapi.model.Person;
import campos.ricardo.reactiveapi.repository.PersonRepository;
import campos.ricardo.reactiveapi.vo.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import reactor.core.publisher.Mono;

@RequestMapping("/person")
public class PersonController {

  @Autowired PersonRepository personRepository;

  @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  public Mono<ResponseEntity<? extends BaseResponse>> getPersonById(@PathVariable Long id) {
    Mono<Person> personMono = personRepository.findById(id);

    return personMono
        .flatMap(person -> buildResponse(HttpStatus.OK, person))
        .onErrorResume(
            UserNotFoundException.class,
            error ->
                buildResponse(
                    HttpStatus.NO_CONTENT,
                    ErrorResponse.fromErrorEnum(ErrorCode.ENTITY_NOT_FOUND)))
        .onErrorResume(
            throwable ->
                buildResponse(
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    ErrorResponse.fromErrorEnum(ErrorCode.UNKNOWN_ERROR)));
  }

  private Mono<ResponseEntity<? extends BaseResponse>> buildResponse(
      HttpStatus status, BaseResponse response) {
    return Mono.just(ResponseEntity.status(status).body(response));
  }
}
