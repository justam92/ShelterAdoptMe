package pl.justyna.controller;

import java.util.List;

import pl.justyna.model.Animal;
import pl.justyna.model.FurColor;
import pl.justyna.service.AnimalService;
import pl.justyna.serviceImpl.AnimalServiceImpl;

public class AnimalController {

	private AnimalService service = new AnimalServiceImpl();

	public void register(Animal newAnimal) {
		service.register(newAnimal);
	}

	public Animal getById(Integer id) {
		return service.selectById(id);
	}

	public List<Animal> getByFurColor(FurColor furColor) {
		return service.selectByFurColor(furColor);
	}

	public List<Animal> getAll() {
		List<Animal> animals = service.selectAll();
		return animals;
	}

	public void adopt(Integer animalId, Integer userId) {
		service.adopt(animalId, userId);
	}
	
	public void deleteById(Integer id) {
		service.deleteById(id);
	}
}
