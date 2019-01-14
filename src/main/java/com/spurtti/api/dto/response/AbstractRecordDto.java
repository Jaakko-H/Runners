package com.spurtti.api.dto.response;

import java.time.ZonedDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * Base Dto class for all record data.
 * 
 * @author Jaakko-H
 *
 */
public abstract class AbstractRecordDto {
	
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	private ZonedDateTime entryTime;
	
	private String sportType;
	private String userId;

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
