package com.spurtti.api.collection;

/**
 * Collection class which represents any kind of time- and distance based sport records, e.g. walk, run.
 * 
 * @author Jaakko-H
 *
 */
public class DistanceBasedRecord extends AbstractRecord {

	private Double distance;
	private Long duration;
	
	public Double getDistance() {
		return distance;
	}
	public void setDistance(Double distance) {
		this.distance = distance;
	}
	public Long getDuration() {
		return duration;
	}
	public void setDuration(Long duration) {
		this.duration = duration;
	}
}
