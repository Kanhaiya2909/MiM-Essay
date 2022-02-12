package mim.com.controller;

import java.util.HashSet;


import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mim.com.model.Role;
import mim.com.model.User;
import mim.com.model.UserRole;
import mim.com.repository.UserRepository;
import mim.com.service.UserService;


@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@PostMapping("/")
	public User createUser(@RequestBody User user) throws Exception {
		
		user.setPassword(this.bCryptPasswordEncoder.encode(user.getPassword()));
		
		Role role = new Role();
		role.setRoleId(91L);
		role.setRoleName("NORMAL");
		
		UserRole userRole = new UserRole();
		userRole.setRole(role);
		userRole.setUser(user);
		
		Set<UserRole> userRoleSet = new HashSet<>();
		
		userRoleSet.add(userRole);
		 return this.userService.createUser(user, userRoleSet);
	}

	@GetMapping("/{username}")
	public User getUser(@PathVariable("username") String username) {
		return this.userService.getUser(username);
	}
	@DeleteMapping("/{id}")
	public void deleteUser(@PathVariable("id") Long id) {
		this.userService.deleteUser(id);
		System.out.println("Deleted!!");
	}
	
	@PutMapping("/{username1}")
	public ResponseEntity<User> updateUser(@PathVariable String username1, @RequestBody User username) {
		User user = userRepository.findByUsername(username1);
//		user.setUsername(username.getUsername());
		user.setPassword(username.getPassword());
		user.setEmail(username.getEmail());
		user.setContactNumber(username.getContactNumber());
		user.setFirstName(username.getFirstName());
		user.setLastName(username.getLastName());
		user.setImage(username.getImage());
		
		User save = userRepository.save(user);
		return ResponseEntity.ok(save);
	}
}
