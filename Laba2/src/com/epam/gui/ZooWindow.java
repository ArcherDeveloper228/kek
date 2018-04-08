package com.epam.gui;

import com.epam.zoo.Animal;
import com.epam.zoo.Elephant;
import com.epam.zoo.Employee;
import com.epam.zoo.Ostrich;
import com.epam.zoo.Zoo;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
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
	// ���������� ����������� ���������
	private Scene scene;
	private Label[] labels;
	private RadioButton[] radio_buttons;
	private Button[] buttons;
	
	// ���������� ���� ��� �������� ����������� ���������
	{
		
		this.zoo = new Zoo("BSUIR");
		this.zoo.addAll(new Ostrich("Round", "Cirrus"), new Elephant("Round", "Oval", "Big"));
		this.zoo.addEmployee(new Employee("Lutsik"));
		this.TITLE_WINDOW = new String("Zoo");
		
		this.labels = new Label[] {
				
			new Label("Zoo " + "\"" + this.zoo.getName() + "\""), 
			new Label("Employee"),
			new Label("Animal"),
			new Label("Count employees: " + this.zoo.getEmployees().size()),
			new Label("Count animals: " + this.zoo.getAnimals().size())
				
		};
		
		for (int i = 0; i < 3; i++) {
			
			if (i == 0) {
				
				this.labels[0].setStyle("-fx-font-size: 25px; -fx-font-weight: bold");
				continue;
				
			}
			
			this.labels[i].setStyle("-fx-font-size: 20px");
			
		}
		
		this.radio_buttons = new RadioButton[] {
				
			new RadioButton("Ostrich"),
			new RadioButton("Elephant")
				
		};
		this.buttons = new Button[] {
			 
			new Button("Feed animal"),
			new Button("Clean cage"),
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
		
		ToggleGroup group = new ToggleGroup();
		
		for (int i = 0; i < this.radio_buttons.length; i++) 
			this.radio_buttons[i].setToggleGroup(group);
		this.radio_buttons[0].setSelected(true);
		
		// ������������ ������������ ������� � �������
		for (int i = 0; i < this.labels.length; i++) 
			GridPane.setHalignment(this.labels[i], HPos.CENTER);
		// ������������� ������������ ������ � �������
		for (int i = 0; i < this.buttons.length; i++) 
			GridPane.setHalignment(this.buttons[i], HPos.CENTER);
		
		// ��������� ����������� �������� �� GridPane
		pane.add(this.labels[0], 0, 0, 2, 1);
		pane.add(this.labels[1], 0, 1);
		pane.add(this.labels[2], 1, 1);
		pane.add(this.radio_buttons[0], 1, 2);
		pane.add(this.buttons[0], 0, 2);
		pane.add(this.radio_buttons[1], 1, 3);
		pane.add(this.buttons[1], 0, 3);
		pane.add(this.labels[3], 0, 4);
		pane.add(this.labels[4], 1, 4);
		pane.add(this.buttons[2], 1, 5);
		
		// ������������� ����������� �������
		for (int i = 0; i < this.buttons.length; i++) {
			
			switch (i) {
			
			case 0:    this.buttons[i].addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
					   
					       Animal animal;
				
					       if (this.radio_buttons[0].isSelected()) animal = this.zoo.getAnimals().get(0);
					       else animal = this.zoo.getAnimals().get(1);
		
					       ZooWindow.showDialogMessage(animal.getName(), this.zoo.getEmployees().get(0).feedAnimal(animal));
				
					   });
					   break;
					   
			case 1:    this.buttons[i].addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
						   
						   Animal animal;
				
						   if (this.radio_buttons[0].isSelected()) animal = this.zoo.getAnimals().get(0);
						   else animal = this.zoo.getAnimals().get(1);
				
					       ZooWindow.showDialogMessage(animal.getName(), this.zoo.getEmployees().get(0).cleanCage(animal));
				
					   });
					   break;
					   
			case 2:	   this.buttons[i].addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
				
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
			