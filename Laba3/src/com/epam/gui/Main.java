package com.epam.gui;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
	
	private Stage stage;
	
	@Override 
	public void start(Stage primaryStage) {
		
		primaryStage = new ZooWindow();
		this.stage = primaryStage;
		
	}
	
	public static void main(String[] args) {

		launch(args);

	}

}
