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
	}
	
	public void separateVariables() {

	}

	public void draw() {
		app.fill(r, g, b);
		app.stroke(80);
		app.strokeWeight(2);
		app.textAlign(PConstants.CENTER);
		app.textSize(16);
		
	}
	
	public void move() {
		if (stopMove) {
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
