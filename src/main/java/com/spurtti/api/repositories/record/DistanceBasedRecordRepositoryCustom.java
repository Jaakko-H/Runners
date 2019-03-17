package com.spurtti.api.repositories.record;

import java.util.List;
import java.util.Map;

import com.spurtti.api.collection.DistanceBasedRecord;

public interface DistanceBasedRecordRepositoryCustom {

	List<DistanceBasedRecord> searchRecords(Map<String, Object> searchParams);
}
