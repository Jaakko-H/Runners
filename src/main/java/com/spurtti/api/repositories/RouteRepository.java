package com.spurtti.api.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spurtti.api.entity.Route;

@Repository
public interface RouteRepository extends CrudRepository<Route, String> {

}
