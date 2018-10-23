package pl.justyna.model;

import java.util.ArrayList;
import java.util.List;

public class User {
	
	private Integer id;
	
	private String name;
	
	private String surname;
	
	private Sex sex;
	
	private Integer age;
	
	private List<Animal> adoptedPets = new ArrayList<Animal>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Sex getSex() {
		return sex;
	}

	public void setSex(Sex sex) {
		this.sex = sex;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public List<Animal> getAdoptedPets() {
		return adoptedPets;
	}

	public void setAdoptedPets(List<Animal> adoptedPets) {
		this.adoptedPets = adoptedPets;
	}

	@Override
	public String toString() {
		return "User [id = " + id + ", name = " + name + ", surname = " + surname + ", sex = " + sex + ", age = " + age
				+ ", adoptedPets = " + adoptedPets + "]";
	}

	


	

}
