package model;

import processing.core.PApplet;
import processing.core.PConstants;

public class Triangle {
	
	private PApplet app;
	private int sides, posX, posY, dir1, dir2, value, speed;
	private int r, g, b;
	private boolean stopMove;
	
	public Triangle(PApplet app, int posX, int posY, int dir1, int dir2, int value, int speed) {
		this.app = app;
		this.posX = posX;
		this.posY = posY;
		this.dir1 = dir1;
		this.dir2 = dir2;
		this.value = value;
		this.speed = speed;
		this.sides = (int) (Math.random()*35+25);
		this.stopMove = true;
		
		//Variables for the color
		r = (int) (Math.random()*255+50);
		b = (int) (Math.random()*255+50);
		g = (int) (Math.random()*255+50);
	}
	
	public void draw() {
		app.fill(r, g, b);
		app.stroke(80);
		app.strokeWeight(2);
		app.triangle(posX-sides, posY+sides, posX, posY-sides, posX+sides, posY+sides);
		app.textAlign(PConstants.CENTER);
		app.textSize(16);
		app.fill(80);
		app.text(value, posX, posY+8);
		move();
		
	}
	
	private void move() {
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

	public int getSides() {
		return sides;
	}
}
