package it.unicam.formula1.model;
import java.awt.Point;


public interface Movable {
	Point getActualPosition();
	Point updateInertia(Moves choosenMove);
	
}	
