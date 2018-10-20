package com.spurtti.api.services.record;

import java.util.List;

import com.spurtti.api.dto.response.DistanceBasedRecordDto;

public interface DistanceBasedRecordService {

	List<DistanceBasedRecordDto> getAllRunRecordsByUser();
	
	List<DistanceBasedRecordDto> getAllWalkRecordsByUser();
}
