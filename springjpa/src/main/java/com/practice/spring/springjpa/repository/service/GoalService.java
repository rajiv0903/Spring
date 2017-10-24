package com.practice.spring.springjpa.repository.service;

import java.util.List;

import com.practice.spring.springjpa.model.Goal;
import com.practice.spring.springjpa.model.GoalReports;

public interface GoalService {

	Goal save (Goal goal);

	List<Goal> findAllGoals();

	List<GoalReports> findAllGoalReports();
}
