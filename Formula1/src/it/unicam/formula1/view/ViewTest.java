/**
 * 
 */
package it.unicam.formula1.view;

import static org.junit.jupiter.api.Assertions.*;

import javax.swing.JFrame;

import org.junit.jupiter.api.Test;

import it.unicam.formula1.model.Race;

/**
 * @author Vincenzo Chiarella 18 feb 2019
 *
 */
class ViewTest {

	/**
	 * Test method for {@link it.unicam.formula1.view.View#View(it.unicam.formula1.model.Race)}.
	 */
	@Test
	void testView() {
		View v = new View(new Race(1));
		}
	

}
