package com.jpa.springjpahibernateexample.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jpa.springjpahibernateexample.model.Users;
import com.jpa.springjpahibernateexample.model.UsersLog;
import com.jpa.springjpahibernateexample.model.Users_Contact;
import com.jpa.springjpahibernateexample.repository.UsersLogsRepository;
import com.jpa.springjpahibernateexample.repository.UsersRepository;

@RestController
@RequestMapping(path = "/rest/userlogs")
public class UsersLogsResouce {

	@Autowired
	private UsersLogsRepository usersLogsRepository;

	@Autowired
	private UsersRepository usersRepository;

	@GetMapping(path = "/getUsers/{name}")
	public List<UsersLog> getAllUsers(@PathVariable(name = "name") String name) {
		
		Users_Contact users_contact2 = new Users_Contact();
		users_contact2.setPhoneNo("74063175980");

		UsersLog usersLog1 = new UsersLog();
		usersLog1.setLog("Log message1");

		UsersLog usersLog2 = new UsersLog();
		usersLog2.setLog("Log message2");

		Users users = new Users();
		users.setName(name);
		users.setSalary(10000);
		users.setTeamName("API Team");
		users.setUsersContact(users_contact2);
		users.addUsersLogs(usersLog1);
		users.addUsersLogs(usersLog2);

		usersRepository.save(users);

		return usersLogsRepository.findByUserId(2);

	}
}
