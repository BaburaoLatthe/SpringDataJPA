package com.jpa.springjpahibernateexample.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jpa.springjpahibernateexample.model.Stream;

@Repository
public interface StreamRespository extends JpaRepository<Stream, Long> {

}
