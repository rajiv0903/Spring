package com.practice.spring.springjpa.repository.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.practice.spring.springjpa.model.Goal;
import com.practice.spring.springjpa.model.GoalReports;
import com.practice.spring.springjpa.repository.GoalJpaRepository;
import com.practice.spring.springjpa.repository.GoalRepository;

@Service("goalService")
public class GoalServiceImpl implements GoalService {

	@SuppressWarnings("unused")
	@Autowired
	private GoalRepository goalRepository;
	
	//JPA
	@Autowired
	private GoalJpaRepository goalJpaRepository;
	
	@Override
	@Transactional
	public Goal save(Goal goal) {
		
		//return goalRepository.save(goal);
		
		return goalJpaRepository.save(goal);
	}

	@Override
	public List<Goal> findAllGoals() {
		
		//return goalRepository.loadAll();
		
		return goalJpaRepository.findAll();
	}

	@Override
	public List<GoalReports> findAllGoalReports() {
		
		//return goalRepository.findAllGoalReports();
		return goalJpaRepository.findAllGoalReports();
	}

}
