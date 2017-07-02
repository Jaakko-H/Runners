package fi.runners.runners.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "route")
public class Route {
	@Id
	@Column(name = "route_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Getter @Setter
	private String routeId;
	
	@Column(name = "route_name")
	@Getter @Setter
	private String routeName;
	
	@Column(name = "length")
	@Getter @Setter
	private int length;
	
	protected Route() {}

	public Route(String routeId, String routeName, int length) {
		super();
		this.routeId = routeId;
		this.routeName = routeName;
		this.length = length;
	}
}
