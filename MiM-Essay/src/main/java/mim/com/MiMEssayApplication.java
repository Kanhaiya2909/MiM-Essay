package mim.com;

//import java.util.HashSet;
//
//import java.util.Set;
//
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//import mim.com.model.Role;
//import mim.com.model.User;
//import mim.com.model.UserRole;
//import mim.com.service.UserService;

@SpringBootApplication
public class MiMEssayApplication implements CommandLineRunner{
//	@Autowired
//	private UserService userservice;

	public static void main(String[] args) {
		SpringApplication.run(MiMEssayApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Starting...");
		
//		User user = new User();
//		user.setUsername("Kanhaiya_2909_");
//		user.setPassword("123456");
//		user.setImage("kk.png");
//		user.setEmail("kanhaiyakumar@gmail.com");
//		user.setFirstName("Kanhaiya");
//		user.setLastName("Kumar");
//		user.setContactNumber("1209348756");
//		
//		Role role = new Role();
//		role.setRoleId(12L);
//		role.setRoleName("ADMIN");
//		
//		UserRole userRole = new UserRole();
//		userRole.setRole(role);
//		userRole.setUser(user);
//		
//		Set<UserRole> userRoles = new HashSet<>();
//		userRoles.add(userRole);
//		User createUser = this.userservice.createUser(user, userRoles);
//		
//		System.out.println(createUser.getUsername());
//		
	}

}
