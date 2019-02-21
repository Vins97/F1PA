/**
 * 
 */
package it.unicam.formula1.model.testSuite;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import it.unicam.formula1.model.Asphalt;
import it.unicam.formula1.model.Car;
import it.unicam.formula1.model.CarType;

/**
 * @author Vincenzo Chiarella 31 gen 2019
 *
 */
class AsphaltTest {

	@Test
	void equalsCar() {
		Asphalt a1 = new Asphalt(1,1);
		Asphalt a2 = new Asphalt(2,1);
		a1.setCar(new Car(CarType.FERRARI, 1));
		a1.equalsCar(new Car(CarType.FERRARI, 1));
		
	}

}
