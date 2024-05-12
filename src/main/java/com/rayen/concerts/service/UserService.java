package com.rayen.concerts.service;

import com.rayen.concerts.entities.Role;
import com.rayen.concerts.entities.User;

public interface UserService {
	void deleteAllusers();

	void deleteAllRoles();

	User saveUser(User user);

	User findUserByUsername(String username);

	Role addRole(Role role);

	User addRoleToUser(String username, String rolename);
}
