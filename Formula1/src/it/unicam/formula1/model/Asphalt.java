package it.unicam.formula1.model;

import java.awt.Point;

public class Asphalt{
	private boolean isBusy;
	private Point coordinates;
	
	public Asphalt() {
		this.isBusy = false;
	}
	public Asphalt(int x,int y) {
		this();
		this.coordinates = new Point(x,y);
	}
	public Asphalt(Point coords) {
		this();
		this.coordinates = new Point(coords);
	}
	//vedere se una data macchina puó trovarsi in quel punto o meno
	public void changeState () {
		this.isBusy=!this.isBusy;
	}
	
	public boolean getState() {
		return isBusy;
	}
	public Point getCoordinates() {
		return coordinates;
	}
	
}
