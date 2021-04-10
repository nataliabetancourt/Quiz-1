package model;

import processing.core.PApplet;
import processing.core.PConstants;

public class Square extends Shape{
	
	private String [] squareVariables;
	
	public Square(PApplet app, String shapes) {
		super(app, shapes);
		
		//Separating the String received into an array to get each variable
		separateVariables();
	}
	
	protected void separateVariables() {
		//Splitting String into array
		squareVariables = app.split(shapes, " ");
		
		//Going through the array and turning the strings into numbers, for the values of the variables (based on position)
		for (int i = 0; i < squareVariables.length; i++) {
			size = Integer.parseInt(squareVariables[1]);
			posX = Integer.parseInt(squareVariables[2]);
			posY = Integer.parseInt(squareVariables[3]);
			direction = Integer.parseInt(squareVariables[4]);
			value = Integer.parseInt(squareVariables[5]);
		}
	}
	
	public void draw() {
		super.draw();
		app.rectMode(PConstants.CENTER);
		app.rect(posX, posY, size, size);
		app.fill(80);
		app.text(value, posX, posY+5);
	}
	
	public void move() {
		
	}

}
