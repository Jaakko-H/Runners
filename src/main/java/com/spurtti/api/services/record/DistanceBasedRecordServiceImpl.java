package com.spurtti.api.services.record;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;

import com.spurtti.api.collection.DistanceBasedRecord;
import com.spurtti.api.dto.response.DistanceBasedRecordDto;
import com.spurtti.api.repositories.record.DistanceBasedRecordRepository;
import com.spurtti.api.services.AbstractService;

@Named("distanceBasedRecordService")
public class DistanceBasedRecordServiceImpl extends AbstractService implements DistanceBasedRecordService {

	@Inject
	private DistanceBasedRecordRepository repository;
	
	@Override
	public DistanceBasedRecordDto createRecord(DistanceBasedRecordDto recordDto) {
		return new DistanceBasedRecordDto(repository.save(new DistanceBasedRecord(recordDto)));
	}

	@Override
	public List<DistanceBasedRecordDto> searchRecords(Map<String, Object> searchParams) {
		return convertRecordEntitiesToDtos(repository.searchRecords(searchParams));
	}
	
	private List<DistanceBasedRecordDto> convertRecordEntitiesToDtos(List<DistanceBasedRecord> records) {
		List<DistanceBasedRecordDto> recordDtos = new ArrayList<>();
		records.forEach(record -> recordDtos.add(new DistanceBasedRecordDto(record)));
		return recordDtos;
	}
}
