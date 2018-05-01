package fi.runners.api.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fi.runners.api.entity.Record;
import fi.runners.api.entity.RecordId;

@Repository
public interface RecordRepository extends CrudRepository<Record, RecordId> {

}
