/**
 * 
 */
package it.unicam.formula1.model.exception;

/**
 * @author Vincenzo Chiarella 10 feb 2019
 *
 */

public class PlayerErrorException extends Exception {
	@Override
	public String getMessage() {
		return "Someone has made a mistake";
	}

}
