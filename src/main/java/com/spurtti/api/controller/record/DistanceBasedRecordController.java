package com.spurtti.api.controller.record;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spurtti.api.collection.DistanceBasedRecord;
import com.spurtti.api.dto.response.DistanceBasedRecordDto;
import com.spurtti.api.services.record.DistanceBasedRecordService;

@Controller
@RequestMapping(AbstractRecordController.CONTEXT_PATH + "/distance-based")
public class DistanceBasedRecordController {
	
	@Inject
	private DistanceBasedRecordService service;

	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<DistanceBasedRecord> createRecord(@RequestBody DistanceBasedRecordDto recordDto) {
		return new ResponseEntity<DistanceBasedRecord>(service.createRecord(recordDto), HttpStatus.OK);
	}
}
