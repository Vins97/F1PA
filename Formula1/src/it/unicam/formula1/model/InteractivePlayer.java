/**
 * 
 */
package it.unicam.formula1.model;

import it.unicam.formula1.view.InteractiveCommand;

/**
 * @author Vincenzo Chiarella 31 gen 2019
 *
 */
public class InteractivePlayer implements Player {
	private Car car;
	private String name;
	private int id=1;
	private double distToRun;
	
	public InteractivePlayer(CarType ct,String n,int id) {
		this.car= new Car(ct,id);
		this.name=n;
		this.id=id;
	}
	@Override
	public Car getCar() {
		return this.car;
	}
	//fa la mossa in modo da modificare la posizione sul tracciato e se ricava un errore ha perso
	@Override
	public Moves nextMove() {
		return new InteractiveCommand(this).getMoves();		
	}
	@Override
	public String toString() {
		return this.name;
	}

	@Override
	public Double getDistanceToRun() {		
		return distToRun;
	}
	@Override
	public void setDistanceToRun(double d) {
		this.distToRun=d;		
	}
	//per la leaderboard
	@Override
	public int compareTo(Player o) {
	        if(this.getDistanceToRun() < o.getDistanceToRun()) return -1;
	        else if(this.getDistanceToRun() > o.getDistanceToRun()) return 1;
	        else return 0;	
	}

	@Override
	public int getId() {
		return this.id;
	}

	@Override
	public void setIsInGame(boolean s) {
		this.car.setOnTrack(s);	
	}

	@Override
	public boolean getIsInGame() {
		return this.car.isOnTrack();
	}
	
	
	

}
