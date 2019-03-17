package com.spurtti.api.repositories.record;

import static org.junit.Assert.assertEquals;

import java.time.Instant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.junit.After;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.rules.SpringClassRule;
import org.springframework.test.context.junit4.rules.SpringMethodRule;

import com.spurtti.api.SpurttiApplication;
import com.spurtti.api.collection.DistanceBasedRecord;
import com.spurtti.api.utils.SearchParams;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

@RunWith(JUnitParamsRunner.class)
@SpringBootTest(classes = SpurttiApplication.class)
public class DistanceBasedRecordRepositoryTestIT {
	
	private static final Double DISTANCE_1 = 1.23;
	private static final Double DISTANCE_2 = 4.56;
	
	private static final Long DURATION_1 = 123L;
	private static final Long DURATION_2 = 456L;
	
	private static final String ENTRY_TIME_1 = "2019-03-16T09:00:00Z";
	private static final String ENTRY_TIME_2 = "2019-03-17T09:00:00Z";
	private static final String SPORT_TYPE_RUN = "run";
	private static final String SPORT_TYPE_WALK = "walk";
	private static final String USER_ID_1 = "userId1";
	private static final String USER_ID_2 = "userId2";
	
	@ClassRule
    public static final SpringClassRule SPRING_CLASS_RULE = new SpringClassRule();
	
	@Rule
    public final SpringMethodRule springMethodRule = new SpringMethodRule();

	@Inject
	private DistanceBasedRecordRepository repository;
	
	@Before
	public void setUp() {
		repository.save(createRecordWithParams(ENTRY_TIME_1, DISTANCE_1, DURATION_1, SPORT_TYPE_WALK, USER_ID_1));
		repository.save(createRecordWithParams(ENTRY_TIME_2, DISTANCE_2, DURATION_2, SPORT_TYPE_RUN, USER_ID_2));
	}
	
	@After
	public void tearDown() {
		repository.deleteAll();
	}
	
	@Test
	@Parameters(method = "testSearchRecordsParams")
	public void testSearchRecords(String sportType, int expectedResultSize) {
		List<DistanceBasedRecord> records = repository.searchRecords(createSearchParams(sportType));
		assertEquals(expectedResultSize, records.size());
	}
	
	Object[][] testSearchRecordsParams() {
		return new Object[][] {
			{ SPORT_TYPE_WALK, 1 },
			{ null, 2 }
		};
	}
	
	private DistanceBasedRecord createRecordWithParams(String entryTimeString, Double distance, Long duration,
			String sportType, String userId) {
		DistanceBasedRecord record = new DistanceBasedRecord();
		record.setEntryTime(Instant.parse(entryTimeString));
		record.setDistance(distance);
		record.setDuration(duration);
		record.setSportType(sportType);
		record.setUserId(userId);
		return record;
	}
	
	private Map<String, Object> createSearchParams(String sportType) {
		Map<String, Object> searchParams = new HashMap<>();
		searchParams.put(SearchParams.SPORT_TYPE, sportType);
		return searchParams;
	}
}
