package model;

import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PFont;

public class Shape {
	
	protected PApplet app;
	protected String shapes;
	protected int size, posX, posY, dir1, dir2, value, speed;
	protected int r, g, b;
	
	public Shape(PApplet app, String shapes) {
		this.app = app;
		this.shapes = shapes;
		
		//Variables for the color
		r = (int) (Math.random()*255+50);
		b = (int) (Math.random()*255+50);
		g = (int) (Math.random()*255+50);
		
		//Random speed for the shapes
		speed = (int)(Math.random()*4+1);
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
		posX += (speed * dir1);
		posY += (speed * dir2);
		
		if (posX < 0 || posX > 600) {
			dir1 = dir1*(-1);
		}
		
		if (posY < 0 || posY > 600) {
			dir2 = dir2*(-1);
		}
	}
	
}
