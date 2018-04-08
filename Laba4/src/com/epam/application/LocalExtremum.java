package com.epam.application;

import java.util.ArrayList;
import java.util.List;

/**
 * This class calculate extremum 
 * @author Nikita.Ustyushenko 
 * @version 1.0
 * */
public class LocalExtremum extends Thread {

	/** Property - main_thread */ 
	private MainThread main_thread;
	
	/** Property - state_thread */
	private int state_thread;
	
	/** Property - number_comand */
	private int number_comand;
	
	/**
	 * Make new object LocalExtremum
	 * */
	public LocalExtremum() {
		
		this.main_thread = null;
		this.state_thread = 0;
		this.number_comand = 0;
		
	}
	
	/**
	 * Make new object LocalExtremum
	 * @param main_thread 
	 * */
	public LocalExtremum(MainThread main_thread) {
		
		this.main_thread = main_thread;
		this.state_thread = 0;
		this.number_comand = 0;
		
	}
	
	@Override
	public void run() {
		
		while (this.state_thread == 0) {
			
			synchronized (this.main_thread.getNumbers()) {
			
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			
				if (this.number_comand == 1) {
					
						List<Integer> array = this.findExtremum(this.main_thread.getNumbers(), 1);
						this.main_thread.setMaxExtremum(array);
					
						this.number_comand = 0;
			
				}
			
				if (this.number_comand == 2) {
				
					List<Integer> new_array = this.findExtremum(this.main_thread.getNumbers(), 0);
					this.main_thread.setMinExtremum(new_array);
				
					this.number_comand = 0;
				
				}
			
			}
		}
		
	}
	
	/** This method find extremum */
	public List<Integer> findExtremum(List<Integer> numbers, int flag) {
		
		List<Integer> array = new ArrayList<>();
		
		if (flag == 0) {
			
			for (int i = 0; i < numbers.size(); i++) {
				
				if (i == 0) {
					
					if (numbers.get(i) <= numbers.get(i + 1)) array.add(numbers.get(i));
					continue;
					
				}
				
				if (i == numbers.size() - 1) {
					
					if (numbers.get(i) <= numbers.get(i - 1)) 
						array.add(numbers.get(i));
					continue;
					
				}
				
				if (numbers.get(i) <= numbers.get(i + 1) && numbers.get(i) <= numbers.get(i - 1))
					array.add(numbers.get(i));
				
			}
			
		} else {
			
			for (int i = 0; i < numbers.size(); i++) {
				
				if (i == 0) {
					
					if (numbers.get(i) >= numbers.get(i + 1)) array.add(numbers.get(i));
					continue;
					
				}
				
				if (i == numbers.size() - 1) {
					
					if (numbers.get(i) >= numbers.get(i - 1)) 
						array.add(numbers.get(i));
					continue;
					
				}
				
				if (numbers.get(i) >= numbers.get(i + 1) && numbers.get(i) >= numbers.get(i - 1))
					array.add(numbers.get(i));
			}
		
		}
		
		return array;
		
	}
	
	/**
	 * This method set value of the state thread
	 * @param state_thread
	 * */
	public void setStateThread(int state_thread) {
		
		this.state_thread = state_thread;
		
	}
	
	/**
	 * This method return value of the state thread
	 * @return value of the state thread
	 * */
	public int getStateThread() {
		
		return this.state_thread;
		
	}
	
	/** 
	 * This method set value of the number comand
	 * @param number_comand value of the property number_comand
	 * */
	public void setNumberComand(int number_comand) {
		
		this.number_comand = number_comand;
		
	}
	
	/**
	 * This method return value of the number comand
	 * @return value of the property number comand
	 * */
	public int getNumberComand() {
		
		return this.number_comand;
		
	}
	
	/**
	 * This method set value of the property main_thread
	 * @param main_thread value of the property main_thread
	 * */
	public void setMainThread(MainThread main_thread) {
		
		this.main_thread = main_thread;
		
	}
	
	/**
	 * This method return value of the property main_thread
	 * @return main_thread value of the property main_thread
	 * */
	public MainThread getMainThread() {
		
		return this.main_thread;
		
	}
	
}
