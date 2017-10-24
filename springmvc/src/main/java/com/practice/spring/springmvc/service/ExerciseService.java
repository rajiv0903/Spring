package com.practice.spring.springmvc.service;

import java.util.List;

import com.practice.spring.springmvc.model.Activity;

public interface ExerciseService {

	List<Activity> findAllActivities();

}