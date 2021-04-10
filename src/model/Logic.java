package model;

import java.util.ArrayList;

import processing.core.PApplet;

public class Logic {
	
	private PApplet app;
	private String [] shapes;
	private ArrayList<Square> squareList;
	private ArrayList<Circle> circleList;
	
	public Logic(PApplet app) {
		this.app = app;
		
		//Loading TXT
		shapes = app.loadStrings("./data/Shapes.txt");
		//Array list of shapes
		squareList = new ArrayList<>();
		circleList = new ArrayList<>();
		
		//Separating TXT
		separateTXT();
	}
	
	public void separateTXT() {
		//Going through the array created from the text, divided by lines
		for (int i = 0; i < shapes.length; i++) {
			//System.out.println(shapes[i]);
			
			//Separating each element of the array, based on the first word that defines the shape, and making them objects
			if (shapes[i].contains("Cuadrado")) {
				squareList.add(new Square(app, shapes[i]));
			}
			
			if (shapes[i].contains("Circulo")) {
				circleList.add(new Circle(app, shapes[i]));
			}
		}
	}
	
	public void draw() {
		for (int i = 0; i < squareList.size(); i++) {
			squareList.get(i).draw();
		}
		
		for (int i = 0; i < circleList.size(); i++) {
			circleList.get(i).draw();
		}

	}
	
	public void stopMove() {
		

	}
	
	public void distShapes() {
		

	}
	
	public void newShape() {
		

	}

}
