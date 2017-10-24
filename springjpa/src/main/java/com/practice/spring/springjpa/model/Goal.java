package com.practice.spring.springjpa.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Range;


@Entity
@Table(name="GOALS")
@NamedQueries({
	@NamedQuery(name= Goal.FIND_GOAL_REPORTS, query="select new com.practice.spring.springjpa.model.GoalReports(g.minutes, e.minutes, e.activity)"
			+ "from Goal g, Exercise e where g.id=e.goal.id"),
	
	@NamedQuery(name=Goal.FINAL_ALL_GOALS, query="select g from Goal g")
})
public class Goal {
	
	//Named Quieires- To avoid adhoc JPQL
	public static final String FINAL_ALL_GOALS="findAllGoals";

	public static final String FIND_GOAL_REPORTS="findGoalReports";

	@Id
	@GeneratedValue
	@Column(name="id")
	private Long id;
	
	@Range(min = 1, max = 120)
	@Column(name="minutes")
	private int minutes;
	
	//@OneToMany(mappedBy="goal",  cascade= CascadeType.ALL, fetch= FetchType.EAGER)
	@OneToMany(mappedBy="goal",  cascade= CascadeType.ALL, fetch= FetchType.LAZY)
	private List<Exercise> excercises = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public int getMinutes() {
		return minutes;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}

	public List<Exercise> getExcercises() {
		return excercises;
	}

	public void setExcercises(List<Exercise> excercises) {
		this.excercises = excercises;
	}
	
}
