package pl.justyna.serviceImpl;

import java.util.List;

import pl.justyna.dao.AnimalDao;
import pl.justyna.daoMock.AnimalDaoMock;
import pl.justyna.model.Animal;
import pl.justyna.model.FurColor;
import pl.justyna.model.Species;
import pl.justyna.model.User;
import pl.justyna.service.AnimalService;
import pl.justyna.service.UserService;

public class AnimalServiceImpl implements AnimalService {

	private AnimalDao animalDao = new AnimalDaoMock();

	private UserService userService = new UserServiceImpl();

	public void register(Animal newAnimal) {
		animalDao.register(newAnimal);

	}

	public Animal selectById(Integer id) {
		Animal animal = animalDao.selectById(id);
		return animal;
	}

	public List<Animal> selectAll() {
		List<Animal> animals = animalDao.selectAll();
		return animals;
	}

	public void deleteById(Integer id) {
		System.out.println(" ");
		System.out.println(" USUWANIE DANYCH O ZWIERZÊCIU DO ZAADOPTOWANIA");
		System.out.println(" ");

		List<Animal> animals = selectAll();
		boolean hasAnimalBeenFound = false;

		for (Animal animal : animals) {
			if (id == animal.getId()) {
				hasAnimalBeenFound = true;
				animals.remove(animal);
				break;
			}
		}

		if (hasAnimalBeenFound) {
			System.out.println("Dane o zwierzêciu o id " + id + " zosta³y usuniête...");
		} else {
			System.out.println("W bazie danych nie ma zwierzecia o id: " + id);
		}
	}

	public void adopt(Integer animalId, Integer userId) {
		System.out.println(" ");
		System.out.println("ADOPCJA ZWIERZÊCIA");
		System.out.println(" ");

		Animal animal = findAnimalById(animalId);

		User user = userService.findUserById(userId);

		boolean isUserAdult = userService.isUserAdult(user);

		if (user.getAge() < 18) {
			System.out.println("Jesteœ niepe³noletni. Poproœ opiekuna o adopcje.");
		}

		boolean canAnimalsLiveTogether = canAnimalsLiveTogether(user, animal);

		if (canAnimalsLiveTogether && isUserAdult) {
			animal.setHasAnimalBeenAdopted(true);

			user.getAdoptedPets().add(animal);

			animalDao.updateById(animal);

			userService.updateById(user);
		}
	}

	private Boolean canAnimalsLiveTogether(User user, Animal animal) {

		boolean canAnimalBeAdopted = true;

		if (user.getAdoptedPets().isEmpty() == false) {
			for (Animal pet : user.getAdoptedPets()) {
				if ((pet.getSpecies() == Species.Kot && animal.getSpecies() == Species.Królik)
						|| (pet.getSpecies() == Species.Królik && animal.getSpecies() == Species.Kot)
						|| (pet.getSpecies() == Species.Kot && animal.getSpecies() == Species.Szczur)
						|| (pet.getSpecies() == Species.Szczur && animal.getSpecies() == Species.Kot)
						|| (pet.getSpecies() == Species.Kot && animal.getSpecies() == Species.Pies)
						|| (pet.getSpecies() == Species.Pies && animal.getSpecies() == Species.Kot)
						|| (pet.getSpecies() == Species.Wilk && animal.getSpecies() == Species.Królik)
						|| (pet.getSpecies() == Species.Królik && animal.getSpecies() == Species.Wilk)) {
					System.out.println("Te zwierzaki siê nie lubi¹, zastanów siê nad innym zwierzêciem...");
					canAnimalBeAdopted = false;
					break;
				}
			}
		}

		return canAnimalBeAdopted;
	}

	private Animal findAnimalById(Integer animalId) {
		List<Animal> animals = selectAll();
		Animal foundAnimal = null;

		for (Animal animal : animals) {
			if (animalId == animal.getId()) {
				foundAnimal = animal;
				break;
			}
		}

		return foundAnimal;
	}

	public List<Animal> selectByFurColor(FurColor furColor) {
		return animalDao.selectByFurColor(furColor);
	}
}
