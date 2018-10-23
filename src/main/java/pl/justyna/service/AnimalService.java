package pl.justyna.service;

import java.util.List;

import pl.justyna.model.Animal;
import pl.justyna.model.FurColor;

public interface AnimalService {
	
	void register(Animal animal);
	
	Animal selectById(Integer id);
	
	List<Animal> selectByFurColor(FurColor furColor);
	
	List<Animal> selectAll();
	
	void adopt(Integer animalId, Integer userId);
	
	void deleteById(Integer id);

}
