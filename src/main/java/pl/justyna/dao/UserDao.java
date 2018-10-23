package pl.justyna.dao;

import java.util.List;

import pl.justyna.model.User;

public interface UserDao {

	void register(User user);

	User selectById(Integer id);

	List<User> selectAll();

	void updateById(User user);
}
