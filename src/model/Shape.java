package model;

import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PFont;

public abstract class Shape {
	
	protected PApplet app;
	protected String shapes;
	protected int size, posX, posY, direction, value;
	protected int r, g, b;
	
	public Shape(PApplet app, String shapes) {
		this.app = app;
		this.shapes = shapes;
		
		//Variables for the color
		r = (int) (Math.random()*255+50);
		b = (int) (Math.random()*255+50);
		g = (int) (Math.random()*255+50);
	}
	
	protected void separateVariables() {

	}

	public void draw() {
		app.fill(r, g, b);
		app.stroke(80);
		app.strokeWeight(2);
		app.textAlign(PConstants.CENTER);
		app.textSize(16);
		
	}
	
	public void move() {
		
	}
	
}
