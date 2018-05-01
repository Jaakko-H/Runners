package fi.runners.api.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class RecordId implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String runnerId;
    private String entryTime;

	public RecordId() {}

	public RecordId(String runnerId, String entryTime) {
		this.runnerId = runnerId;
		this.entryTime = entryTime;
	}

	public String getEntryTime() {
		return entryTime;
	}

	public String getRunnerId() {
		return runnerId;
	}

    public void setEntryTime(String entryTime) {
		this.entryTime = entryTime;
	}

	public void setRunnerId(String runnerId) {
		this.runnerId = runnerId;
	}
}
