package com.jpa.springjpahibernateexample.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jpa.springjpahibernateexample.model.Users;

public interface UsersRepository extends JpaRepository<Users, Integer> {
	
    List<Users> findByName(String name);

}
