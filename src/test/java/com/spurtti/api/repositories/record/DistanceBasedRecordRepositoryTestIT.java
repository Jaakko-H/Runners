package com.spurtti.api.repositories.record;

import static org.junit.Assert.assertEquals;
import static com.spurtti.api.test.data.DistanceBasedRecordTestData.*;

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
}
