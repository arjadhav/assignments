package com.example.assignment.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;


import com.example.assignment.model.Result;

@Service
public class OperationServiceImpl implements OperationService{

	@Override
	public Result performOperation(List<Integer> numberList) {
		  return prepareResponse(numberList);
	}
	
	private Result prepareResponse(List<Integer> numberList) {	
		Result result =new Result();
		result.setSum(getSum(numberList));
		result.setAverage(getAverage(numberList));
		result.setGreaterThanAverages(getGreaterThanAverage(numberList));
		return result;
	}
	
	private Integer getSum(List<Integer> numberList) {	
		return numberList.stream()
				  .mapToInt(Integer::intValue)
				  .sum();	
	}
	
	private float getAverage(List<Integer> numberList) {	
	    return getSum(numberList) / numberList.size(); 
	}
	
	private List<Integer> getGreaterThanAverage(List<Integer> numberList){
	  float sum=getAverage(numberList);
		return numberList.stream()
                .filter(val -> val.intValue() > sum)
                .collect(Collectors.toList());
    }

}
