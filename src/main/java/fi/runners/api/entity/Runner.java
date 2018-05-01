package fi.runners.api.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "runner")
public class Runner {
	@Id
	@Column(name = "runner_id")
	@Getter @Setter
	private String runnerId;
	
	@Column(name = "runner_name")
	@Getter @Setter
	private String runnerName;
	
	protected Runner() {}

	public Runner(String runnerId, String runnerName) {
		super();
		this.runnerId = runnerId;
		this.runnerName = runnerName;
	}
}
