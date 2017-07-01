package fi.runners.runners.model;

import lombok.Getter;
import lombok.Setter;

public class Record {
	@Getter @Setter
	private String runnerId;
	@Getter @Setter
	private String entryTime;
	@Getter @Setter
	private String routeId;
	@Getter @Setter
	private long recordTime;
}
