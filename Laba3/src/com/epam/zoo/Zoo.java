package com.epam.zoo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.epam.zoo.animal.Animal;

/**
 * This class contains information about Zoo
 * @author Nikita.Ustyuchenko
 * @version 1.0
 *  */
public class Zoo {

	private Random random;
	
	/** Property - zoo_name */
	private String zoo_name;

	/** Collection - animals */
	private List<Animal> animals;

	/** Collection - employees */
	private List<Employee> employees;

	/**
	 * Make new object Zoo
	 * @see Zoo#Zoo(String)
	 * */
	public Zoo() {

		this.zoo_name = null;
		this.animals = new ArrayList<Animal>();
		this.employees = new ArrayList<Employee>();
		this.random = new Random();

	}

	/**
	 * Make new object Zoo
	 * @see Zoo#Zoo()
	 * */
	public Zoo(String zoo_name) {

		this.zoo_name = zoo_name;
		this.animals = new ArrayList<Animal>();
		this.employees = new ArrayList<Employee>();
		this.random = new Random();
	}

	/**
	 * Add object animal to the collection animals
	 * @param animal object contains information about animal
	 * @return boolean value
	 * */
	public boolean addAnimal(Animal animal) {

		if (this.animals == null || animal == null) return false;

		animal.setZoo(this);

		return this.animals.add(animal);

	}
	
	/** 
	 * Add all animals into zoo
	 * @param array of animals
	 * @return boolean value
	 * */
	public boolean addAll(Animal... animals) {
		
		for (int i = 0; i < animals.length; i++) if (animals[i] == null) return false;

		for (int i = 0; i < animals.length; i++) this.animals.add(animals[i]);
		
		return true;			
		
	}

	/**
	 * Remove object animal from collection animals
	 * @param animal object contains information about animal
	 * @return boolean value
	 * */
	public boolean removeAnimal(Animal animal) {

		if (this.animals == null || animal == null) return false;

		return this.animals.remove(animal);

	}

	/**
	 * Add object employee to the collection employees
	 * @param employee object contains information about employee
	 * @return boolean value
	 * */
	public boolean addEmployee(Employee employee) {

		if (this.employees == null || employee == null) return false;

		for (Animal animal : this.animals) employee.addAnimal(animal);
		employee.setZoo(this);

		return this.employees.add(employee);

	}
	
	/** 
	 * Add all employees into zoo
	 * @param array of employees
	 * @return boolean value
	 * */
	public boolean addAll(Employee... employees) {
		
		for (int i = 0; i < employees.length; i++) if (employees[i] == null) return false;
		
		for (int i = 0; i < employees.length; i++) this.employees.add(employees[i]);
		
		return true;
		
	}

	/**
	 * Remove object employee from collection employees
	 * @param employee object contains information about employee
	 * @return boolean value
	 * */
	public boolean removeEmployee(Employee employee) {

		if (this.employees == null || employee == null) return false;

		return this.employees.remove(employee);

	}
	
	/**
	 * This method return random animal from zoo
	 * @return object of type Animal 
	 * */
	private Animal randomAnimal() {
		
		return this.animals.get(random.nextInt(this.animals.size()));
		
	}
	
	/** 
	 * This method accept viewer in zoo
	 * @return object of type Animal
	 * */
	public Animal acceptVisitor() {
		
		return this.randomAnimal();
		
	}

	/**
	 * Get value of property zoo_name
	 * @return value of property zoo_name
	 * */
	public String getName() {

		return this.zoo_name;

	}

	/**
	 * Set value of property zoo_name
	 * @param zoo_name name of zoo
	 * */
	public void setName(String zoo_name) {

		this.zoo_name = zoo_name;

	}

	/**
	 * Get value collection animals
	 * @return value of property animals
	 * */
	public List<Animal> getAnimals() {

		return this.animals;

	}

	/**
	 * Set value collection animals
	 * @param animals array animals
	 * */
	public void setAnimals(ArrayList<Animal> animals) {

		this.animals = animals;

	}

	/**
	 * Get value collection employees
	 * @return value of property employees
	 * */
	public List<Employee> getEmployees() {

		return this.employees;

	}

	/**
	 * Set value collection employees
	 * @param employees array employees
	 * */
	public void setEmployees(ArrayList<Employee> employees) {

		this.employees = employees;

	}

}
