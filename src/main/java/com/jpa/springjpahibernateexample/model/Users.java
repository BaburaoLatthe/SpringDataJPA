package com.jpa.springjpahibernateexample.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "users")
public class Users {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Integer id;

	@Column(name = "name")
	private String name;

	private Integer salary;

	private String teamName;

	@JsonManagedReference
	@OneToOne(mappedBy = "users", cascade = CascadeType.ALL)
	private Users_Contact usersContact;

	@JsonManagedReference
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
	private List<UsersLog> usersLogs = new ArrayList<>();

	public Users() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public void setUsersContact(Users_Contact usersContact) {
		this.usersContact = usersContact;
	}

	public List<UsersLog> getUsersLogs() {
		return usersLogs;
	}

	public void setUsersLogs(List<UsersLog> usersLogs) {
		this.usersLogs = usersLogs;
	}

	public Users_Contact getUsersContact() {
		return usersContact;
	}

	public Users(Integer id, String name, Integer salary, String teamName, Users_Contact usersContact) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.teamName = teamName;
		this.usersContact = usersContact;
	}

}
