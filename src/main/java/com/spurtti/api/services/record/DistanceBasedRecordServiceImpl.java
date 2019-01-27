package com.spurtti.api.services.record;

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
	public DistanceBasedRecordDto createRecord(DistanceBasedRecordDto recordDto) {
		return new DistanceBasedRecordDto(repository.save(convertRecordDtoToEntity(recordDto)));
	}

	@Override
	public List<DistanceBasedRecordDto> getRecordsBySportType(String sportType) {
		// TODO Auto-generated method stub
		return null;
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
