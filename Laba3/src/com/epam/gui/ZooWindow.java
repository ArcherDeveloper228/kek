package com.epam.gui;

import com.epam.zoo.Employee;
import com.epam.zoo.Viewer;
import com.epam.zoo.Zoo;
import com.epam.zoo.animal.Animal;
import com.epam.zoo.animal.Elephant;
import com.epam.zoo.animal.Flamingo;
import com.epam.zoo.animal.Ostrich;
import com.epam.zoo.animal.Tiger;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * This class make main window
 * @author Nikita.Ustyuchenko
 * @version 1.0
 * */
public class ZooWindow extends Stage {

	private final String TITLE_WINDOW;
	private Zoo zoo;
	private Viewer viewer;
	// объявление графических элементов
	private Scene scene;
	private Label[] labels;
	private ComboBox<String> combo_box;
	private RadioButton[] radio_buttons;
	private Button[] buttons;
	
	// логический блок для создания графических элементов
	{
		
		this.zoo = new Zoo("BSUIR");
		this.zoo.addAll(new Ostrich("Round", "Cirrus"), new Elephant("Round", "Oval", "Big"), 
				new Flamingo("Round", "Big"), new Tiger("Oval", "Muscular", "Black and orange"));
		this.zoo.addEmployee(new Employee("Lutsik"));
		this.viewer = new Viewer("Nikita", this.zoo);
		this.TITLE_WINDOW = new String("Zoo");
		
		this.labels = new Label[] {
				
			new Label("Zoo " + "\"" + this.zoo.getName() + "\""), 
			new Label("Employee"),
			new Label("Animal"),
			new Label("Viewer"),
			new Label("Count employees: " + this.zoo.getEmployees().size()),
			new Label("Count animals: " + this.zoo.getAnimals().size())
				
		};
		
		for (int i = 0; i < 4; i++) {
			
			if (i == 0) {
				
				this.labels[0].setStyle("-fx-font-size: 25px; -fx-font-weight: bold");
				continue;
				
			}
			
			this.labels[i].setStyle("-fx-font-size: 20px");
			
		}
		
		this.combo_box = new ComboBox<String>();
		for (Animal animal : this.zoo.getAnimals()) this.combo_box.getItems().add(animal.getName());
		this.combo_box.setValue(this.zoo.getAnimals().get(0).getName());
	
		this.buttons = new Button[] {
		    	 
			new Button("Feed animal"),
			new Button("Clean cage"),
			new Button("Look animal"),
			new Button("Exit")
			
		};
		for (int i = 0; i < this.buttons.length; i++) this.buttons[i].setPrefWidth(100.0);
		
	}
	
	/**
	 * Make main window
	 * */
	public ZooWindow() {
		
		GridPane pane = new GridPane();
		pane.setPadding(new Insets(10.0));
		pane.setVgap(10.0);
		pane.setHgap(10.0);
		
		// устнавливаем расположение лэйблов в ячейках
		for (int i = 0; i < this.labels.length; i++) 
			GridPane.setHalignment(this.labels[i], HPos.CENTER);
		// устанавливаем расположение кнопок в ячейках
		for (int i = 0; i < this.buttons.length; i++) 
			GridPane.setHalignment(this.buttons[i], HPos.CENTER);
		
		// добавляем графические элементы на GridPane
		pane.add(this.labels[0], 0, 0, 3, 1);
		pane.add(this.labels[1], 0, 1);
		pane.add(this.labels[2], 1, 1);
		pane.add(this.combo_box, 1, 2);
		pane.add(this.buttons[0], 0, 2);
		pane.add(this.buttons[1], 0, 3);
		pane.add(this.labels[4], 0, 4);
		pane.add(this.labels[5], 1, 4);
		pane.add(this.buttons[3], 2, 5);
		pane.add(this.labels[3], 2, 1);
		pane.add(this.buttons[2], 2, 2);
		
		// устанавливаем обработчики событий
		for (int i = 0; i < this.buttons.length; i++) {
			
			switch (i) {
			
			case 0:    this.buttons[i].addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
					   
					       Animal animal = null;
					       
					       switch (this.combo_box.getValue()) {
					       
					       case "Ostrich":    for (Animal new_animal : this.zoo.getAnimals()) 
					    	   				      if (new_animal.getName().equals("Ostrich")) animal = new_animal;
					       					  break;
					       
					       case "Elephant":	  for (Animal new_animal : this.zoo.getAnimals()) 
					    	   			          if (new_animal.getName().equals("Elephant")) animal = new_animal;
	       					  			      break; 
					      
					       case "Flamingo":   for (Animal new_animal : this.zoo.getAnimals()) 
					    	   					  if (new_animal.getName().equals("Flamingo")) animal = new_animal;
	       					  				  break;
	       					  				  
					       case "Tiger":      for (Animal new_animal : this.zoo.getAnimals()) 
					    	   					  if (new_animal.getName().equals("Tiger")) animal = new_animal;
	       					  				  break;
					       
					       }
					       
					       if (animal == null) this.close();
		
					       ZooWindow.showDialogMessage(animal.getName(), this.zoo.getEmployees().get(0).feedAnimal(animal));
				
					   });
					   break;
					   
			case 1:    this.buttons[i].addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
						   
						   Animal animal = null;
				
						   switch (this.combo_box.getValue()) {
					       
					       case "Ostrich":    for (Animal new_animal : this.zoo.getAnimals()) 
					    	   				      if (new_animal.getName().equals("Ostrich")) animal = new_animal;
					       					  break;
					       
					       case "Elephant":	  for (Animal new_animal : this.zoo.getAnimals()) 
					    	   			          if (new_animal.getName().equals("Elephant")) animal = new_animal;
	       					  			      break; 
					      
					       case "Flamingo":   for (Animal new_animal : this.zoo.getAnimals()) 
					    	   					  if (new_animal.getName().equals("Flamingo")) animal = new_animal;
	       					  				  break;
	       					  				  
					       case "Tiger":      for (Animal new_animal : this.zoo.getAnimals()) 
					    	   					  if (new_animal.getName().equals("Tiger")) animal = new_animal;
	       					  				  break;
					       
					       }
				
					       ZooWindow.showDialogMessage(animal.getName(), this.zoo.getEmployees().get(0).cleanCage(animal));
				
					   });
					   break;
			
			case 2:    this.buttons[i].addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
		
						   Animal animal = this.zoo.acceptVisitor();
						   
			       	   	   ZooWindow.showDialogMessage(animal.getName(), animal.toString());
		
			           });
			   		   break;
					   
			case 3:	   this.buttons[i].addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
				
							this.close();
				
				       });
					   break;
			
			}
			
		}
		
		this.scene = new Scene(pane);
		
		setTitle(this.TITLE_WINDOW);
		setResizable(false);
		setScene(this.scene);
		show();
		
	}
	
	/**
	 * Make dialog window 
	 * @param title title window
	 * @param message information about event
	 * */
	public static void showDialogMessage(String title, String message) {
		
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle(title);
		alert.setContentText(message);
		alert.setHeaderText("");
		alert.showAndWait();
		
	}
	
}
			