package com.spurtti.api.collection;

import java.time.Instant;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class AbstractRecord {

	@Id
	private ObjectId id;
	
	private Instant entryTime;
	
	private String sportType;

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public Instant getEntryTime() {
		return entryTime;
	}

	public void setEntryTime(Instant entryTime) {
		this.entryTime = entryTime;
	}
	
	public String getSportType() {
		return sportType;
	}
	
	public void setSportType(String sportType) {
		this.sportType = sportType;
	}
}
