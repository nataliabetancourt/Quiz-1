package view;

import controller.MainController;
import processing.core.PApplet;

public class Main extends PApplet{

	public static void main(String[] args) {
		PApplet.main("view.Main");
	}
	
	MainController controller;
	
	@Override
	public void settings() {
		size(600, 600);

	}
	
	@Override
	public void setup() {
		
		controller = new MainController(this);
	
	}
	
	@Override
	public void draw() {
		background(255);
		
		controller.draw();
		
	}
	
	@Override
	public void mousePressed() {
		if (mouseButton == LEFT) {
			controller.stopMove();
		} 
		
		if (mouseButton == RIGHT) {
			controller.newShape();
		}
	}
}
