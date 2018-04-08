package com.epam.zoo.animal;

/** 
 * This class contains information about Elephant 
 * @author Nikita.Ustyuchenko
 * @version 1.0
 * */ 
public class Elephant extends Mammal {

	/** Property - trunk */
	private String trunk;

	/** 
	 * Make new object Elephant
	 * @see Elephant#Elephant(String, String, String)
	 *  */
	public Elephant() {

		super("Elephant");
		this.trunk = null;

	}

	/** 
	 * Make new object Elephant
	 * @param body kind of body elephant
	 * @param paws kind of paws elephant
	 * @param trunk kind of trunk elephant
	 * @see Elephant#Elephant()
	 * */
	public Elephant(String body, String paws, String trunk) {

		super("Elephant", body, paws);
		this.trunk = trunk;

	}

	/** 
	 * Get value of property trunk
	 * @return value of property trunk
	 *  */
	public String getTrunk() {

		return this.trunk;

	}

	/** 
	 * Set value of property trunk
	 * @param trunk kind of trunk elephant
	 *  */
	public void setTrunk(String trunk) {

		this.trunk = trunk;

	}

	@Override
	public boolean equals(Object object) {

		if (object == null) return false;
		if (this == object) return true;

		Elephant elephant = (Elephant)object;

		if (this.trunk.equals(elephant.getTrunk()) && this.paws.equals(elephant.getPaws()) &&
				this.body.equals(elephant.getBody()) &&
					this.getName().equals(elephant.getName())) return true;

		return false;

	}
	
	@Override 
	public String toString() {
		
		return "Body: " + this.body + "\n" + "Paws: " + this.paws + "\n" + "Trunk:" + this.trunk;
		
	}

}
