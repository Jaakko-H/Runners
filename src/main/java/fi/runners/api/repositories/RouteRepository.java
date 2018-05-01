package fi.runners.api.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fi.runners.api.entity.Route;

@Repository
public interface RouteRepository extends CrudRepository<Route, String> {

}
