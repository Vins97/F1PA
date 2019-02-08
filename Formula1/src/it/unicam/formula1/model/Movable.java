package it.unicam.formula1.model;
import java.awt.Point;


public interface Movable {
	Point getActualPosition();
	boolean makeAcceleration(Moves m);	
}	
