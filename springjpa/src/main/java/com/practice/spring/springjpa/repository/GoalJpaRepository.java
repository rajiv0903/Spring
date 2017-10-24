package com.practice.spring.springjpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.practice.spring.springjpa.model.Goal;
import com.practice.spring.springjpa.model.GoalReports;

@Repository("goalJpaRepository")
public interface GoalJpaRepository  extends JpaRepository<Goal, Long>{

	@Query("select new com.practice.spring.springjpa.model.GoalReports(g.minutes, e.minutes, e.activity)"
			+ "from Goal g, Exercise e where g.id=e.goal.id")
	List<GoalReports> findAllGoalReports();
}
