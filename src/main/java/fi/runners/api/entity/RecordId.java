package fi.runners.api.entity;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@Embeddable
public class RecordId implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Column(name = "runner_id")
	@NotNull
	private String runnerId;
	@Column(name = "entry_time")
	@NotNull
    private Instant entryTime;

	public RecordId() {}

	public RecordId(String runnerId, Instant entryTime) {
		this.runnerId = runnerId;
		this.entryTime = entryTime;
	}

	public Instant getEntryTime() {
		return entryTime;
	}

	public String getRunnerId() {
		return runnerId;
	}

    public void setEntryTime(Instant entryTime) {
		this.entryTime = entryTime;
	}

	public void setRunnerId(String runnerId) {
		this.runnerId = runnerId;
	}
}
