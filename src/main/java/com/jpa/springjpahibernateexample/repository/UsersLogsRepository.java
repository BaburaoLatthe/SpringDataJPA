package com.jpa.springjpahibernateexample.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jpa.springjpahibernateexample.model.UsersLog;

@Repository
public interface UsersLogsRepository extends JpaRepository<UsersLog, Integer> {
	
	
	List<UsersLog> findByUserId(Integer uid);
}
