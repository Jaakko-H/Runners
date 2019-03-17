package com.spurtti.api.controller.record;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spurtti.api.dto.response.DistanceBasedRecordDto;
import com.spurtti.api.services.record.DistanceBasedRecordService;
import com.spurtti.api.utils.SearchParams;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(DistanceBasedRecordController.CONTEXT_PATH)
public class DistanceBasedRecordController extends AbstractRecordController {
	
	protected static final String CONTEXT_PATH = AbstractRecordController.CONTEXT_PATH + "/distance-based";
	
	@Inject
	private DistanceBasedRecordService service;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation("Search records by parameters")
	@ApiResponses({
		@ApiResponse(code = 200, message = "OK")
	})
	public ResponseEntity<List<DistanceBasedRecordDto>> getRecords(
			@RequestParam(value = SearchParams.SPORT_TYPE, required=false) String sportType) {
		Map<String, Object> searchParams = new HashMap<>();
		searchParams.put(SearchParams.SPORT_TYPE, sportType);
		return new ResponseEntity<>(service.searchRecords(searchParams), HttpStatus.OK);
	}

	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation("Create a new record")
	@ApiResponses({
		@ApiResponse(code = 200, message = "New distance based record created.")
	})
	public ResponseEntity<DistanceBasedRecordDto> createRecord(@RequestBody DistanceBasedRecordDto recordDto) {
		return new ResponseEntity<>(service.createRecord(recordDto), HttpStatus.OK);
	}
}
