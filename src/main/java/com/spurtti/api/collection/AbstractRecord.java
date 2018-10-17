package com.spurtti.api.collection;

import java.time.Instant;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class AbstractRecord {

	@Id
	private ObjectId id;
	
	private Instant entryTime;
}
