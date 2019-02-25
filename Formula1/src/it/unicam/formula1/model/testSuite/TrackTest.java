/**
 * 
 */
package it.unicam.formula1.model.testSuite;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Point;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import it.unicam.formula1.model.Asphalt;
import it.unicam.formula1.model.Car;
import it.unicam.formula1.model.CarType;
import it.unicam.formula1.model.Moves;
import it.unicam.formula1.model.Track;
import it.unicam.formula1.model.exception.DataInputException;


/**
 * @author Vincenzo Chiarella 30 gen 2019
 *
 */
class TrackTest {
	
	@BeforeAll
	static void init() throws DataInputException{
			Track trDf= new Track();
			assertNotNull(trDf);
	}
	
	@Test 
	void testInitLines() throws DataInputException{
		Track trDf= new Track();
		ArrayList<Point> a = new ArrayList<Point>(trDf.initLines(1,0).getLine()); 
		assertNotNull(a);
		assertFalse(a.isEmpty());
	}
	@Test
	void testIsEmptyTrack() throws DataInputException{
		Track trDf= new Track();
		assertFalse(trDf.getTrack().isEmpty());
		
	}

	/**
	 * Test method for {@link it.unicam.formula1.model.Track#getStrGrid()}.
	 */
	@Test
	void testGetStrGrid() throws DataInputException{
		Track trDf= new Track();
		assertFalse(trDf.getStrGrid().isEmpty());
	}
	
	@Test
	void testIsAsphaltOnTrack() throws DataInputException{
		Track trDf= new Track();
		assertTrue(trDf.isAsphaltOnTrack(new Asphalt(1, 1)));
	}
	@Test
	void testIsPointInTrack2() throws DataInputException{
		Track trDf= new Track();
		assertTrue(trDf.isAsphaltOnTrack(12,1));
	}
	@Test
	void testCarOnTrack() throws DataInputException{
		Track trDf = new Track();
		assertTrue(trDf.setCarOnTrack(new Car(CarType.FERRARI,5), 0,1));
		
	}
	@Test
	void testNumberOfCar() throws DataInputException{
		Track trDf = new Track();
		Car c1= new Car(CarType.FERRARI,5);
		trDf.setCarOnTrack(c1,0,1);
		Car c2= new Car(CarType.MCLAREN,14);
		trDf.setCarOnTrack(c2, 0, 2);
		assertTrue(2==trDf.numCarOnCircuit());				
	}
	@Test
	void printCarOnTrack() throws DataInputException {
		Track trDf = new Track();
		Car c1= new Car(CarType.FERRARI,5);
		trDf.setCarOnTrack(c1,0,1);
		Car c2= new Car(CarType.MCLAREN,14);
		trDf.setCarOnTrack(c2, 0, 2);
		//trDf.printPositionsCar(trDf.getCarsPosition());
	}
	@Test
	void getCarOnTrack() throws DataInputException {
		Track trDf = new Track();
		Car c1= new Car(CarType.FERRARI,5);
		trDf.setCarOnTrack(c1,0,1);
		Car c2= new Car(CarType.MCLAREN,14);
		trDf.setCarOnTrack(c2, 0, 2);
		//System.out.println(trDf.getCarPosition(c1));		
	}
	@Test 
	void movementT1() throws DataInputException{
		Track trDf = new Track();
		Car c1= new Car(CarType.FERRARI,5);
		trDf.setCarOnTrack(c1,0,1);
		Car c2= new Car(CarType.MCLAREN,14);
		trDf.setCarOnTrack(c2, 0, 2);
		trDf.printAsphaltList(trDf.getCarsPosition());
		trDf.moveCar(c1, Moves.E);
		trDf.moveCar(c1, Moves.E);
		trDf.moveCar(c1, Moves.N);
		trDf.moveCar(c1, Moves.E);
		System.out.println(trDf.getAsphalt(c1));	
		
	}
	@Test
	void testGetTotalDistanceToRun() throws DataInputException{
		Track trDf = new Track();
		Car c1= new Car(CarType.FERRARI,5);
		trDf.setCarOnTrack(c1,0,1);
		System.out.println(""+trDf.getTotalDistanceToRun(c1));
		trDf.moveCar(c1, Moves.E);
		trDf.moveCar(c1, Moves.E);
		trDf.moveCar(c1, Moves.E);
		trDf.moveCar(c1, Moves.E);
		trDf.moveCar(c1, Moves.E);
		trDf.moveCar(c1, Moves.E);
		trDf.moveCar(c1, Moves.E);
		System.out.println(trDf.getAsphalt(c1));	
		System.out.println(""+trDf.getTotalDistanceToRun(c1));
	}

	

}
