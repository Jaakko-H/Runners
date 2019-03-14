package com.spurtti.api.services.record;

import java.util.ArrayList;
import java.util.List;

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
	public DistanceBasedRecordDto create(DistanceBasedRecordDto recordDto) {
		return new DistanceBasedRecordDto(repository.save(convertRecordDtoToEntity(recordDto)));
	}

	@Override
	public List<DistanceBasedRecordDto> getRecordsBySportType(String sportType) {
		return convertRecordEntitiesToDtos(repository.findAll());
	}
	
	private List<DistanceBasedRecordDto> convertRecordEntitiesToDtos(List<DistanceBasedRecord> records) {
		List<DistanceBasedRecordDto> recordDtos = new ArrayList<>();
		for (DistanceBasedRecord record : records) {
			recordDtos.add(convertRecordEntityToDto(record));
		}
		return recordDtos;
	}
	
	private DistanceBasedRecordDto convertRecordEntityToDto(DistanceBasedRecord record) {
		return new DistanceBasedRecordDto(record);
	}
	
	private DistanceBasedRecord convertRecordDtoToEntity(DistanceBasedRecordDto recordDto) {
		return new DistanceBasedRecord(
				recordDto.getEntryTime().toInstant(),
				recordDto.getSportType(),
				recordDto.getUserId(),
				recordDto.getDistance(),
				recordDto.getDuration());
	}
}
