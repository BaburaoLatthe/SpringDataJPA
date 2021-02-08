package com.jpa.springjpahibernateexample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jpa.springjpahibernateexample.model.Users_Contact;

@Repository
public interface UsersContactRepository extends JpaRepository<Users_Contact, Integer> {

}
