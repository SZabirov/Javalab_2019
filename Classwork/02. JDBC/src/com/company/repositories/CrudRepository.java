package com.company.repositories;

import java.util.List;
import java.util.Optional;

public interface CrudRepository<T> {
    void save(T t);
    void update(T t);
    Optional<T> find(Integer id);
    void delete(T t);

    List<T> findAll();
}
