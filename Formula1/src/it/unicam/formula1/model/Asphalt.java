package it.unicam.formula1.model;

import java.awt.Point;

public class Asphalt{
	private Point coordinates;
	private Car carOccuper;

	public Asphalt(int x,int y) {
		this.coordinates = new Point(x,y);
	}
	public Asphalt(Point coords) {
		this.coordinates = new Point(coords);
	}
	//set car in the piece of asphalt 
	public boolean setCar(Car c) {
		if(this.isEmpty()) {
			this.carOccuper=c;
			return true;
		}
		else return false;
	}
	//set piece of asphalt free
	public void setEmpty() {
		this.carOccuper=null;
	}
	//check if the asphalt piece is free
	public boolean isEmpty() {
		return this.carOccuper==null;
	}
	
	public Point getCoordinates() {
		return coordinates;
	}
	//to use the default contains and containsall arraylist method whith a correct implementation
	@Override
	public boolean equals(Object o) {
		// TODO Auto-generated method stub
		if(o instanceof Asphalt) {
			Asphalt piece = (Asphalt)o;
			return (this.getCoordinates().getX()==piece.getCoordinates().getX())&&(this.getCoordinates().getY()==piece.getCoordinates().getY());
		
		}
		return false;
	} 


	
}
