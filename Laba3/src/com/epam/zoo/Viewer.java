package com.epam.zoo;

import com.epam.zoo.animal.Animal;

/**
 * This class contains information about Viewer
 * @author Nikita.Ustyuchenko
 * @version 1.0
 * */
public class Viewer {

	/** Property - zoo */
	private Zoo zoo;
	
	/** Property - viewer_name */
	private String viewer_name;
	
	/** 
	 * Make new object Viewer
	 * @see Viewer#Viewer(String)
	 * @see Viewer#Viewer(String, Zoo)
	 * */
	public Viewer() {
		
		this.viewer_name = null;
		this.zoo = null;
		
	}
	
	/** 
	 * Make new object Viewer
	 * @param viewer_name name of viewer zoo 
	 * @see Viewer#Viewer()
	 * @see Viewer#Viewer(String, Zoo)
	 * */
	public Viewer(String viewer_name) {
		
		this.viewer_name = viewer_name;
		this.zoo = null;
		
	}
	
	/** 
	 * Make new object Viewer
	 * @param viewer_name name of viewer zoo 
	 * @see Viewer#Viewer()
	 * @see Viewer#Viewer(String)
	 * */
	public Viewer(String viewer_name, Zoo zoo) {
		
		this.viewer_name = viewer_name;
		this.zoo = zoo;
		
	}
	
	/**
	 * Look at the random animal
	 * @param animal object contains information about animal
	 * @return animal value of properties animal
	 * */
	public Animal lookAnimal(Animal animal) {
		
		animal = this.zoo.acceptVisitor();
		
		return animal;
		
	}
	
	/** 
	 * Get value of property viewer_name
	 * @return value of property viewer_name
	 * */
	public String getName() {
		
		return this.viewer_name;
		
	}
	
	/** 
	 * Set value of property viewer_name  
	 * @param viewer_name name of viewer 
	 * */
	public void setName(String viewer_name) {
		
		this.viewer_name = viewer_name;
		
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
	 * @param zoo object contains information about viewer 
	 * */
	public void setZoo(Zoo zoo) {
		
		this.zoo = zoo;
		
	}
	
}
