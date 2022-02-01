package com.example.assignment.model;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Result {

	private Integer sum;
	private float average;
	private List<Integer> greaterThanAverages;
}
