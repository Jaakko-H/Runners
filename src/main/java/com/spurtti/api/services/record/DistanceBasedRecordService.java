package com.spurtti.api.services.record;

import java.util.List;

import com.spurtti.api.collection.DistanceBasedRecord;
import com.spurtti.api.dto.response.DistanceBasedRecordDto;

public interface DistanceBasedRecordService {
	
	DistanceBasedRecord createRecord(DistanceBasedRecordDto recordDto);

	List<DistanceBasedRecordDto> getRecordsBySportType(String sportType);
}
