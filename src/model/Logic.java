package model;

import java.util.ArrayList;
import processing.core.PApplet;

public class Logic {
	
	private PApplet app;
	private String [] shapes;
	private ArrayList<Square> squareList;
	private ArrayList<Circle> circleList;
	private ArrayList<Triangle> triangleList;
	private boolean crash1, crash2, crash3;
	
	public Logic(PApplet app) {
		this.app = app;
		this.crash1 = false;
		this.crash2 = false;
		this.crash3 = false;
		
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
			squareList.get(i).draw(app);
		}
		
		for (int i = 0; i < circleList.size(); i++) {
			circleList.get(i).draw(app);
		}
		
		for (int i = 0; i < triangleList.size(); i++) {
			triangleList.get(i).draw();
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
		
		//Crash between a square and a circle
		for (int i = 0; i < squareList.size(); i++) {
			//Square variable
			Square square = squareList.get(i);
			for (int j = 0; j < circleList.size(); j++) {
					//Circle variable
					Circle circle = circleList.get(j);
				
					//Distance between shapes
					if (app.dist(square.getPosX(), square.getPosY(), circle.getPosX(), circle.getPosY())<circle.getSize()/2) {
						crash1 = true;
						if (crash1) {
							//Addition of both of the values that crashed
							int valueTriangle = additionValues(square.getValue(), circle.getValue());
							//Adding triangle as a result of the crash
							triangleList.add(new Triangle(app, square.getPosX(), square.getPosY(), square.getDir1(), 
																		square.getDir2(), valueTriangle, square.getSpeed()));
							//Removing the shapes that crashed
							squareList.remove(square);
							circleList.remove(circle);
							crash1 = false;
						}
				}
			}
		}
		
		//Crash between a square and a square
		for (int i = 0; i < squareList.size(); i++) {
			//Variable for the first squares
			Square square1 = squareList.get(i);
			for (int j = 0; j < squareList.size(); j++) {
				//Variable for the second squares
				Square square2 = squareList.get(j);
				
				//Determine which square is bigger
				int bigSquare = 0;
				if (square1.getSize() > square2.getSize()) {
					bigSquare = square1.getSize();
				}
				
				if (square1.getSize() < square2.getSize()) {
					bigSquare = square2.getSize();
				}
				
				//Distance between shapes
				if (app.dist(square1.getPosX(), square1.getPosY(), square2.getPosX(), square2.getPosY()) < bigSquare/2) {
					crash2 = true;
					if (crash2) {
						//Addition of both of the values that crashed
						int valueTriangle2 = additionValues(square1.getValue(), square2.getValue());
						//Adding triangle as a result of the crash
						triangleList.add(new Triangle(app, square1.getPosX(), square1.getPosY(), square1.getDir1(), 
																	square1.getDir2(), valueTriangle2, square1.getSpeed()));
						//Removing the shapes that crashed
						squareList.remove(square1);
						squareList.remove(square2);
						crash2 = false;
					}
				}
			}
		}

		//Crash between a circle and a circle
		for (int i = 0; i < circleList.size(); i++) {
			//Variable for the first circles
			Circle circle1 = circleList.get(i);
			for (int j = 0; j < circleList.size(); j++) {
				//Variable for the second squares
				Circle circle2 = circleList.get(j);
				
				//Determine which circle is bigger
				int bigCircle = 0;
				if (circle1.getSize() > circle2.getSize()) {
					bigCircle = circle1.getSize();
				}
				
				if (circle1.getSize() < circle2.getSize()) {
					bigCircle = circle2.getSize();
				}
				
				//Distance between shapes
				if (app.dist(circle1.getPosX(), circle1.getPosY(), circle2.getPosX(),circle2.getPosY())< bigCircle/2) {
					crash3 = true;
					if (crash3) {
						//Addition of both of the values that crashed
						int valueTriangle3 = additionValues(circle1.getValue(), circle2.getValue());
						//Adding triangle as a result of the crash
						triangleList.add(new Triangle(app, circle1.getPosX(), circle1.getPosY(), circle1.getDir1(), 
																	circle1.getDir2(), valueTriangle3, circle1.getSpeed()));
						//Removing the shapes that crashed
						circleList.remove(circle1);
						circleList.remove(circle2);
						crash3 = false;
					}
				}
			}
		}
	}
	
	public void newShape() {
		
		//Random number to choose which shape to create
		int shapeChooser = (int) (Math.random()*2+1);
		
		switch (shapeChooser) {
		case 1:
			squareList.add(new Square());
			break;
		case 2:
			circleList.add(new Circle());
			break;
		default:
			break;
		}

	}
	
	private double distance(double x1, double x2, double y1, double y2) {
		return Math.sqrt((y2 - y1)*(y2 - y1) + (x2 - x1)*(x2 - x1));
	}
	
	private int additionValues(int value1, int value2) {
		return Integer.sum(value1, value2);

	}

}
