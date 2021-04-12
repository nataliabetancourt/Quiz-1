package controller;

import model.Logic;
import processing.core.PApplet;

public class MainController {
	
	private PApplet app;
	private Logic logic;
	
	public MainController(PApplet app) {
		this.app = app;
		
		//Importing Logic
		logic = new Logic(app);
		
	}
	
	
	public void draw() {
		logic.draw();
	}
	
	public void stopMove() {
		logic.stopMoveCircle();
		logic.stopMoveSquare();
		logic.stopMoveTriangle();

	}
	
	public void newShape() {
		logic.newShape();

	}

}
