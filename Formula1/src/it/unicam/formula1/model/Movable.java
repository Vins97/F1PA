package it.unicam.formula1.model;
import java.awt.geom.Point2D;

public interface Movable {
	Point2D getActualPosition();
	Point2D updateInertia(Point2D choosenMove);
	
}	
