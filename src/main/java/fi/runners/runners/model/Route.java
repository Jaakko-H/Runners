package fi.runners.runners.model;

import lombok.Getter;
import lombok.Setter;

public class Route {
	@Getter @Setter
	private String routeId;
	@Getter @Setter
	private String routeName;
	@Getter @Setter
	private int length;
}
