/**
 * 
 */
package it.unicam.formula1.model;


/**
 * @author Vincenzo Chiarella 31 gen 2019
 *
 */
public interface Player extends Comparable<Player> {
	void setIsInGame(boolean s);
	boolean getIsInGame();
	Car getCar();
	Moves nextMove();
	Double getDistanceToRun();
	void setDistanceToRun(double d);
	int getId();	
	default String youFinish() {
		return "Congratulazioni "+this.toString()+" Hai vinto";
	};
	default String youLoose() {
		return this.toString()+"You have made a mistake you loose";
	};
}
