package com.practice.spring.springjpa.repository;

import java.util.List;

import com.practice.spring.springjpa.model.Goal;
import com.practice.spring.springjpa.model.GoalReports;

public interface GoalRepository {

	Goal save(Goal goal);

	List<Goal> loadAll();

	List<GoalReports> findAllGoalReports();
}
