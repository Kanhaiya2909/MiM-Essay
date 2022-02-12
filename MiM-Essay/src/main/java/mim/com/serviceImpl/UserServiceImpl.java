package mim.com.serviceImpl;

import java.util.Set;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mim.com.model.User;
import mim.com.model.UserRole;
import mim.com.repository.RoleRepository;
import mim.com.repository.UserRepository;
import mim.com.service.UserService;


@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;

	@Override
	public User createUser(User user, Set<UserRole> userRoles) throws Exception {
		User local = this.userRepository.findByUsername(user.getUsername());
		if(local != null) {
			System.out.println("Username already Exit");
			throw new Exception("Try with another Username \n Thank You!!");
		}else {
			for(UserRole ur: userRoles) {
				roleRepository.save(ur.getRole());
			}
			user.getUserRoles().addAll(userRoles);
			local = this.userRepository.save(user);
		}
		return local;
	}

	@Override
	public User getUser(String user) {
		// TODO Auto-generated method stub
		return this.userRepository.findByUsername(user);
	}

	@Override
	public void deleteUser(Long id) {
		this.userRepository.deleteById(id);
		
	}


}
