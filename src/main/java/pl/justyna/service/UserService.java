package pl.justyna.service;

import java.util.List;

import pl.justyna.model.User;

public interface UserService {

	void register(User user);

	User selectById(Integer id);

	List<User> selectAll();

	void updateById(User user);

	void deleteById(Integer id);
	
	User findUserById(Integer userId);

	Boolean isUserAdult(User user);
}
