package com.epam.application;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import com.epam.interfaces.IConstants;

public class Main implements IConstants {
	
	/** Property - numbers */
	private static List<Integer> numbers;
	
	/** Property - main_thread */
	private static MainThread main_thread;
	
	private static Button[] buttons;
	private static Label[] labels;
	private static Text number;
	
	// выполняем инициализацию свойств main_thread и numbers
	static { 
		
		main_thread = new MainThread();
		numbers = new ArrayList<>();
		
	}
	
	public static void main(String[] args) {
	
		main_thread.start();
		
		Display display = new Display();
	    Shell shell = new Shell(display);
	    
	    RowLayout layout = new RowLayout(SWT.HORIZONTAL);
	    layout.spacing = 10;
	    layout.marginTop = 10;
	    layout.marginLeft = 10;
	    layout.marginRight = 10;
	    layout.marginBottom = 10;
		
	    shell.setLayout(layout);
	    
		RowData data1 = new RowData();
		data1.width = 150; 
		RowData data2 = new RowData();
		data2.width = 110;
		RowData data3 = new RowData();
		data3.width = 270;
		
		labels = new Label[4];
		
		labels[0] = new Label(shell, SWT.CENTER);
		labels[0].setText("Input number:");
		    
		number = new Text(shell, SWT.NONE);
		number.setLayoutData(data1);
		    
		buttons = new Button[] {
		    		
			new Button(shell, SWT.NONE),
		    new Button(shell, SWT.NONE),
		    new Button(shell, SWT.NONE),
		    new Button(shell, SWT.NONE), 
		    new Button(shell, SWT.NONE)
		    		
		};
		
		labels[1] = new Label(shell, SWT.NONE);
		labels[1].setText("Row:");
		labels[1].setLayoutData(data3);
		labels[2] = new Label(shell, SWT.NONE);
		labels[2].setText("Min:");
		labels[2].setLayoutData(data3);
		labels[3] = new Label(shell, SWT.NONE);
		labels[3].setText("Max:");
		labels[3].setLayoutData(data3);
		 
		for (int i = 0; i < buttons.length; i++) {
			
			buttons[i].setText(NAME_BUTTONS[i]);
			buttons[i].setLayoutData(data2);
			
		}
		
		// устанвливаем обработчик события для кнопки "Add"
		buttons[0].addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetDefaultSelected(SelectionEvent event) {}
				
			@Override
			public void widgetSelected(SelectionEvent event) {
				
				try {
					
					numbers.add(new Integer(Integer.parseInt(number.getText().trim())));
					labels[1].setText(labels[1].getText() + " " + number.getText().trim());
					number.setText("");
					
				} catch (NumberFormatException e) {
					
					number.setText("");
					
				}
					
			}
		    	
		});
		
		// устанавливаем обработчик события для кнопки "Max"
		buttons[1].addSelectionListener(new SelectionListener() {
		    	
		    @Override
			public void widgetDefaultSelected(SelectionEvent event) {}
				
			@Override
			public void widgetSelected(SelectionEvent event) {
				
				main_thread.setNumbers(numbers);
				main_thread.setNumberComand(1);
				
				List<Integer> array = main_thread.getMaxExtremum();
				
				for (int number : array) labels[3].setText(labels[3].getText() + " " + Integer.toString(number));
					
			}
		    	
		});
		    
		// устанавливаем обработчик события для кнопки "Min"
		buttons[2].addSelectionListener(new SelectionListener() {
		    	
		    @Override
			public void widgetDefaultSelected(SelectionEvent event) {}
				
			@Override
			public void widgetSelected(SelectionEvent event) {
				
				main_thread.setNumbers(numbers);
				main_thread.setNumberComand(2);
				
				List<Integer> array = main_thread.getMinExtremum();	
				
				for (int number : array) labels[2].setText(labels[2].getText() + " " + Integer.toString(number));
				
			}
		    	
		});
		    
		// устанавливаем обработчик события для кнопки "Clean"
		buttons[3].addSelectionListener(new SelectionListener() {
		    	
		    @Override
			public void widgetDefaultSelected(SelectionEvent event) {}
				
			@Override
			public void widgetSelected(SelectionEvent event) {
				
				main_thread.setMaxExtremum(new ArrayList<Integer>());
				main_thread.setMinExtremum(new ArrayList<Integer>());
				numbers.removeAll(numbers);
				labels[1].setText("Row:");
				labels[2].setText("Min:");
				labels[3].setText("Max:");
					
			}
		    	
		});
		    
		// устанавливаем обработчик события для кнопки "Exit"
		buttons[4].addSelectionListener(new SelectionListener() {
		    	
		    @Override
			public void widgetDefaultSelected(SelectionEvent event) {}
				
			@Override
			public void widgetSelected(SelectionEvent event) {
				
				main_thread.setStateThread(1);
				shell.close();	
					
			}
		    	
		});
		    
		shell.setText(TITLE_WINDOW);
		shell.setSize(WIDTH_WINDOW, HEIGHT_WINDOW);
		shell.open();
	    
	    
	    while (!shell.isDisposed()) {
	        if (!display.readAndDispatch ()) display.sleep (); 
	    } 
	    display.dispose ();
		
	}
	
}
	

