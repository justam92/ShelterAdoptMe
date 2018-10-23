package pl.justyna.serviceImpl;

import java.util.List;
import pl.justyna.dao.UserDao;
import pl.justyna.daoMock.UserDaoMock;
import pl.justyna.model.User;
import pl.justyna.service.UserService;

public class UserServiceImpl implements UserService {

	private UserDao userDao = new UserDaoMock();

	public void register(User user) {
		userDao.register(user);
	}

	public User selectById(Integer id) {
		return userDao.selectById(id);
	}

	public List<User> selectAll() {
		return userDao.selectAll();
	}

	public void updateById(User user) {
		userDao.updateById(user);
	}

	public void deleteById(Integer id) {
		System.out.println(" ");
		System.out.println("USUWANIE U¯YTKOWNIKA");
		System.out.println(" ");

		List<User> users = selectAll();
		boolean hasUserBeenFound = false;

		for (User user : users) {
			if (id == user.getId()) {
				hasUserBeenFound = true;
				users.remove(user);
				break;
			}
		}

		if (hasUserBeenFound) {
			System.out.println("Usuniêto konto u¿ytkownika: " + id);
		} else {
			System.out.println("W bazie danych nie znaleziono u¿ytkownika o imieniu: " + id);
		}
	}
	
	public User findUserById(Integer userId) {
		List<User> users = selectAll();

		User foundUser = null;

		for (User user : users) {
			if (userId == user.getId()) {
				foundUser = user;
				break;
			}
		}

		return foundUser;
	}
	
	public Boolean isUserAdult(User user) {
		boolean isUserAdult = true;

		if (user.getAge() < 18) {
			System.out.println("Jesteœ niepe³noletni. Poproœ opiekuna o adopcje.");
			isUserAdult = false;
		}

		return isUserAdult;
	}

}
