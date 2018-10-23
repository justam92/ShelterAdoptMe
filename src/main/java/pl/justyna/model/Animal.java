package pl.justyna.model;

public class Animal {

	private Integer id;

	private String name;

	private Sex sex;

	private Species species;

	private Integer age;

	private Boolean hasAnimalBeenAdopted;

	private FurColor furColor;

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

	public Sex getSex() {
		return sex;
	}

	public void setSex(Sex sex) {
		this.sex = sex;
	}

	public Species getSpecies() {
		return species;
	}

	public void setSpecies(Species species) {
		this.species = species;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Boolean getHasAnimalBeenAdopted() {
		return hasAnimalBeenAdopted;
	}

	public void setHasAnimalBeenAdopted(Boolean hasAnimalBeenAdopted) {
		this.hasAnimalBeenAdopted = hasAnimalBeenAdopted;
	}

	public FurColor getFurColor() {
		return furColor;
	}

	public void setFurColor(FurColor furColor) {
		this.furColor = furColor;
	}

	@Override
	public String toString() {
		return "Animal [id= " + id + ", name= " + name + ", sex= " + sex + ", species= " + species + ", age= " + age
				+ " miesiêcy, hasAnimalBeenAdopted= " + hasAnimalBeenAdopted + ", furColor= " + furColor + "]";
	}

}
