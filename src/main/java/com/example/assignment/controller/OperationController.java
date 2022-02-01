package com.example.assignment.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.assignment.model.InputData;
import com.example.assignment.model.ResponseEntity;
import com.example.assignment.model.Result;
import com.example.assignment.service.OperationService;

@RestController
@RequestMapping(path = "/api")
public class OperationController {

	@Autowired
	private OperationService operationService;

	@PostMapping(value="/numberOperations")
	public ResponseEntity performOperation(@RequestBody InputData inputs ) {
		List<Integer> numbers = new ArrayList();
		ResponseEntity responseEntity = new ResponseEntity();
		try {
			inputs.getInputs().forEach(x -> {
			    numbers.add((Integer) x);
			});
		}catch(Exception ex) {
			responseEntity.setStatus("Failed");
	    	responseEntity.setMessage("Numeric input expected,received invalid numbers in input");
	    	return responseEntity;
		}
		Result result = operationService.performOperation(numbers);
		
		if(result!=null) {
			responseEntity.setStatus("Success");
		    responseEntity.setResults(result);
		}
		return responseEntity;
	}
}
