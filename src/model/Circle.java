package model;

import processing.core.PApplet;

public class Circle extends Shape{
	
	private String [] circleVariables;

	public Circle(PApplet app, String arrayShape) {
		super(app, arrayShape);
		
		//Separating the String received into an array to get each variable
		separateVariables();

	}
	
	public void separateVariables() {
		//Splitting String into array
		circleVariables = app.split(shapes, " ");
		
		//Going through the array and turning the strings into numbers, for the values of the variables (based on position)
		for (int i = 0; i < circleVariables.length; i++) {
			size = Integer.parseInt(circleVariables[1]);
			posX = Integer.parseInt(circleVariables[2]);
			posY = Integer.parseInt(circleVariables[3]);
			dir1 = Integer.parseInt(circleVariables[4]);
			dir2 = Integer.parseInt(circleVariables[4]);
			value = Integer.parseInt(circleVariables[5]);
		}
	}
	
	public void draw() {
		super.draw();
		app.ellipse(posX, posY, size, size);
		app.fill(80);
		app.text(value, posX, posY+5);
		
	}
	
	public void move() {
		super.move();
		
	}

}
