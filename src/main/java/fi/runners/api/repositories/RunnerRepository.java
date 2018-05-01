package fi.runners.api.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fi.runners.api.entity.Runner;

@Repository
public interface RunnerRepository extends CrudRepository<Runner, String> {

}
