package com.practice.spring.springjpa.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.practice.spring.springjpa.model.Exercise;

@Repository("exerciseRepository")
public class ExerciseRepositoryImpl implements ExerciseRepository {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Exercise save(Exercise exercise) {
		
		em.persist(exercise);
		em.flush();
		return exercise;
	}

}
