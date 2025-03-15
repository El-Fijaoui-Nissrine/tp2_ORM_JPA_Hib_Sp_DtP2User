package User.example.demo.repository;

import User.example.demo.entities.Role;
import User.example.demo.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Long> {
    Role findByRoleName(String roleName);

}
