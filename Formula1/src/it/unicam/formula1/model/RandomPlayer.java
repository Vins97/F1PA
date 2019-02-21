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
	private int position;
	private double distToRun;
	public RandomPlayer(CarType ct,String n,int id) {
		this.car= new Car(ct,id);
		this.name="Player"+id;
		this.id=id;
		this.position=0;
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
		return this.name+" as "+this.position;
	}

	/* (non-Javadoc)
	 * @see it.unicam.formula1.model.Player#getDistanceToRun()
	 */
	@Override
	public Double getDistanceToRun() {
		return this.getDistanceToRun();
	}

	/* (non-Javadoc)
	 * @see it.unicam.formula1.model.Player#setDistanceToRun(double)
	 */
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
}
