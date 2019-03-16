package com.spurtti.api.collection;

import com.spurtti.api.dto.response.DistanceBasedRecordDto;

/**
 * Collection class which represents any kind of time- and distance based sport records, e.g. walk, run.
 * 
 * @author Jaakko-H
 *
 */
public class DistanceBasedRecord extends AbstractRecord {

	private Double distance;
	private Long duration;
	
	public DistanceBasedRecord() {
		super();
	}
	
	public DistanceBasedRecord(DistanceBasedRecordDto recordDto) {
		super(recordDto.getEntryTime().toInstant(),
				recordDto.getSportType(),
				recordDto.getUserId());
		this.distance = recordDto.getDistance();
		this.duration = recordDto.getDuration();
	}
	
	public Double getDistance() {
		return distance;
	}
	public Long getDuration() {
		return duration;
	}
	public void setDistance(Double distance) {
		this.distance = distance;
	}
	public void setDuration(Long duration) {
		this.duration = duration;
	}
}
