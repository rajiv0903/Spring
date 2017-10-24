package com.practice.spring.springjpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practice.spring.springjpa.model.Exercise;

@Repository("exerciseJpaRepository")
public interface ExerciseJpaRepository extends JpaRepository<Exercise, Long>{

}
