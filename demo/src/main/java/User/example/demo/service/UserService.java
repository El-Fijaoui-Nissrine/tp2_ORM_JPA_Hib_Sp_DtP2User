package User.example.demo.service;

import User.example.demo.entities.Role;
import User.example.demo.entities.User;

public interface UserService {
    User addUser(User user);
    Role addRole(Role role);
    User findUserByName(String name);
    Role findRoleByName(String name);
void addRoleToUser(String username,String rolename);
User authenticate(String username,String password);
}
