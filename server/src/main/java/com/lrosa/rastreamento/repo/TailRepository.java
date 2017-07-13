package com.lrosa.rastreamento.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.lrosa.rastreamento.model.Tail;


public interface TailRepository extends CrudRepository<Tail, Long> {

    List<Tail> findByClientIdentifier(String clientIdentifier);

}
