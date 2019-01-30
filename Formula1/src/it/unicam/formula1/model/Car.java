package it.unicam.formula1.model;
import java.awt.Point;


public class Car implements Movable {
	private Point actualPos;
	private Point inertiaVec;
	private CarType team;
	
	Car(CarType team,Point strPosition){
		this.team=team;
		this.inertiaVec.setLocation(0,0);
		this.actualPos.setLocation(strPosition);
	}
	
	@Override
	public Point getActualPosition() {
		return actualPos;
	}
	@Override
	public Point updateInertia(Moves choosenMove) {		
		inertiaVec.setLocation(inertiaVec.getX()+choosenMove.getMoves().getX() ,inertiaVec.getY()+choosenMove.getMoves().getY());
		return 	inertiaVec;
	}
	
	public void setNewPosition() {		
		actualPos.setLocation(actualPos.getX()+inertiaVec.getX(), actualPos.getY()+inertiaVec.getY());		
	}

	public String getTeamColor() {
		return team.getColor();
	}
	


}
