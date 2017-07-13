package com.lrosa.rastreamento.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.lrosa.rastreamento.model.Tail;

@RepositoryRestResource(collectionResourceRel = "tail", path = "tail")
public interface TailRepository extends CrudRepository<Tail, Long> {

    List<Tail> findByClientIdentifier(String clientIdentifier);

}
