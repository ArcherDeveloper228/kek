package com.epam.zoo;

/**
 * This class contains information about Bird
 * @author Nikita.Ustyuchenko
 * @version 1.0
 * */
public class Bird extends Animal {

	/** Property - wings */
	private String wings;

	/** 
	 * Make new object Bird
	 * @see Bird#Bird(String, String)
	 * @see Bird#Bird(String, String, String)
	 * @see Bird#Bird(String)
	 *  */
	public Bird() {

		super();
		this.wings = null;

	}

	/**
	 * Make new object Bird
	 * @param bird_name name of bird
	 * @see Bird#Bird()
	 * @see Bird#Bird(String, String)
	 * @see Bird#Bird(String, String, String)
	 * */
	public Bird(String bird_name) {

		super(bird_name);
		this.wings = null;

	}

	/** 
	 * Make new object Bird
	 * @param bird_name name of bird
	 * @param wings kind of wings bird
	 * @see Bird#Bird()
	 * @see Bird#Bird(String)
	 * @see Bird#Bird(String, String, String)
	 * */
	public Bird(String bird_name, String wings) {

		super(bird_name);
		this.wings = wings;

	}

	/** 
	 * Make new object Bird
	 * @param bird_name name of bird
	 * @param body kind of body bird
	 * @param wings kind of wings bird
	 * @see Bird#Bird()
	 * @see Bird#Bird(String)
	 * @see Bird#Bird(String, String)
	 * */
	public Bird(String bird_name, String body, String wings) {

		super(bird_name, body);
		this.wings = wings;

	}

	/**
	 * Get value of property wings
	 * @return value of property wings
	 * */
	public String getKindOfWings() {

		return this.wings;

	}

	/** 
	 * Set value of property wings
	 * @param wings kind of wings bird
	 * */
	public void setKindOfWings(String wings) {

		this.wings = wings;

	}

	@Override
	public boolean equals(Object object) {

		if (object != null) return false;
		if (object == this) return true;

		Bird bird = (Bird)object;

		if (this.wings.equals(bird.getKindOfWings()) && this.getBody().equals(bird.getBody())
				&& this.getName().equals(bird.getName())) return true;

		return false;

	}

}
