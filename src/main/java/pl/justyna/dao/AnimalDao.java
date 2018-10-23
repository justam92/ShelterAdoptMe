package pl.justyna.dao;

import java.util.List;

import pl.justyna.model.Animal;
import pl.justyna.model.FurColor;

public interface AnimalDao {
	
	void register(Animal animal);
	
	Animal selectById(Integer id);
	
	List<Animal> selectByFurColor(FurColor furColor);
	
	List<Animal> selectAll();
	
	void updateById(Animal animal);

}
