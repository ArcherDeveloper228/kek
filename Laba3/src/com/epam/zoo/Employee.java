package com.epam.zoo;

import java.util.ArrayList;
import java.util.List;

import com.epam.zoo.animal.Animal;

/** 
 * This class contains information about Employee 
 * @author Nikita.Ustyuchenko
 * @version 1.0
 * */
public class Employee {

	/** Property - employee_name */
	private String employee_name;

	/** Property - animals */
	private List<Animal> animals;

	/** Property - zoo */
	private Zoo zoo;

	/** 
	 * Make new object Employee
	 * @see Employee#Employee(String)
	 * */
	public Employee() {

		this.employee_name = null;
		this.animals = new ArrayList<Animal>();
		this.zoo = null;

	}

	/** 
	 * Make new object Employee
	 * @param employee_name name of Employee
	 * @see Employee#Employee()
	 *  */
	public Employee(String employee_name) {

		this.employee_name = employee_name;
		this.animals = new ArrayList<Animal>();
		this.zoo = null;

	}

	/** 
	 * Feed animal
	 * @param animal kind of animal
	 * @return string
	 *  */
	public String feedAnimal(Animal animal) {

		for (Animal new_animal : this.animals)
			if (new_animal.getName().equals(animal.getName())) return animal.eat();

		return "It is employee doesn't have this animal";

	}

	/** 
	 * Clean cage
	 * @param animal kind of animal
	 * @return string
	 * */
	public String cleanCage(Animal animal) {

		for (Animal new_animal : this.animals)
			if (new_animal.getName().equals(animal.getName())) return new_animal.getName() + " " + "cage is cleaned";

		return "It is employee doesn't have this animal";

	}

	/** 
	 * Set animal employee
	 * @param animal kind of animal
	 * @return boolean value
	 * */
	public boolean addAnimal(Animal animal) {

		if (animal == null || this.animals == null) return false;

		return this.animals.add(animal);

	}

	/** 
	 * Remove animal from array animals
	 * @param animal kind of animal
	 * @return boolean value
	 * */
	public boolean removeAnimal(Animal animal) {

		if (animal == null || this.animals == null) return false;

		return this.animals.remove(animal);

	}

	/** 
	 * Get value of property employee_name
	 * @return value of property employee_name
	 * */
	public String getName() {

		return this.employee_name;

	}

	/** 
	 * Set value of property employee_name
	 * @param employee_name name of employee
	 *  */
	public void setName(String employee_name) {

		this.employee_name = employee_name;

	}

	/** 
	 * Get array animals
	 * @return array animals
	 * */
	public List<Animal> getAnimals() {

		return this.animals;

	}

	/** 
	 * Set value of array animals
	 * @param animals array animals
	 *  */
	public void setAnimals(ArrayList<Animal> animals) {

		this.animals = animals;

	}

	/** 
	 * Get value of property zoo
	 * @return value of property zoo
	 * */
	public Zoo getZoo() {

		return this.zoo;

	}

	/** 
	 * Set value of property zoo
	 * @param zoo information about zoo
	 * */
	public void setZoo(Zoo zoo) {

		this.zoo = zoo;

	}

	@Override
	public boolean equals(Object object) {

		if (this == object) return true;
		if (object == null) return false;

		Employee employee = (Employee)object;

		if (this.employee_name.equals(employee.getName())) return true;

		return false;

	}

}
