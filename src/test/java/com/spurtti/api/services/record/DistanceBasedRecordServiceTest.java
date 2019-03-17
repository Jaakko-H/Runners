package com.spurtti.api.services.record;

import static com.spurtti.api.test.data.DistanceBasedRecordTestData.*;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.spurtti.api.collection.DistanceBasedRecord;
import com.spurtti.api.dto.response.DistanceBasedRecordDto;
import com.spurtti.api.repositories.record.DistanceBasedRecordRepository;
import com.spurtti.api.utils.SearchParams;

@RunWith(MockitoJUnitRunner.class)
public class DistanceBasedRecordServiceTest {
	
	@Mock
	private DistanceBasedRecordRepository mockRepository;
	
	@InjectMocks
	private DistanceBasedRecordService service = new DistanceBasedRecordServiceImpl();
	
	@Captor
	private ArgumentCaptor<Map<String, Object>> searchParamsCaptor;
	
	private DistanceBasedRecord record;
	
	private List<DistanceBasedRecord> records;
	
	@Before
	public void setUp() {
		records = new ArrayList<>();
		record = createRecordWithParams(ENTRY_TIME_1, DISTANCE_1, DURATION_1, SPORT_TYPE_WALK, USER_ID_1);
		records.add(record);
	}
	
	@Test
	public void testCreateRecord() {
		when(mockRepository.save(any(DistanceBasedRecord.class))).thenReturn(record);
		
		DistanceBasedRecordDto recordDto = service.createRecord(new DistanceBasedRecordDto(record));
		
		assertEquals(ENTRY_TIME_1, recordDto.getEntryTime().toString());
		assertEquals(DISTANCE_1, recordDto.getDistance());
		assertEquals(DURATION_1, recordDto.getDuration());
		assertEquals(SPORT_TYPE_WALK, recordDto.getSportType());
		assertEquals(USER_ID_1, recordDto.getUserId());
	}
	
	@Test
	public void testSearchRecords() {
		when(mockRepository.searchRecords(searchParamsCaptor.capture())).thenReturn(records);
		
		List<DistanceBasedRecordDto> recordDtos = service.searchRecords(createSearchParamsWithOneParam(
				SearchParams.SPORT_TYPE, SPORT_TYPE_WALK));
		
		assertEquals(SPORT_TYPE_WALK, searchParamsCaptor.getValue().get(SearchParams.SPORT_TYPE));
		assertEquals(1, recordDtos.size());
		DistanceBasedRecordDto recordDto = recordDtos.get(0);
		assertEquals(ENTRY_TIME_1, recordDto.getEntryTime().toString());
		assertEquals(DISTANCE_1, recordDto.getDistance());
		assertEquals(DURATION_1, recordDto.getDuration());
		assertEquals(SPORT_TYPE_WALK, recordDto.getSportType());
		assertEquals(USER_ID_1, recordDto.getUserId());
	}
}
