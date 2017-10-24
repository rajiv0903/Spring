package com.practice.spring.springjpa.model;

public class GoalReports {

	private int goalMinutes;
	private int exerciseMinutes;
	private String exerciseActivity;
	
	
	public GoalReports(int goalMinutes, int exerciseMinutes, String exerciseActivity) {
		super();
		this.goalMinutes = goalMinutes;
		this.exerciseMinutes = exerciseMinutes;
		this.exerciseActivity = exerciseActivity;
	}


	public int getGoalMinutes() {
		return goalMinutes;
	}


	public void setGoalMinutes(int goalMinutes) {
		this.goalMinutes = goalMinutes;
	}


	public int getExerciseMinutes() {
		return exerciseMinutes;
	}


	public void setExerciseMinutes(int exerciseMinutes) {
		this.exerciseMinutes = exerciseMinutes;
	}


	public String getExerciseActivity() {
		return exerciseActivity;
	}


	public void setExerciseActivity(String exerciseActivity) {
		this.exerciseActivity = exerciseActivity;
	}
	
	
	
}
