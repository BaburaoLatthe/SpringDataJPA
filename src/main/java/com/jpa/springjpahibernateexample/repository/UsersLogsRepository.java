package com.jpa.springjpahibernateexample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jpa.springjpahibernateexample.model.UsersLog;

@Repository
public interface UsersLogsRepository extends JpaRepository<UsersLog, Integer> {

}
