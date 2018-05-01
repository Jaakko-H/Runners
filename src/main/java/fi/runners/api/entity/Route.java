package fi.runners.api.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "route")
public class Route {
	@Id
	@Column(name = "route_id")
	private String routeId;
	
	@Column(name = "route_name")
	private String routeName;

	@Column(name = "length")
	private int length;

	protected Route() {}

	public Route(String routeId, String routeName, int length) {
		super();
		this.routeId = routeId;
		this.routeName = routeName;
		this.length = length;
	}

	public int getLength() {
		return length;
	}

	public String getRouteId() {
		return routeId;
	}

	public String getRouteName() {
		return routeName;
	}
	
	public void setLength(int length) {
		this.length = length;
	}
	
	public void setRouteId(String routeId) {
		this.routeId = routeId;
	}

	public void setRouteName(String routeName) {
		this.routeName = routeName;
	}
}
