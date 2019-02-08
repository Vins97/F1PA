/**
 * 
 */
package it.unicam.formula1.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * @author Vincenzo Chiarella 31 gen 2019
 *
 */
class AsphaltTest {

	@Test
	void test() {
		Asphalt as = new Asphalt(1,1);
		assertTrue(as.equals(new Asphalt(1, 1)));
	}

}
