package com.spurtti.api.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spurtti.api.entity.Runner;

@Repository
public interface RunnerRepository extends CrudRepository<Runner, String> {

}
