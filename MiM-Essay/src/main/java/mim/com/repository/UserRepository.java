package mim.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mim.com.model.User;



public interface UserRepository extends JpaRepository<User, Long>{
	
	public User findByUsername(String username);

}
