package it.unicam.formula1.model;

import java.awt.Point;

public class Asphalt extends Point{

	private static final long serialVersionUID = 1L;
	private Car carOccuper;
	private int checkPointID;
	private boolean isStartPoint;
	public Asphalt(int x,int y) {
		super(x,y);
		this.setEmpty();
		this.checkPointID=-1;
	}
	public Asphalt(Point coords) {
		super(coords);
		this.setEmpty();
		this.checkPointID=-1;
	}
	public Asphalt(Car c) {
		super(0,0);
		this.carOccuper=c;
		this.checkPointID=-1;
	}
	//assegna l'oggetto macchina al pezzo di asfalto se e' disponibile 
	public boolean setCar(Car c) {
		if(isEmpty()) {
			this.carOccuper=c;
			return true;
		}
		else return false;
	}
	public boolean equalsCar(Car c) {
		return this.carOccuper==c;
	}
	public Car getCar() {
		return this.carOccuper;
	}
	//set piece of asphalt free
	public void setEmpty() {
		this.carOccuper=null;
	}
	//controlla se l'asfalto e' vuoto
	public boolean isEmpty() {
		return this.carOccuper==null;
	}	
	//per usare containsAll e contains confrontando le coordinate
	@Override
	public boolean equals(Object o) {
		if(o instanceof Asphalt) {
			Asphalt asp = (Asphalt)o;
			return ((getX()==asp.getX())&&(getY()==asp.getY())&&(this.isStartPoint()==asp.isStartPoint())&&(getId()==asp.getId()));
		}
		else if(o instanceof Point) {
			Point piece = (Point)o;
			return (getX()==piece.getX())&&(getY()==piece.getY());
		}
		return false;
	}
	@Override
	public String toString() {
		return "["+this.getX()+","+this.getY()+"]"+" Car:"+this.carOccuper+", Start: "+isStartPoint()+", CheckID"+getId();
	} 
	
	public int getId() {
		return this.checkPointID;
	}
	public void setId(int id) {
		this.checkPointID = id;
	}
	public boolean isIdDefalt() {
		return this.checkPointID==-1;
	}
	public boolean isStartPoint() {
		return isStartPoint;
	}
	public void setStartPoint() {
		this.isStartPoint = true;
	}
	


	
}
