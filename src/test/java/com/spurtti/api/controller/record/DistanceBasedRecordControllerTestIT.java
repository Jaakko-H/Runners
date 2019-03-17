package com.spurtti.api.controller.record;

import static com.spurtti.api.test.data.DistanceBasedRecordTestData.*;
import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import javax.inject.Inject;

import org.junit.After;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.rules.SpringClassRule;
import org.springframework.test.context.junit4.rules.SpringMethodRule;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.spurtti.api.SpurttiApplication;
import com.spurtti.api.repositories.record.DistanceBasedRecordRepository;
import com.spurtti.api.utils.SearchParams;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

@RunWith(JUnitParamsRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT,
  classes = SpurttiApplication.class)
// Security not yet implemented
@AutoConfigureMockMvc(secure=false)
public class DistanceBasedRecordControllerTestIT {
	
	// Combining Spring with JUnitParams by these rules
	@ClassRule
    public static final SpringClassRule SPRING_CLASS_RULE = new SpringClassRule();
	
	@Rule
    public final SpringMethodRule springMethodRule = new SpringMethodRule();

	@Inject
	private MockMvc mockMvc;
	
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
	public void testGetRecordsWithoutParams() throws Exception {
		mockMvc.perform(get(DistanceBasedRecordController.CONTEXT_PATH))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$", hasSize(2)));
	}
	
	@Test
	@Parameters(method = "testGetRecordsParams")
	public void testGetRecords(String paramKey, String paramValue, int expectedResultIndex) throws Exception {
		ResultActions resultActions = mockMvc.perform(get(DistanceBasedRecordController.CONTEXT_PATH)
				.param(paramKey, paramValue))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$", hasSize(1)));
		assertResult(expectedResultIndex, resultActions);
	}
	
	Object[][] testGetRecordsParams() {
		return new Object[][] {
			{ SearchParams.SPORT_TYPE, SPORT_TYPE_WALK, 1 },
			{ SearchParams.SPORT_TYPE, SPORT_TYPE_RUN, 2 }
		};
	}
	
	private void assertResult(int expectedResultIndex, ResultActions resultActions) throws Exception {
		if (expectedResultIndex == 1) {
			resultActions.andExpect(jsonPath("$[0].entryTime", is(ENTRY_TIME_1)))
			.andExpect(jsonPath("$[0].distance", is(DISTANCE_1)))
			.andExpect(jsonPath("$[0].duration", is(DURATION_1.intValue())))
			.andExpect(jsonPath("$[0].sportType", is(SPORT_TYPE_WALK)))
			.andExpect(jsonPath("$[0].userId", is(USER_ID_1)));
		} else if (expectedResultIndex == 2) {
			resultActions.andExpect(jsonPath("$[0].entryTime", is(ENTRY_TIME_2)))
			.andExpect(jsonPath("$[0].distance", is(DISTANCE_2)))
			.andExpect(jsonPath("$[0].duration", is(DURATION_2.intValue())))
			.andExpect(jsonPath("$[0].sportType", is(SPORT_TYPE_RUN)))
			.andExpect(jsonPath("$[0].userId", is(USER_ID_2)));
		}
	}
}
