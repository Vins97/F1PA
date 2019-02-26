/**
 * 
 */
package it.unicam.formula1.model.testSuite;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

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
	void testStartingGrid() throws DataInputException{
		Track trDf= new Track();
		assertFalse(trDf.getStartingGrid(trDf.getTrack()).isEmpty());
	}
	@Test
	void testCheckPoints() throws DataInputException{
		Track trDf= new Track();
		assertFalse(trDf.getCheckPoint(trDf.getTrack()).isEmpty());
		assertFalse(trDf.getCheckPoint(trDf.getTrack()).isEmpty());
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
//	@Test
//	void testNumberOfCar() throws DataInputException{
//		Track trDf = new Track();
//		Car c1= new Car(CarType.FERRARI,5);
//		trDf.setCarOnTrack(c1,0,1);
//		Car c2= new Car(CarType.MCLAREN,14);
//		trDf.setCarOnTrack(c2, 0, 2);
//		assertTrue(2==trDf.numCarOnCircuit());				
//	}
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
		//trDf.printAsphaltList(trDf.getCarsPosition());
		trDf.moveCar(c1, Moves.E);
		trDf.moveCar(c1, Moves.E);
		trDf.moveCar(c1, Moves.N);
		trDf.moveCar(c1, Moves.E);
		//System.out.println(trDf.getAsphalt(c1));	
		
	}
	@Test
	void checkLinesTest() throws DataInputException {
		Track n = new Track();
		assertFalse(n.getCheckPoint(n.getTrack()).isEmpty());
	}
	@Test
	void unifyTrackElement() throws DataInputException {
		List<Asphalt> trackTest = new ArrayList<>();
		trackTest.add(new Asphalt(1, 1));
		trackTest.add(new Asphalt(1, 2));
		trackTest.add(new Asphalt(1, 3));
		trackTest.add(new Asphalt(1, 4));
		trackTest.add(new Asphalt(1, 5));
		trackTest.add(new Asphalt(1, 6));
		Asphalt a = new Asphalt(1,6);
		a.setStartPoint();
		trackTest.add(a);
		Asphalt b = new Asphalt(1,5);
		b.setStartPoint();
		trackTest.add(b);
		Asphalt c1 = new Asphalt(1,4);
		c1.setId(0);
		trackTest.add(c1);
		//trackTest.forEach(System.out::println);
		Track n = new Track(trackTest);
		//n.printAsphaltList(n.getTrack());
	}
//	@Test
//	void testGetTotalDistanceToRun() throws DataInputException{
//		Track trDf = new Track();
//		Car c1= new Car(CarType.FERRARI,5);
//		trDf.setCarOnTrack(c1,0,1);
//		System.out.println(""+trDf.getTotalDistanceToRun(c1));
//		trDf.moveCar(c1, Moves.E);
//		trDf.moveCar(c1, Moves.E);
//		trDf.moveCar(c1, Moves.E);
//		trDf.moveCar(c1, Moves.E);
//		trDf.moveCar(c1, Moves.E);
//		trDf.moveCar(c1, Moves.E);
//		trDf.moveCar(c1, Moves.E);
//		System.out.println(trDf.getAsphalt(c1));	
//		System.out.println(""+trDf.getTotalDistanceToRun(c1));
//	}

	

}
