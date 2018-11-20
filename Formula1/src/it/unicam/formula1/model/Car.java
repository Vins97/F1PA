package it.unicam.formula1.model;
import java.awt.geom.Point2D;
import java.util.HashMap;

public class Car implements Movable {
	private Point2D actualPosition;
	private Point2D inertiaVector;
	private CarType team;
	
	Car(CarType team,Point2D startingGrid){
		this.team=team;
		this.inertiaVector.setLocation(0.0, 0.0);
	}
	
	@Override
	public Point2D getActualPosition() {
		return actualPosition;
	}
	//si potrebbe fare con iterator pattern
	@Override
	public Point2D updateInertia(Point2D choosenMove) {		
		inertiaVector.setLocation(choosenMove.getX()+inertiaVector.getX(),choosenMove.getY()+inertiaVector.getY());
		return 	inertiaVector;
	}
	public void setNewPosition() {		
		actualPosition.setLocation(actualPosition.getX()+this.inertiaVector.getX(),actualPosition.getY()+inertiaVector.getY());
	}

	public String getTeamColor() {
		return team.getColor();
	}
		
}
