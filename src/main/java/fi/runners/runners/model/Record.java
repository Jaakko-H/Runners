package fi.runners.runners.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

abstract class RecordPK implements Serializable {
	protected String runnerId;
    protected String entryTime;

    public RecordPK() {}

	public RecordPK(String runnerId, String entryTime) {
		super();
		this.runnerId = runnerId;
		this.entryTime = entryTime;
	}
}

@Entity
@IdClass(RecordPK.class)
@Table(name = "record")
public class Record implements Serializable {
	@Id
	@Column(name = "runner_id")
	@Getter @Setter
	private String runnerId;
	
	@Id
	@Column(name = "entry_time")
	@Getter @Setter
	private String entryTime;
	
	@Column(name = "route_id")
	@Getter @Setter
	private String routeId;
	
	@Column(name = "record_time")
	@Getter @Setter
	private long recordTime;

	protected Record() {}

	public Record(String runnerId, String entryTime, String routeId, long recordTime) {
		this.runnerId = runnerId;
		this.entryTime = entryTime;
		this.routeId = routeId;
		this.recordTime = recordTime;
	}
}
