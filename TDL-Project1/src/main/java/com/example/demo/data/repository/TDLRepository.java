package com.example.demo.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.data.model.TDL;

@Repository
public interface TDLRepository extends JpaRepository<TDL, Integer>{

	@Query("SELECT * FROM tdl WHERE id = ?1")
	public TDL getTaskByID(int id);
	
	@Query("SELECT * FROM tdl WHERE priority = ?1")
	public TDL getTaskByPriority(int priority);
	
	@Query(value = "SELECT * FROM tdl", nativeQuery = true)
	public List<TDL> getAllTasksSQL();
}
