/**
 * 
 */
package it.unicam.formula1.model;


/**
 * @author Vincenzo Chiarella 31 gen 2019
 *
 */
public class RandomPlayer implements Player {
	private Car car;
	private String name;
	private int id;
	private double distToRun;
	private boolean isInGame=true;
	public RandomPlayer(CarType ct,String n,int id) {
		this.car= new Car(ct,id);
		this.name="Player"+id;
		this.id=id;
		this.distToRun=1000;
	}

	@Override
	public Car getCar() {
		return this.car;
	}

	@Override
	public Moves nextMove() {
		return RandomUtils.randomEnum(Moves.class);
	}

	@Override
	public String toString() {
		return this.name;
	}

	@Override
	public Double getDistanceToRun() {
		return this.distToRun;
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

	/* (non-Javadoc)
	 * @see it.unicam.formula1.model.Player#getId()
	 */
	@Override
	public int getId() {
		return this.id;
	}

	@Override
	public void setIsInGame(boolean s) {
		this.isInGame=s;		
	}

	@Override
	public boolean getIsInGame() {
		return isInGame;
	}
}
