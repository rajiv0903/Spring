package com.practice.spring.springjpa.repository.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.practice.spring.springjpa.model.Activity;
import com.practice.spring.springjpa.model.Exercise;
import com.practice.spring.springjpa.repository.ExerciseJpaRepository;
import com.practice.spring.springjpa.repository.ExerciseRepository;


@Service("exerciseService")
public class ExerciseServiceImpl implements ExerciseService {
	
	@SuppressWarnings("unused")
	@Autowired
	private ExerciseRepository exerciseRepository;
	
	//JPA
	@Autowired
	private ExerciseJpaRepository exerciseJpaRepository;

	public List<Activity> findAllActivities() {
		
		List<Activity> activities = new ArrayList<Activity>();
		
		Activity run = new Activity();
		run.setDesc("Run");
		activities.add(run);
		
		Activity bike = new Activity();
		bike.setDesc("Bike");
		activities.add(bike);
		
		Activity swim = new Activity();
		swim.setDesc("Swim");
		activities.add(swim);
		
		return activities;
	}

	@Override
	@Transactional
	public Exercise save(Exercise exercise) {
		
		//return exerciseRepository.save(exercise);
		
		return exerciseJpaRepository.save(exercise);
	}
	
	
}
