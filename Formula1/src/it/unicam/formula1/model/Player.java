/**
 * 
 */
package it.unicam.formula1.model;


/**
 * @author Vincenzo Chiarella 31 gen 2019
 *
 */
public interface Player extends Comparable<Player> {
	Car getCar();
	Moves nextMove();
	Double getDistanceToRun();
	void setDistanceToRun(double d);
	default String youFinish() {
		return this.toString()+"Congrats! You finish";
	};
	default String youLoose() {
		return this.toString()+"You have made a mistake. Start a new race!";
	};
}