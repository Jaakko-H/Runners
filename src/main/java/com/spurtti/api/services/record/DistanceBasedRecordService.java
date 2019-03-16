package com.spurtti.api.services.record;

import java.util.List;

import com.spurtti.api.dto.response.DistanceBasedRecordDto;

public interface DistanceBasedRecordService {
	
	/**
	 * Create a new distance based record.
	 * 
	 * @param recordDto - Record DTO containing record data to be stored
	 * @return - Record DTO representing saved record data
	 */
	DistanceBasedRecordDto createRecord(DistanceBasedRecordDto recordDto);

	/**
	 * TODO: Change this to a search method.
	 */
	List<DistanceBasedRecordDto> getRecordsBySportType(String sportType);
}
