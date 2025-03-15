package User.example.demo.service;

import User.example.demo.entities.Role;
import User.example.demo.entities.User;
import User.example.demo.repository.RoleRepository;
import User.example.demo.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Transactional
@AllArgsConstructor
public class UserServiceImpl implements UserService{
private RoleRepository roleRepository;
private UserRepository userRepository;
    @Override
    public User addUser(User user) {
        user.setUserId(UUID.randomUUID().toString());
        return userRepository.save(user);
    }

    @Override
    public Role addRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public User findUserByName(String name) {
        return userRepository.findByUsername(name);
    }

    @Override
    public Role findRoleByName(String name) {
        return roleRepository.findByRoleName(name);
    }

    @Override
    public void addRoleToUser(String username, String rolename) {
User user=findUserByName(username);
Role role=findRoleByName(rolename);
if (user.getRoles()!=null){
    user.getRoles().add(role);
    role.getUsers().add(user);
}

    }

    @Override
    public User authenticate(String username, String password) {
        User user=findUserByName(username);
        if (user==null){
            throw new RuntimeException("bad credentials");

        }
        if (user.getPassword().equals(password)){
            return user;
        }
        throw new RuntimeException("bad credentials");
    }
}
