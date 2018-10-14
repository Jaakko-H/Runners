package com.spurtti.api.entity;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@Embeddable
public class RecordId implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Column(name = "userId")
	@NotNull
	private String userId;
	@Column(name = "entryTime")
	@NotNull
    private Instant entryTime;

	public RecordId() {}

	public RecordId(String userId, Instant entryTime) {
		this.userId = userId;
		this.entryTime = entryTime;
	}

	public Instant getEntryTime() {
		return entryTime;
	}

	public String getRunnerId() {
		return userId;
	}

    public void setEntryTime(Instant entryTime) {
		this.entryTime = entryTime;
	}

	public void setRunnerId(String userId) {
		this.userId = userId;
	}
}
