package fi.runners.api.repositories;

import org.springframework.data.repository.CrudRepository;

import fi.runners.api.entity.Runner;

public interface RunnerRepository extends CrudRepository<Runner, String> {

}
