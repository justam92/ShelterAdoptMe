package pl.justyna.daoMock;

import java.util.ArrayList;
import java.util.List;

import pl.justyna.dao.AnimalDao;
import pl.justyna.model.Animal;
import pl.justyna.model.FurColor;
import pl.justyna.model.Sex;
import pl.justyna.model.Species;

public class AnimalDaoMock implements AnimalDao {

	private List<Animal> animals = new ArrayList<Animal>();

	public AnimalDaoMock() {
		Animal animal1 = new Animal();
		animal1.setId(1);
		animal1.setName("Reksio");
		animal1.setSex(Sex.M);
		animal1.setSpecies(Species.Pies);
		animal1.setAge(62);
		animal1.setHasAnimalBeenAdopted(new Boolean("false"));
		animal1.setFurColor(FurColor.Czarny);

		animals.add(animal1);

		Animal animal2 = new Animal();
		animal2.setId(2);
		animal2.setName("£atka");
		animal2.setSex(Sex.K);
		animal2.setSpecies(Species.Kot);
		animal2.setAge(41);
		animal2.setHasAnimalBeenAdopted(new Boolean("false"));
		animal2.setFurColor(FurColor.Mieszany);

		animals.add(animal2);

		Animal animal3 = new Animal();
		animal3.setId(3);
		animal3.setName("Belzebub");
		animal3.setSex(Sex.M);
		animal3.setSpecies(Species.Królik);
		animal3.setAge(14);
		animal3.setHasAnimalBeenAdopted(new Boolean("false"));
		animal3.setFurColor(FurColor.Bia³y);

		animals.add(animal3);

		Animal animal4 = new Animal();
		animal4.setId(4);
		animal4.setName("Mysia");
		animal4.setSex(Sex.K);
		animal4.setSpecies(Species.Szczur);
		animal4.setAge(6);
		animal4.setHasAnimalBeenAdopted(new Boolean("false"));
		animal4.setFurColor(FurColor.Szary);

		animals.add(animal4);

		Animal animal5 = new Animal();
		animal5.setId(5);
		animal5.setName("Pirat");
		animal5.setSex(Sex.M);
		animal5.setSpecies(Species.Królik);
		animal5.setAge(23);
		animal5.setHasAnimalBeenAdopted(new Boolean("false"));
		animal5.setFurColor(FurColor.Mieszany);

		animals.add(animal5);

		Animal animal6 = new Animal();
		animal6.setId(6);
		animal6.setName("Cezar");
		animal6.setSex(Sex.M);
		animal6.setSpecies(Species.Wilk);
		animal6.setAge(78);
		animal6.setHasAnimalBeenAdopted(new Boolean("false"));
		animal6.setFurColor(FurColor.Br¹zowy);

		animals.add(animal6);

		Animal animal7 = new Animal();
		animal7.setId(7);
		animal7.setName("Mleczna");
		animal7.setSex(Sex.K);
		animal7.setSpecies(Species.Pies);
		animal7.setAge(39);
		animal7.setHasAnimalBeenAdopted(new Boolean("false"));
		animal7.setFurColor(FurColor.Bia³y);

		animals.add(animal7);

		Animal animal8 = new Animal();
		animal8.setId(8);
		animal8.setName("Zosia");
		animal8.setSex(Sex.K);
		animal8.setSpecies(Species.Kot);
		animal8.setAge(20);
		animal8.setHasAnimalBeenAdopted(new Boolean("false"));
		animal8.setFurColor(FurColor.Rudy);

		animals.add(animal8);

		Animal animal9 = new Animal();
		animal9.setId(9);
		animal9.setName("Kie³");
		animal9.setSex(Sex.M);
		animal9.setSpecies(Species.Wilk);
		animal9.setAge(41);
		animal9.setHasAnimalBeenAdopted(new Boolean("false"));
		animal9.setFurColor(FurColor.Szary);

		animals.add(animal9);
	}

	public void register(Animal animal) {
		Integer lastId = 0;

		for (Animal animalWithLastId : animals) {
			lastId = Math.max(lastId, animalWithLastId.getId());
		}

		animal.setId(lastId + 1);

		animals.add(animal);
	}

	public Animal selectById(Integer id) {
		for (Animal animal : animals) {
			if (animal.getId().equals(id)) {
				return animal;
			}
		}

		throw new RuntimeException("Brak zwierzaka o id: " + id);
	}

	public List<Animal> selectAll() {
		return animals;
	}

	public void updateById(Animal animal) {
		for (Animal animalToUpdate : animals) {
			if (animalToUpdate.getId().equals(animal.getId())) {
				animalToUpdate.setName(animal.getName());
				animalToUpdate.setSex(animal.getSex());
				animalToUpdate.setSpecies(animal.getSpecies());
				animalToUpdate.setAge(animal.getAge());
				animalToUpdate.setHasAnimalBeenAdopted(animal.getHasAnimalBeenAdopted());
				animalToUpdate.setFurColor(animal.getFurColor());
				break;
			}
		}
	}

	public List<Animal> selectByFurColor(FurColor furColor) {
		List<Animal> foundAnimals = new ArrayList<Animal>();
		for (Animal animal : animals) {
			if (animal.getFurColor().equals(furColor)) {
				foundAnimals.add(animal);
			}
		}
		return foundAnimals;
	}

}
