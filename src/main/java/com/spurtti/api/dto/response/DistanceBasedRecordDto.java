package com.spurtti.api.dto.response;

/**
 * Dto class for distance based records.
 * 
 * @author Jaakko-H
 *
 */
public class DistanceBasedRecordDto extends AbstractRecordDto {

	private Double distance;
	private Long duration;
	
	public Double getDistance() {
		return distance;
	}
	public Long getDuration() {
		return duration;
	}
}
