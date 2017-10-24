package com.practice.spring.springjpa.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.practice.spring.springjpa.model.Goal;
import com.practice.spring.springjpa.model.GoalReports;

@Repository("goalRepository")
public class GoalRepositoryImpl implements GoalRepository {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Goal save(Goal goal) {
		
		em.persist(goal);
		em.flush();
		return goal;
	}

	@Override
	public List<Goal> loadAll() {
		//JPQL
		//Query query = em.createQuery("select g from Goal g");
		//Named Query
		TypedQuery<Goal> query = em.createNamedQuery(Goal.FINAL_ALL_GOALS, Goal.class);
		
		List<Goal> goals = query.getResultList();
		return goals;
	}

	@Override
	public List<GoalReports> findAllGoalReports() {
		
//		Query query = em.createQuery("select new com.practice.model.GoalReports(g.minutes, e.minutes, e.activity)"
//				+ "from Goal g, Exercise e where g.id=e.goal.id");
		
		//Named Query
		TypedQuery<GoalReports>  query = em.createNamedQuery(Goal.FIND_GOAL_REPORTS, GoalReports.class);
		return query.getResultList();
	}

}
