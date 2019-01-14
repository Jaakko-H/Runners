package com.spurtti.api.collection;

import java.time.Instant;

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
	
	public DistanceBasedRecord(Instant entryTime, String sportType, String userId, Double distance, Long duration) {
		super(entryTime, sportType, userId);
		this.distance = distance;
		this.duration = duration;
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
