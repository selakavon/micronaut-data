package io.micronaut.data.tck.repositories;

import io.micronaut.data.annotation.Join;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.tck.entities.Author;

import java.util.List;

@Repository
public interface AuthorJoinLeftRepository {
    @Join(value = "books", type = Join.Type.LEFT)
    List<Author> findAll();

}
