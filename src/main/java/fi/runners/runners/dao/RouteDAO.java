package fi.runners.runners.dao;

import java.util.List;

import fi.runners.runners.model.Route;

public interface RouteDAO {
	public List<Route> findAll();
	public Route find(Route r);
	public void save(Route r);
}
