package fi.runners.api.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class RecordId implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	protected String runnerId;
    protected String entryTime;

    public RecordId() {}

	public RecordId(String runnerId, String entryTime) {
		this.runnerId = runnerId;
		this.entryTime = entryTime;
	}
}
