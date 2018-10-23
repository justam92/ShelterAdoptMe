package pl.justyna.daoMock;

import java.util.ArrayList;
import java.util.List;

import pl.justyna.dao.UserDao;
import pl.justyna.model.Animal;
import pl.justyna.model.FurColor;
import pl.justyna.model.Sex;
import pl.justyna.model.Species;
import pl.justyna.model.User;

public class UserDaoMock implements UserDao {

	private List<User> users = new ArrayList<User>();

	public UserDaoMock() {

		Animal animal9 = new Animal();
		animal9.setId(9);
		animal9.setName("Kie³");
		animal9.setSex(Sex.M);
		animal9.setSpecies(Species.Wilk);
		animal9.setAge(41);
		animal9.setHasAnimalBeenAdopted(new Boolean("false"));
		animal9.setFurColor(FurColor.Szary);

		User user1 = new User();
		user1.setId(1);
		user1.setName("Jan");
		user1.setSurname("Kowalski");
		user1.setSex(Sex.M);
		user1.setAge(44);
		user1.getAdoptedPets().add(animal9);

		users.add(user1);

		User user2 = new User();
		user2.setId(2);
		user2.setName("Justyna");
		user2.setSurname("Mszyklocka");
		user2.setSex(Sex.K);
		user2.setAge(26);
		user2.getAdoptedPets().add(animal9);

		users.add(user2);

		User user3 = new User();
		user3.setId(3);
		user3.setName("Krystian");
		user3.setSurname("Rzadgiewidz");
		user3.setSex(Sex.M);
		user3.setAge(25);
		user3.getAdoptedPets().add(animal9);

		users.add(user3);

		User user4 = new User();
		user4.setId(4);
		user4.setName("Bella");
		user4.setSurname("Æwir");
		user1.setSex(Sex.K);
		user1.setAge(16);
		user4.getAdoptedPets().add(animal9);

		users.add(user4);

		User user5 = new User();
		user5.setId(5);
		user5.setName("Andrzej");
		user5.setSurname("Sapkowski");
		user5.setSex(Sex.M);
		user5.setAge(37);
		user5.getAdoptedPets().add(animal9);

		users.add(user5);
	}

	public void register(User user) {
		Integer lastId = 0;

		for (User userWithLastId : users) {
			lastId = Math.max(lastId, userWithLastId.getId());
		}

		user.setId(lastId + 1);

		users.add(user);
	}

	public User selectById(Integer id) {
		for (User user : users) {
			if (user.getId().equals(id)) {
				return user;
			}
		}

		throw new RuntimeException("Brak u¿ytkownika o id: " + id);
	}

	public List<User> selectAll() {
		return users;
	}

	public void updateById(User user) {
		for (User userToUpdate : users) {
			if (userToUpdate.getId().equals(user.getId())) {
				userToUpdate.setName(user.getName());
				userToUpdate.setSurname(user.getSurname());
				userToUpdate.setSex(user.getSex());
				userToUpdate.setAge(user.getAge());
				userToUpdate.setAdoptedPets(user.getAdoptedPets());
				break;
			}
		}
	}

}
