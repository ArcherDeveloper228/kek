package com.epam.zoo.animal;

import com.epam.zoo.Zoo;

/**
 * This class contains information about animal
 * @author Nikita.Ustyuchenko
 * @version 1.0
 * */
public abstract class Animal {
	
	/** Property - body*/
	protected String body;
	
	/** Property - animal_name*/
	private String animal_name;
	
	/** Property - zoo */
	private Zoo zoo;
	
	/** 
	 * Make new object Animal
	 * @see Animal#Animal(String)
	 * @see Animal#Animal(String, String)
	 * */
	public Animal() {
		
		this.body = null;
		this.animal_name = null;
		this.zoo = null;
		
	}
	
	/** 
	 * Make new object Animal
	 * @param animal_name name of animal  
	 * @see Animal#Animal()
	 * @see Animal#Animal(String, String)
	 * */
	public Animal(String animal_name) {
		
		this.animal_name = animal_name;
		this.body = null;
		this.zoo = null;
		
	}
	
	/** 
	 * Make new object Animal
	 * @param animal_name name of animal
	 * @param body kind of body animal
	 * @see Animal#Animal()
	 * @see Animal#Animal(String)
	 *  */
	public Animal(String animal_name, String body) {
		
		this.animal_name = animal_name;
		this.body = body;
		this.zoo = null;
		
	}
	
	/** 
	 * Eat animal 
	 * @return string
	 * */
	public String eat() {
		
		return  "The " + this.animal_name + " ate";
		
	}
	
	/** 
	 * Get value of property animal_name
	 * @return value of property animal_name
	 * */
	public String getName() {
		
		return this.animal_name;
		
	}
	
	/** 
	 * Set value of property animal_name 
	 * @param animal_name name of animal
	 * */
	public void setName(String animal_name) {
		
		this.animal_name = animal_name;
		
	}
	
	/** 
	 * Get value of property body 
	 * @return value of property body
	 * */
	public String getBody() {
		
		return this.body;
		
	}
	
	/** 
	 * Set value of property body
	 * @param body kind of body animal
	 *  */
	public void setBody(String body) {
		
		this.body = body;
		
	}
	
	/** 
	 * Get value of property zoo
	 * @return value of property zoo
	 *  */
	public Zoo getZoo() {
		
		return this.zoo;
		
	}
	
	/** 
	 * Set value of property zoo 
	 * @param zoo object Zoo
	 * */
	public void setZoo(Zoo zoo) {
		
		this.zoo = zoo;
		
	}
	
	@Override 
	public boolean equals(Object object) {
		
		if (object != null) return false;
		if (this == object) return true;
		
		Animal animal = (Animal)object;
		
		if (this.animal_name.equals(animal.getName()) && this.body.equals(animal.getBody())) 
		   	return true;
		
		return false;
		
	}
	
}
