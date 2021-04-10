package model;

import processing.core.PApplet;

public abstract class Shape {
	
	protected PApplet app;
	protected String [] arrayShape;
	
	public Shape(PApplet app, String [] arrayShape) {
		this.app = app;
		this.arrayShape = arrayShape;
	}

	public void draw() {
		
	}
	
	public void move() {
		
	}
	
}
