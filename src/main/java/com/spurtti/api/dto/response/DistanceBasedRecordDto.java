package com.spurtti.api.dto.response;

import com.spurtti.api.collection.DistanceBasedRecord;

/**
 * Data transfer object class for distance based records.
 * 
 * @author Jaakko-H
 *
 */
public class DistanceBasedRecordDto extends AbstractRecordDto {

	private Double distance;
	private Long duration;
	
	public DistanceBasedRecordDto() {
		super();
		this.distance = null;
		this.duration = null;
	}
	
	public DistanceBasedRecordDto(DistanceBasedRecord entity) {
		super(entity);
		this.distance = entity.getDistance();
		this.duration = entity.getDuration();
	}
	
	public Double getDistance() {
		return distance;
	}
	public Long getDuration() {
		return duration;
	}
}
