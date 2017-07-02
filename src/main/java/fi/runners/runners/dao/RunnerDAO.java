package fi.runners.runners.dao;

import java.util.List;

import fi.runners.runners.model.Runner;

public interface RunnerDAO {
	public List<Runner> findAll();
	public Runner find(Runner r);
	public void save(Runner r);
}
