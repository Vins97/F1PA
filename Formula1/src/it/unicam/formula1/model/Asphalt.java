package it.unicam.formula1.model;

import java.awt.geom.Point2D;

public class Asphalt {
	private boolean isAlreadyBusy;
	private Car occupiedSpace;
	private Point2D coordinates;
	public Asphalt() {
		this.isAlreadyBusy = false;
	}
	public Asphalt(double x,double y) {
		this();
		this.coordinates.setLocation(x, y);
	}
	public Asphalt(Point2D coords) {
		this();
		this.coordinates.setLocation(coords);
	}
	//vedere se una data macchina può trovarsi in quel punto o meno
	public void setBusy (Car occuper){
		if(!isAlreadyBusy) {
			this.isAlreadyBusy=true;
			this.occupiedSpace=occuper;
		}
			
	}
	public void setFree () {
		if(isAlreadyBusy) {
			this.isAlreadyBusy=false;		
			this.occupiedSpace=null;
		}
	}
	public boolean getStatusBusy() {
		return isAlreadyBusy;
	}
	public Point2D getCoordinates() {
		return coordinates;
	}
	
	
}
