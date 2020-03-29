package com.evolent.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.evolent.common.Response;
import com.evolent.constants.ResponseEnum;
import com.evolent.model.ContactInfo;
import com.evolent.service.ContactInfoService;

@RestController
@CrossOrigin
@RequestMapping(path = "/api/v1/cost-assignments")
public class ContactInfoController {

	@Autowired
	ContactInfoService costAssignmentService;
	
	@ResponseStatus(HttpStatus.OK)
	@GetMapping()
	public ResponseEntity<Response> getAllCostAssignment(@RequestParam("personResponsible") Optional<String> personResponsible, @RequestParam("expand") Optional<String> detailsRequired) {
		List<ContactInfo> costAssignmentList = null;
		if( personResponsible.isPresent() ) {
			costAssignmentList =  costAssignmentService.loadByPersonResponsible(personResponsible.get());
	    }else {
	    	costAssignmentList =  costAssignmentService.loadAll();
	    }
		 Response response= new Response(ResponseEnum.SUCCESS.toString(), null, costAssignmentList);
		 return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@ResponseStatus(HttpStatus.OK)
	@GetMapping("/{costAssignmentId}")
	public ResponseEntity<Response> getCostAssignmentById(@PathVariable(value = "costAssignmentId") String costAssignmentId) {
		ContactInfo costAssignment =  costAssignmentService.load(costAssignmentId);
		Response response = new Response(ResponseEnum.SUCCESS.toString(), null, costAssignment);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@SuppressWarnings("serial")
	@ResponseStatus(HttpStatus.OK)
	@PostMapping()
	public ResponseEntity<Response> createCostAssignment(@RequestBody ContactInfo costAssignment) {
		ContactInfo responseEntity =  costAssignmentService.save(costAssignment);
		Response response = new Response(ResponseEnum.SUCCESS.toString(), null, new HashMap<String, String>() {
			{
				put("costAssignmentId", responseEntity.getCostAssignmentId());
			}
		});
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@PutMapping("/{costAssignmentId}")
	public ResponseEntity<Response> updateCostAssignment(@RequestBody ContactInfo costAssignment,
			@PathVariable(value = "costAssignmentId") String costAssignmentId) {
		costAssignmentService.update(costAssignment, costAssignmentId);
		Response response = new Response(ResponseEnum.SUCCESS.toString(), null, null);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@PatchMapping("/{costAssignmentId}")
	public ResponseEntity<Response> patchUpdateCostAssignment(@RequestBody ContactInfo costAssignment, @PathVariable(value = "costAssignmentId") String costAssignmentId) {
		costAssignmentService.patchUpdate(costAssignment, costAssignmentId);
		Response response = new Response(ResponseEnum.SUCCESS.toString(), null, null);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@DeleteMapping("/{costAssignmentId}")
	public ResponseEntity<Response> deleteCostAssignment(@PathVariable(value = "costAssignmentId") String costAssignmentId) {
		costAssignmentService.delete(costAssignmentId);
		Response response = new Response(ResponseEnum.SUCCESS.toString(), null, null);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
}