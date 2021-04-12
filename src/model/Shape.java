package model;

import processing.core.PApplet;
import processing.core.PConstants;

public class Shape {
	
	protected PApplet app;
	protected String shapes;
	protected int size, posX, posY, dir1, dir2, value, speed;
	protected int r, g, b;
	protected boolean stopMove;
	
	public Shape(PApplet app, String shapes) {
		this.app = app;
		this.shapes = shapes;
		this.stopMove = true;
		
		//Variables for the color
		r = (int) (Math.random()*255+50);
		b = (int) (Math.random()*255+50);
		g = (int) (Math.random()*255+50);
		
		//Random speed for the shapes
		speed = (int)(Math.random()*4+1);
		
		//Splitting String into array
		String [] shapeVariables = app.split(shapes, " ");
		
		//Going through the array and turning the strings into numbers, for the values of the variables (based on position)
		for (int i = 0; i < shapeVariables.length; i++) {
			size = Integer.parseInt(shapeVariables[1]);
			posX = Integer.parseInt(shapeVariables[2]);
			posY = Integer.parseInt(shapeVariables[3]);
			dir1 = Integer.parseInt(shapeVariables[4]);
			dir2 = Integer.parseInt(shapeVariables[4]);
			value = Integer.parseInt(shapeVariables[5]);
		}
	}
	
	public Shape() {
		this.stopMove = true;
		
		//Random values for the variables (for right click)
		this.size = (int) (Math.random()*80+20);
		this.posX = (int) (Math.random()*580+20);
		this.posY = (int) (Math.random()*580+20);
		this.dir1 = (int) (Math.random()*2+0);
		//Direction for the shapes randomly made
		if (dir1 == 0) {
			dir1 = 1;
		} else {
			dir1 = -1;
		}
		this.dir2 = (int) (Math.random()*2+0);
		if (dir2 == 0) {
			dir2 = 1;
		} else {
			dir2 = -1;
		}
		this.value = (int) (Math.random()*20+1);
		
		//Variables for the color
		r = (int) (Math.random()*255+50);
		b = (int) (Math.random()*255+50);
		g = (int) (Math.random()*255+50);
		
		//Random speed for the shapes
		speed = (int)(Math.random()*4+1);
	}
	
	public void separateVariables() {

	}

	public void draw(PApplet app) {
		app.fill(r, g, b);
		app.stroke(80);
		app.strokeWeight(2);
		app.textAlign(PConstants.CENTER);
		app.textSize(16);
		move();
	}
	
	protected void move() {
		if (stopMove) {
			posX += (speed * dir1);
			posY += (speed * dir2);
			
			if (posX < 0 || posX > 800) {
				dir1 = dir1*(-1);
			}
			
			if (posY < 0 || posY > 600) {
				dir2 = dir2*(-1);
			}
		}
	}
	
	public int getSize() {
		return size;
	}

	public int getPosX() {
		return posX;
	}

	public int getPosY() {
		return posY;
	}

	public int getDir1() {
		return dir1;
	}

	public int getDir2() {
		return dir2;
	}

	public int getValue() {
		return value;
	}
	
	public void setValue(int value) {
		this.value = value;
	}

	public int getSpeed() {
		return speed;
	}
	
	public boolean isStopMove() {
		return stopMove;
	}
	
	public void setStopMove(boolean stopMove) {
		this.stopMove = stopMove;
	}
}
