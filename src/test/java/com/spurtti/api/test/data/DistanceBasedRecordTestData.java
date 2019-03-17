package com.spurtti.api.test.data;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

import com.spurtti.api.collection.DistanceBasedRecord;

public class DistanceBasedRecordTestData {

	public static final Double DISTANCE_1 = 1.23;
	public static final Double DISTANCE_2 = 4.56;
	
	public static final Long DURATION_1 = 123L;
	public static final Long DURATION_2 = 456L;
	
	public static final String ENTRY_TIME_1 = "2019-03-16T09:00:01Z";
	public static final String ENTRY_TIME_2 = "2019-03-17T09:00:01Z";
	public static final String SPORT_TYPE_RUN = "run";
	public static final String SPORT_TYPE_WALK = "walk";
	public static final String USER_ID_1 = "userId1";
	public static final String USER_ID_2 = "userId2";
	
	private DistanceBasedRecordTestData() {}
	
	public static DistanceBasedRecord createRecordWithParams(String entryTimeString, Double distance, Long duration,
			String sportType, String userId) {
		DistanceBasedRecord record = new DistanceBasedRecord();
		record.setEntryTime(Instant.parse(entryTimeString));
		record.setDistance(distance);
		record.setDuration(duration);
		record.setSportType(sportType);
		record.setUserId(userId);
		return record;
	}
	
	public static Map<String, Object> createSearchParamsWithOneParam(String paramKey, Object paramValue) {
		Map<String, Object> searchParams = new HashMap<>();
		searchParams.put(paramKey, paramValue);
		return searchParams;
	}
}
