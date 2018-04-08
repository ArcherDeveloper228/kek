package com.epam.zoo;

/**
 * This class contains information about Mammal
 * @author Nikita.Ustyuchenko
 * @version 1.0
 * */
public class Mammal extends Animal {

	/** Property - paws */
	private String paws;
	
	/** 
	 * Make new object Mammal
	 * @see Mammal#Mammal(String)
	 * @see Mammal#Mammal(String, String)
	 * @see Mammal#Mammal(String, String, String)
	 *  */
	public Mammal() {
		
		super();
		this.paws = null;
		
	}
	
	/** 
	 * Make new object Mammal
	 * @param mammal_name name of mammal
	 * @see Mammal#Mammal()
	 * @see Mammal#Mammal(String, String)
	 * @see Mammal#Mammal(String, String, String)
	 *  */
	public Mammal(String mammal_name) {
		
		super(mammal_name);
		this.paws = null;
		
	}
	
	/** 
	 * Make new object Mammal 
	 * @param mammal_name name of mammal
	 * @param paws kind of paws mammal
	 * @see Mammal#Mammal()
	 * @see Mammal#Mammal(String)
	 * @see Mammal#Mammal(String, String, String)
	 * */
	public Mammal(String mammal_name, String paws) {
		
		super(mammal_name);
		this.paws = paws;
		
	}
	
	/** 
	 * Make new object Mammal
	 * @param mammal_name name of mammal
	 * @param body kind of body mammal 
	 * @param paws kind of paws mammal
	 * @see Mammal#Mammal()
	 * @see Mammal#Mammal(String)
	 * @see Mammal#Mammal(String, String)
	 *  */
	public Mammal(String mammal_name, String body, String paws) {
		
		super(mammal_name, body);
		this.paws = paws;
		
	}
	
	/** 
	 * Get value of property paws 
	 * @return value of property paws
	 * */
	public String getPaws() {
		
		return this.paws;
		
	}
	
	/** 
	 * Set value of property paws 
	 * @param paws kind of paws mammal
	 * */
	public void setPaws(String paws) {
		
		this.paws = paws;
		
	}
	
	@Override 
	public boolean equals(Object object) {
		
		if (object == null) return false;
		if (this == object) return true;
		
		Mammal mammal = (Mammal)object;
		
		if (this.paws.equals(mammal.getPaws()) && this.getBody().equals(mammal.getBody()) &&
				this.getName().equals(mammal.getName())) return true;
		
		return false;
		
	}
	
}
