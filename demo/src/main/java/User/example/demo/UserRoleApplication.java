package User.example.demo;

import User.example.demo.entities.Role;
import User.example.demo.entities.User;
import User.example.demo.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class UserRoleApplication {

	public static void main(String[] args) {

		SpringApplication.run(UserRoleApplication.class, args);
	}
@Bean
	CommandLineRunner start(UserService userService){
		return args->{
			Stream.of("ADMIN","USER","STUDENT").forEach(r->{
				Role rl=new Role();
				rl.setRoleName(r);
				userService.addRole(rl);

			});
			User u1=new User();
			u1.setUsername("admin");
			u1.setPassword("azerty");
			userService.addUser(u1);
			User u2=new User();
			u2.setUsername("user1");
			u2.setPassword("12345");
			userService.addUser(u2);
            userService.addRoleToUser("user1","STUDENT");
			userService.addRoleToUser("admin","ADMIN");
			userService.addRoleToUser("user1","USER");
			userService.addRoleToUser("admin","USER");
           try {
			   User user=userService.authenticate("user1","12345");
			   System.out.println(user.getUserId());
			   System.out.println(user.getUsername());
			   System.out.println("Roles=>");
			   user.getRoles().forEach(r->{
				   System.out.println("Role=>"+r.toString());
			   });


		   } catch (Exception e) {
			   e.printStackTrace();

		   }




		};
}
}
