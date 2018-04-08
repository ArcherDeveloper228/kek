package com.epam.zoo.animal;

/**
 * The class contains information about Ostrich
 * @author Nikita.Ustyuchenko
 * @version 1.0
 * */
public class Ostrich extends Bird {

	/**
	 * Make new object Ostrich
	 * @see Ostrich#Ostrich(String, String, String)
	 * */
	public Ostrich() {

		super("Ostrich");

	}

	/**
	 * Make new object Ostrich
	 * @see Ostrich#Ostrich()
	 * @param body kind of body ostrich
	 * @param wings kind of wings ostrich
	 * */
	public Ostrich(String body, String wings) {

		super("Ostrich", body, wings);

	}

	@Override
	public boolean equals(Object object) {

		if (object == null) return false;
		if (this == object) return true;

		Ostrich ostrich = (Ostrich)object;

		if (this.getName().equals(ostrich.getName()) && this.body.equals(ostrich.getBody())
				&& this.wings.equals(ostrich.getKindOfWings())) return true;

		return false;

	}
	
	@Override 
	public String toString() {
		
		return "Body: " + this.body + "\n" + "Wings: " + this.wings;
		
	}

}
