package com.spurtti.api.dto.response;

import java.time.Instant;

/**
 * Base Dto class for all record data.
 * 
 * @author Jaakko-H
 *
 */
public abstract class AbstractRecordDto {
	
	private Instant entryTime;
	private String sportType;

	public Instant getEntryTime() {
		return entryTime;
	}
	public String getSportType() {
		return sportType;
	}
}
