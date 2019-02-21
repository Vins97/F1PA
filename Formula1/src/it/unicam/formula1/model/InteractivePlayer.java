/**
 * 
 */
package it.unicam.formula1.model;




/**
 * @author Vincenzo Chiarella 31 gen 2019
 *
 */
public class InteractivePlayer implements Player {
	private Car car;
	private String name;
	private int id;
	private double distToRun;
	
	private Moves nextMoves;
	
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
		while()
		return Moves.E;
	}
	@Override
	public String toString() {
		return this.name;
	}
	/* (non-Javadoc)
	 * @see it.unicam.formula1.model.Player#getDistanceToRun()
	 */
	@Override
	public Double getDistanceToRun() {		
		return distToRun;
	}
	@Override
	public void setDistanceToRun(double d) {
		this.distToRun=d;		
	}
	@Override
	public int compareTo(Player o) {
	        if(this.getDistanceToRun() < o.getDistanceToRun()) return -1;
	        else if(this.getDistanceToRun() > o.getDistanceToRun()) return 1;
	        else return 0;	
	}
	
	public void setNextMove(Moves m) {
		
	}
	
	
	

}
