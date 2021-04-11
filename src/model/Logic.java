package model;

import java.awt.event.MouseEvent;
import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PConstants;

public class Logic {
	
	private PApplet app;
	private String [] shapes;
	private ArrayList<Square> squareList;
	private ArrayList<Circle> circleList;
	private ArrayList<Triangle> triangleList;
	private boolean crash;
	
	public Logic(PApplet app) {
		this.app = app;
		this.crash = false;
		
		//Loading TXT
		shapes = app.loadStrings("./data/Shapes.txt");
		//Array list of shapes
		squareList = new ArrayList<>();
		circleList = new ArrayList<>();
		triangleList = new ArrayList<>();
		
		//Separating TXT
		separateTXT();
	}
	
	public void separateTXT() {
		//Going through the array created from the text, divided by lines
		for (int i = 0; i < shapes.length; i++) {
			
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
		//Drawing the shapes from the list of objects
		for (int i = 0; i < squareList.size(); i++) {
			squareList.get(i).draw();
			squareList.get(i).move();
		}
		
		for (int i = 0; i < circleList.size(); i++) {
			circleList.get(i).draw();
			circleList.get(i).move();
		}
		
		for (int i = 0; i < triangleList.size(); i++) {
			triangleList.get(i).draw();
			triangleList.get(i).move();
		}
		
		distShapes();
	}
	
	public void stopMoveCircle() {
			for (int j = 0; j < circleList.size(); j++) {
					//Mouse clicked (left) on circle, it makes it the circles stop
					if (distance(app.mouseX, circleList.get(j).getPosX(), app.mouseY, circleList.get(j).getPosY())<circleList.get(j).getSize()) {
						circleList.get(j).setStopMove(!circleList.get(j).isStopMove());
					}
			}
	}
	
	public void stopMoveSquare() {
			for (int i = 0; i < squareList.size(); i++) {
				//Mouse clicked (left) on square, it makes it stop
				if (app.mouseX > squareList.get(i).getPosX()-squareList.get(i).getSize() && 
						app.mouseX < squareList.get(i).getPosX()+squareList.get(i).getSize() &&
						app.mouseY > squareList.get(i).getPosY()-squareList.get(i).getSize() &&
						app.mouseY < squareList.get(i).getPosY()+squareList.get(i).getSize()) {
					squareList.get(i).setStopMove(!squareList.get(i).isStopMove());
				}
			}
	}
	
	public void stopMoveTriangle() {
		for (int i = 0; i < triangleList.size(); i++) {
			//Mouse clicked (left) on triangle, it makes it stop
			if (distance(app.mouseX, triangleList.get(i).getPosX(), app.mouseY, triangleList.get(i).getPosY())<triangleList.get(i).getSides()-10) {
				triangleList.get(i).setStopMove(!triangleList.get(i).isStopMove());
			}		
		}
	}
	
	private void distShapes() {
		
		for (int i = 0; i < squareList.size(); i++) {
			for (int j = 0; j < circleList.size(); j++) {
					
					//Validating the distance between the basic shapes to add the values and turn the shape into a triangle
					double distanceSandC = distance(squareList.get(i).getPosX(), circleList.get(j).getPosX(), 
																			squareList.get(i).getPosY(), circleList.get(j).getPosY());
						
					//Crash between a square and a circle
					if (distanceSandC < circleList.get(j).getSize()) {
						//Addition of both of the values that crashed
						int valueTriangle = additionValues(squareList.get(i).getValue(), circleList.get(j).getValue());
						//Adding triangle as a result of the crash
						triangleList.add(new Triangle(app, squareList.get(i).getPosX(), squareList.get(i).getPosY(), 
																			squareList.get(i).getDir1(), squareList.get(i).getDir2(),
																			valueTriangle, squareList.get(i).getSpeed()));
						//Removing the shapes that crashed
						squareList.remove(i);
						circleList.remove(j);
						crash = true;
					}
					
					
					for (int k = 0; k < triangleList.size(); k++) {
						//Validating the distance between two triangles to add the values
						double distanceTandT = distance(triangleList.get(k).getPosX(), triangleList.get(k).getPosX(), 
																		triangleList.get(k).getPosY(), triangleList.get(k).getPosY());
						//Crash between two triangles
						if (distanceTandT < 50 && crash == true) {
							//Addition of both of the values of the crash
							int valueTriangle2 = additionValues(triangleList.get(k).getValue(), triangleList.get(k).getValue());
							//triangleList.get(k).setValue(valueTriangle2);
						}
				}
			}	
		}
	}
	
	public void newShape() {
		

	}
	
	private double distance(double x1, double x2, double y1, double y2) {
		return Math.sqrt((y2 - y1)*(y2 - y1) + (x2 - x1)*(x2 - x1));
	}
	
	private int additionValues(int value1, int value2) {
		return Integer.sum(value1, value2);

	}

}
