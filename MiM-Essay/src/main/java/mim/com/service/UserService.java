package mim.com.service;

import java.util.Set;

import mim.com.model.User;
import mim.com.model.UserRole;



public interface UserService {
	
	public User createUser(User user, Set<UserRole> userRoles)throws Exception;
	
	public User getUser(String user);
	
	public void deleteUser(Long id);
	
	

}
