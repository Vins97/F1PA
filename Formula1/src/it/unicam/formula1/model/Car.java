package it.unicam.formula1.model;
import java.awt.Color;
import java.awt.Point;



public class Car  {
	private int id;
	private final int NUMBER_OF_CHECKPOINT = 4;
	private Point inertiaVec;
	private boolean[] checkPass = new boolean[NUMBER_OF_CHECKPOINT];
	private CarType team;
	private boolean isOnTrack;
	public Car(CarType team,int id){
		this.team=team;
		this.id=id;
		this.inertiaVec = new Point(0,0);
	}
	public void makeAcceleration(Moves choosenMove) {		
		inertiaVec.setLocation(inertiaVec.getX()+choosenMove.getMoves().getX() ,inertiaVec.getY()+choosenMove.getMoves().getY());
	}
	
	public Color getTeamColor() {
		return team.getColor();
	}

	@Override
	public String toString() {
		return "Team: "+this.team.toString()+" Id: "+this.id;
	}

	@Override
	public boolean equals(Object o) {		
		if(o instanceof Car) {
			Car piece = (Car)o;
			return (this.getId()==piece.getId());		
		}
		return false;
	}
	
	public void addCheckPassed(int id) {
		this.checkPass[id]= true;
	}
	
	public boolean[] getCheckPassed() {
		return this.checkPass;
	}
	
	public boolean isAllChecked() {
		for(boolean b : checkPass) {
			if(!b) return false;
		}
		return true;
	}
	
	public Point getInertia() {
		return inertiaVec;
	}

	public int getId() {
		return id;
	}
	public boolean isOnTrack() {
		return isOnTrack;
	}
	public void setOnTrack(boolean isOnTrack) {
		this.isOnTrack = isOnTrack;
	}
	

	
	


}
