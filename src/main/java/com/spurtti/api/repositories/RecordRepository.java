package com.spurtti.api.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spurtti.api.entity.Record;
import com.spurtti.api.entity.RecordId;

@Repository
public interface RecordRepository extends CrudRepository<Record, RecordId> {

}
