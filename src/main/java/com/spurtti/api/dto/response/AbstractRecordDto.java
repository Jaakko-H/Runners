package com.spurtti.api.dto.response;

import java.time.ZoneOffset;
import java.time.ZonedDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.spurtti.api.collection.AbstractRecord;

/**
 * Base data transfer object class for all record data.
 * 
 * @author Jaakko-H
 *
 */
public abstract class AbstractRecordDto {
	
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	private ZonedDateTime entryTime;
	
	private String sportType;
	private String userId;
	
	public AbstractRecordDto() {
		super();
		this.entryTime = null;
		this.sportType = "";
		this.userId = "";
	}
	
	public AbstractRecordDto(AbstractRecord entity) {
		super();
		this.entryTime = ZonedDateTime.ofInstant(entity.getEntryTime(), ZoneOffset.UTC);
		this.sportType = entity.getSportType();
		this.userId = entity.getUserId();
	}

	public ZonedDateTime getEntryTime() {
		return entryTime;
	}
	public String getSportType() {
		return sportType;
	}
	public String getUserId() {
		return userId;
	}
}
