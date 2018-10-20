package com.spurtti.api.repositories.record;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.spurtti.api.collection.DistanceBasedRecord;

public interface RunningRecordRepository extends MongoRepository<DistanceBasedRecord, ObjectId> {

}
