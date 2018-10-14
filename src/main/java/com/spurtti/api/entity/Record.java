package com.spurtti.api.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "record")
public class Record {

	@EmbeddedId
	@NotNull
	private RecordId key;
	
	@Column(name = "route_id")
	@NotNull
	private String routeId;
	
	@Column(name = "record_time")
	@NotNull
	private long recordTime;

	protected Record() {}

	public Record(RecordId key, String routeId, long recordTime) {
		this.key = key;
		this.routeId = routeId;
		this.recordTime = recordTime;
	}

	public RecordId getKey() {
		return key;
	}

	public long getRecordTime() {
		return recordTime;
	}

	public String getRouteId() {
		return routeId;
	}

	public void setKey(RecordId key) {
		this.key = key;
	}

	public void setRecordTime(long recordTime) {
		this.recordTime = recordTime;
	}

	public void setRouteId(String routeId) {
		this.routeId = routeId;
	}
}
