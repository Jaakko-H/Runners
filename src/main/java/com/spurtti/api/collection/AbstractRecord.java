package com.spurtti.api.collection;

import java.time.Instant;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

/**
 * Base class for all record collection classes.
 * 
 * @author Jaakko-H
 *
 */
public class AbstractRecord {

	@Id
	private ObjectId id;
	
	private Instant entryTime;
	
	private String sportType;
	
	private String userId;

	public Instant getEntryTime() {
		return entryTime;
	}

	public ObjectId getId() {
		return id;
	}

	public String getSportType() {
		return sportType;
	}

	public String getUserId() {
		return userId;
	}

	public void setEntryTime(Instant entryTime) {
		this.entryTime = entryTime;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}
	
	public void setSportType(String sportType) {
		this.sportType = sportType;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
}
