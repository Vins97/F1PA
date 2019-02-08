/**
 * 
 */
package it.unicam.formula1.model;

import java.awt.Point;

/**
 * @author Vincenzo Chiarella 31 gen 2019
 *
 */
public interface Player {
	void startRace();
	void startChoose(String name,CarType car);
	Point nextMove(Moves move);
	void youWin();
	void youLoose();
}
