package com.example.blueprint.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FooRepository extends MongoRepository<Foo, String> {

}
