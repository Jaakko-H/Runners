package com.spurtti.api.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spurtti.api.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, String> {

}
