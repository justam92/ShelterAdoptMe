package pl.justyna.controller;

import java.util.List;

import pl.justyna.model.User;
import pl.justyna.service.UserService;
import pl.justyna.serviceImpl.UserServiceImpl;

public class UserController {

	private UserService service = new UserServiceImpl();

	public void register(User newUser) {
		service.register(newUser);
	}

	public User getById(Integer id) {
		User user = service.selectById(id);
		return user;
	}

	public List<User> getAll() {
		List<User> users = service.selectAll();
		return users;
	}

	public void updateUserAccount(User user) {
		service.updateById(user);
	}

	public void deleteById(Integer id) {
		service.deleteById(id);
	}

}
