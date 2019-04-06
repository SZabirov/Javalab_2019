package com.company.repositories;

import com.company.models.User;

import java.util.Optional;

public interface UsersRepository extends CrudRepository<User> {
    Optional<User> findOneByUsername(String username);
}
