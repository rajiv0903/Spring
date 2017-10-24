package com.practice.spring.springjpa.repository.service;

import java.util.List;

import com.practice.spring.springjpa.model.Activity;
import com.practice.spring.springjpa.model.Exercise;

public interface ExerciseService {

	List<Activity> findAllActivities();

	Exercise save(Exercise exercise);

}