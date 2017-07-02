package fi.runners.runners.dao;

import java.util.List;

import fi.runners.runners.model.Record;

public interface RecordDAO {
	public List<Record> findAll();
	public Record find(Record r);
	public void save(Record r);
}
