package com.jpa.springjpahibernateexample.resource;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jpa.springjpahibernateexample.model.Users;
import com.jpa.springjpahibernateexample.model.UsersLog;
import com.jpa.springjpahibernateexample.model.Users_Contact;
import com.jpa.springjpahibernateexample.repository.UsersContactRepository;
import com.jpa.springjpahibernateexample.repository.UsersRepository;

@RestController
@RequestMapping(path = "/rest/userscontact")
public class UsersContactResource {

	private UsersContactRepository usersContactRepository;

	private UsersRepository usersRepository;

	@Autowired
	public UsersContactResource(UsersContactRepository usersContactRepository, UsersRepository usersRepository) {
		this.usersContactRepository = usersContactRepository;
		this.usersRepository = usersRepository;
	}

	@GetMapping(path = "/allUserContacts")
	public List<Users_Contact> getUsersContact() {

		List<Users_Contact> allUsersContacts = usersContactRepository.findAll();
		return allUsersContacts;
	}

	@GetMapping(path = "/allUsers")
	public List<Users> getUsers() {

		List<Users> allUsers = usersRepository.findAll();
		return allUsers;
	}

	@GetMapping(path = "/updateUserContact/{name}")
	public List<Users> updateUserContact(@PathVariable(name = "name") final String name) {

//		Mapping Details from Users_Contact To Users Through UserContactRepository
		UsersLog usersLog1 = new  UsersLog();
		usersLog1.setLog("Silence is the answer when you are angry");
		
		UsersLog usersLog2 = new  UsersLog();
		usersLog2.setLog("I should have thought befor speaking rubbish");
		
		Users users = new Users();
		users.setName(name);
		users.setSalary(10000);
		users.setTeamName("API Team");
		users.setUsersLogs(Arrays.asList(usersLog1,usersLog2));

		Users_Contact users_contact = new Users_Contact();
		users_contact.setPhoneNo("7406317281");
		users_contact.setUsers(users);

		usersContactRepository.save(users_contact);

		return usersRepository.findAll();
	}

	@GetMapping(path = "/updateUser/{name}")
	public List<Users> updateUser(@PathVariable(name = "name") final String name) {
		
//		Mapping Details from Users To Users_Contact Through UsersRepository

		Users_Contact users_contact2 = new Users_Contact();
		users_contact2.setPhoneNo("74063175980");
		
		UsersLog usersLog1 = new  UsersLog();
		usersLog1.setLog("Silence is the answer when you are angry");
		
		UsersLog usersLog2 = new  UsersLog();
		usersLog2.setLog("I should have thought befor speaking rubbish");

		Users users2 = new Users();
		users2.setName(name);
		users2.setSalary(10000);
		users2.setTeamName("Development Team");
		users2.setUsersContact(users_contact2);
		users2.setUsersLogs(Arrays.asList(usersLog1,usersLog2));
		
		usersRepository.save(users2);
		
		return usersRepository.findAll();
		}

}
