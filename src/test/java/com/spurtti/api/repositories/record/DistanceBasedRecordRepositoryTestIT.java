package com.spurtti.api.repositories.record;

import static org.junit.Assert.assertEquals;
import static com.spurtti.api.test.data.DistanceBasedRecordTestData.*;

import java.util.HashMap;
import java.util.List;

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
	
	// Combining Spring with JUnitParams by these rules
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
	public void testSearchRecordsWithoutParams() {
		List<DistanceBasedRecord> records = repository.searchRecords(new HashMap<>());
		assertEquals(2, records.size());
	}
	
	@Test
	@Parameters(method = "testSearchRecordsParams")
	public void testSearchRecords(String paramKey, Object paramValue, int expectedResultIndex) {
		List<DistanceBasedRecord> records = repository.searchRecords(createSearchParamsWithOneParam(
				paramKey, paramValue));
		assertEquals(1, records.size());
		assertResult(expectedResultIndex, records.get(0));
	}
	
	Object[][] testSearchRecordsParams() {
		return new Object[][] {
			{ SearchParams.SPORT_TYPE, SPORT_TYPE_WALK, 1 },
			{ SearchParams.SPORT_TYPE, SPORT_TYPE_RUN, 2 }
		};
	}
	
	private void assertResult(int resultIndex, DistanceBasedRecord record) {
		if (resultIndex == 1) {
			assertEquals(ENTRY_TIME_1, record.getEntryTime().toString());
			assertEquals(DISTANCE_1, record.getDistance());
			assertEquals(DURATION_1, record.getDuration());
			assertEquals(SPORT_TYPE_WALK, record.getSportType());
			assertEquals(USER_ID_1, record.getUserId());
		} else if (resultIndex == 2) {
			assertEquals(ENTRY_TIME_2, record.getEntryTime().toString());
			assertEquals(DISTANCE_2, record.getDistance());
			assertEquals(DURATION_2, record.getDuration());
			assertEquals(SPORT_TYPE_RUN, record.getSportType());
			assertEquals(USER_ID_2, record.getUserId());
		}
	}
}
