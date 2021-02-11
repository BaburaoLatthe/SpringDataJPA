package com.jpa.springjpahibernateexample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jpa.springjpahibernateexample.model.Viewer;

@Repository
public interface ViewerRepository extends JpaRepository<Viewer, Long> {

}
