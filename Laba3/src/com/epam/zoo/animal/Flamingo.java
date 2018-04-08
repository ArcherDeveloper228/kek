package com.epam.zoo.animal;

/**
 * This class contains information about animal flamingo
 * @author Nikita.Ustyuchenko
 * @version 1.0
 * */
public class Flamingo extends Bird {
	
	/**
	 * Make new object Flamingo
	 * @see Flamingo#Flamingo(String, String)
	 * */
	public Flamingo() {
		
		super("Flamingo");
		
	}
	
	/**
	 * Make new object Flamingo 
	 * @param body kind of body animal
	 * @param wings kind of wings animal
	 * @see Flamingo#Flamingo()
	 * */
	public Flamingo(String body, String wings) {
		
		super("Flamingo", body, wings);
		
	}
	
	/**
	 * This method change state flamingo
	 * @return string 
	 * */
	public String fly() {
		
		return "Flamingo is flying";
		
	}
	
	@Override
	public boolean equals(Object object) {

		if (object == null) return false;
		if (this == object) return true;

		Flamingo flamingo = (Flamingo)object;

		if (this.getName().equals(flamingo.getName()) && this.body.equals(flamingo.getBody())
				&& this.wings.equals(flamingo.getKindOfWings())) return true;

		return false;
	
	}
	
	@Override 
	public String toString() {
		
		return "Body: " + this.body + "\n" + "Wings: " + this.wings;
		
	}

}
