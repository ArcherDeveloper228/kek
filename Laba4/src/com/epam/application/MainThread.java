package com.epam.application;

import java.util.ArrayList;
import java.util.List;

/** 
 * This class contains collections numbers, min, max
 * @author Nikita.Ustyushenko
 * @version 1.0
 *  */
public class MainThread extends Thread {
	
	/** Property - local */
	private LocalExtremum local;
	
	/** Property - collection numbers */
	private List<Integer> numbers;
	
	/** Property - collection min */
	private List<Integer> min;
	
	/** Property - collection max */
	private List<Integer> max;
	
	/** Property - state_thread */
	private int state_thread;
	
	/** Property - number_comand */
	private int number_comand;
	
	/** 
	 * Make new object MainThread 
	 * */
	public MainThread() {
		
		this.local = new LocalExtremum();
		this.local.setMainThread(this);
		this.numbers = new ArrayList<>();
		this.min = new ArrayList<>();
		this.max = new ArrayList<>();
		this.state_thread = 0;
		this.number_comand = 0;
		
	}
	
	/** 
	 * Make new object MainThread
	 * @param numbers value of the collection numbers 
	 * */
	public MainThread(List<Integer> numbers) {
		
		this.local = new LocalExtremum();
		this.local.setMainThread(this);
		this.numbers = numbers;
		this.min = new ArrayList<>();
		this.max = new ArrayList<>();
		this.state_thread = 0;
		this.number_comand = 0;
		
	}
	
	@Override 
	public void run() {
		
		this.local.start();
		
		while (this.state_thread == 0) {

			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			if (this.number_comand == 1) {
				
				this.local.setNumberComand(1);
				
				this.number_comand = 0;
				
			}
			
			if (this.number_comand == 2) {
				
				this.local.setNumberComand(2);
				
				this.number_comand = 0;
				
			}
			
		}
		
		this.local.setStateThread(1);
		
	}
	
	/**
	 * This method return collection numbers
	 * @return collection numbers
	 * */
	public List<Integer> getNumbers() {
		
		return this.numbers;
		
	}
	
	/**
	 * This method set value of the collection numbers
	 * @param numbers collection 
	 * */
	public void setNumbers(List<Integer> numbers) {
		
		this.numbers = numbers;
		
	}
	
	/** 
	 * This method return collection min 
	 * @return collection min
	 * */
	public List<Integer> getMinExtremum() {
		
		return this.min;
		
	}
	
	/** 
	 * This method set value of the collection min 
	 * @param min collection
	 * */
	public void setMinExtremum(List<Integer> min) {
		
		this.min = min;
		
	}
	
	/** 
	 * This method return value of the collection max 
	 * @return collection max
	 * */
	public List<Integer> getMaxExtremum() {
		
		return this.max;
		
	}
	
	/** 
	 * This method set value of the collection max
	 * @param max collection
	 * */
	public void setMaxExtremum(List<Integer> max) {
		
		this.max = max;
		
	}
	
	/** 
	 * This method set value of the state thread
	 * @param value of the state thread  
	 * */
	public void setStateThread(int state_thread) {
		
		this.state_thread = state_thread;
		
	}
	
	/** 
	 * This method get value of the state thread 
	 * @return value of the state thread
	 * */
	public int getStateThread() {
		
		return this.state_thread;
		
	}
	
	/**
	 * This method set value of the number comand
	 * @param number_comand value of the property number comand 
	 * */
	public void setNumberComand(int number_comand) {
		
		this.number_comand = number_comand;
		
	}
	
	/** 
	 * This method return value of the number comand 
	 * @return value of the number comand
	 * */
	public int getNumberComand() {
		
		return this.number_comand;
		
	}

}
