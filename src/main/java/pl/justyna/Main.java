package pl.justyna;

import java.util.List;

import pl.justyna.controller.AnimalController;
import pl.justyna.controller.UserController;
import pl.justyna.model.Animal;
import pl.justyna.model.FurColor;
import pl.justyna.model.Sex;
import pl.justyna.model.Species;
import pl.justyna.model.User;

public class Main {

	public static void main(String[] args) {

		System.out.println("U¯YTKOWNICY");

		UserController userController = new UserController();

		List<User> users = userController.getAll();

		for (User user : users) {
			System.out.println(user);
		}

		System.out.println(" ");
		System.out.println("Wyœwietla po ID");
		User user = userController.getById(3);
		System.out.println(user);

		User newUser = new User();
		System.out.println(" ");
		System.out.println("Rejestracja u¿ytwkonika");

		newUser.setName("Anna");
		newUser.setSurname("Mucha");
		newUser.setSex(Sex.K);
		newUser.setAge(20);

		userController.register(newUser);

		for (User user2 : userController.getAll()) {
			System.out.println(user2);
		}

		userController.updateUserAccount(newUser);

		System.out.println(" ");
		System.out.println("Usuwanie u¿ytkownika po ID");
		userController.deleteById(1);

		// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

		System.out.println(" ");
		System.out.println(" ");
		System.out.println("ZWIERZÊTA");

		AnimalController animalController = new AnimalController();

		List<Animal> animals = animalController.getAll();

		for (Animal animal : animals) {
			System.out.println(animal);
		}

		System.out.println(" ");
		System.out.println("Wyœwietla po ID");
		Animal animal = animalController.getById(7);
		System.out.println(animal);

		Animal newAnimal = new Animal();
		System.out.println(" ");
		System.out.println("Rejestracja zwierzaka do adopcji");

		newAnimal.setName("Pyzia");
		newAnimal.setSex(Sex.K);
		newAnimal.setSpecies(Species.Królik);
		newAnimal.setAge(6);
		newAnimal.setFurColor(FurColor.Czarny);

		animalController.register(newAnimal);

		for (Animal animal2 : animalController.getAll()) {
			System.out.println(animal2);
		}

		System.out.println(" ");
		System.out.println("Wyœwietlanie zwierz¹t wybranych po kolorze sierœci");
		List<Animal> animalsSelectedByFurColor = animalController.getByFurColor(FurColor.Szary);
		for (Animal animalSelectedByFurColor : animalsSelectedByFurColor) {
			System.out.println(animalSelectedByFurColor);
		}

		animalController.adopt(1, 2);

		for (User userAdoption : users) {
			System.out.println(userAdoption);
		}
		
		System.out.println(" ");
		System.out.println("Usuwanie zwierzecia po ID");
		animalController.deleteById(5);
	}

}
