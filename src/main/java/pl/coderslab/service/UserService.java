package pl.coderslab.service;

import pl.coderslab.entity.User;

public interface UserService {
	public User findByUserName(String name);

	public void saveAdmin(User user);
}
