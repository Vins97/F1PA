/**
 * 
 */
package it.unicam.formula1.model.exception;

/**
 * @author Vincenzo Chiarella 30 gen 2019
 *
 */
public class DataInputException extends Exception {
	private static final long serialVersionUID = 1L;
	@Override
	public String getMessage() {
		return "Problem about input point";
	}
	

}
