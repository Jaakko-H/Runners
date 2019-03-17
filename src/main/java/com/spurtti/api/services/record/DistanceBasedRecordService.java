package com.spurtti.api.services.record;

import java.util.List;
import java.util.Map;

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
	 * Search records based on the given search parameters. Available search parameters:
	 * 
	 * <code>sportType - Filter records by the sport type, e.g. "walk", "run", etc. </code>
	 * 
	 * @param searchParams - A map of search parameters.
	 * @return - List of record DTOs that match the given search parameters.
	 */
	List<DistanceBasedRecordDto> searchRecords(Map<String, Object> searchParams);
}
