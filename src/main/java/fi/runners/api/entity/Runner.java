package fi.runners.api.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "runner")
public class Runner {
	@Id
	@Column(name = "runner_id")
	private String runnerId;
	
	@Column(name = "name")
	private String name;

	protected Runner() {}

	public Runner(String runnerId, String name) {
		super();
		this.runnerId = runnerId;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public String getRunnerId() {
		return runnerId;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public void setRunnerId(String runnerId) {
		this.runnerId = runnerId;
	}
}
