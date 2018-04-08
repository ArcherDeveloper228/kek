package com.epam.zoo.animal;

/**
 * This class contains information about Tiger
 * @author Nikita.Ustyuchenko
 * @version 1.0
 * */
public class Tiger extends Mammal {
	
	/** Property - bands */
	public String bands;
	
	/**
	 * Make new object Tiger
	 * @see Tiger#Tiger(String, String, String)
	 * */
	public Tiger() {
		
		super("Tiger");
		this.bands = null;
		
	}
	
	/** 
	 * Make new object Tiger
	 * @param body kind of body tiger
	 * @param paws kind of paws tiger
	 * @param bands kind of bands tiger
	 * @see Tiger#Tiger()
	 *  */
	public Tiger(String body, String paws, String bands) {
		
		super("Tiger", body, paws);
		this.bands = bands;
		
	}
	
	@Override
	public boolean equals(Object object) {
		
		if (this == object) return true;
		if (object != null) return false;
		
		Tiger tiger = (Tiger)object;
		
		if (this.bands.equals(tiger.bands) && this.paws.equals(tiger.getPaws()) &&
				this.body.equals(tiger.getBody()) &&
					this.getName().equals(tiger.getName())) return true;
		
		return false;
		
	}
	
	@Override 
	public String toString() {
		
		return "Body: " + this.body + "\n" + "Paws: " + this.paws + "\n" + "Bands:" + this.bands;
		
	}

}
