/**
 * 
 */
package it.unicam.formula1.model;

import java.awt.Point;

/**
 * @author Vincenzo Chiarella 31 gen 2019
 *
 */
public class InteractivePlayer implements Player {
	private Car car;
	private int checkPointPassed;
	private String name;
	
	public InteractivePlayer(Car car, String name) {
		this.car = car;
		this.checkPointPassed =0;
		this.name = name;
	}

	/* (non-Javadoc)
	 * @see it.unicam.formula1.model.Player#startRace()
	 */
	@Override
	public void startRace() {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see it.unicam.formula1.model.Player#startChoose(java.lang.String, it.unicam.formula1.model.CarType)
	 */
	@Override
	public void startChoose(String name, CarType car) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see it.unicam.formula1.model.Player#nextMove(it.unicam.formula1.model.Moves)
	 */
	@Override
	public Point nextMove(Moves move) {
		// TODO Auto-generated method stub
		return move.getMoves();
	}

	/* (non-Javadoc)
	 * @see it.unicam.formula1.model.Player#youWin()
	 */
	@Override
	public void youWin() {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see it.unicam.formula1.model.Player#youLoose()
	 */
	@Override
	public void youLoose() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Player name: " + this.name +", Car chooesen: "+this.car+" ";
	}
	
	

}
