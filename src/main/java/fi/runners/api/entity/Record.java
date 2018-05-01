package fi.runners.api.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Entity
@IdClass(RecordId.class)
@Table(name = "record")
public class Record {

	@EmbeddedId
	@Column(name = "runner_id")
	@NotNull
	@Getter @Setter
	private RecordId key;
	
	@Column(name = "route_id")
	@NotNull
	@Getter @Setter
	private String routeId;
	
	@Column(name = "record_time")
	@NotNull
	@Getter @Setter
	private long recordTime;

	protected Record() {}

	public Record(RecordId key, String routeId, long recordTime) {
		this.key = key;
		this.routeId = routeId;
		this.recordTime = recordTime;
	}
}
