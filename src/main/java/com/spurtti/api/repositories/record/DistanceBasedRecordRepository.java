package com.spurtti.api.repositories.record;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.spurtti.api.collection.DistanceBasedRecord;

public interface DistanceBasedRecordRepository extends MongoRepository<DistanceBasedRecord, ObjectId> {

}
