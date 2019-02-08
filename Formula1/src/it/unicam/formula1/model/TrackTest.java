/**
 * 
 */
package it.unicam.formula1.model;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Point;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

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
		ArrayList<Asphalt> as = new ArrayList<>();
		Track trDf= new Track();
		as = trDf.initLines(1);
		assertNotNull(as);
	}
	@Test 
	void testInitLinesBool() throws DataInputException{
		ArrayList<Asphalt> as = new ArrayList<>();
		Track trDf= new Track();
		as = trDf.initLines(1);
		assertFalse(as.isEmpty());
	}
	
	/**
	 * Test method for {@link it.unicam.formula1.model.Track#getTrack()}.
	 */
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

	/**
	 * Test method for {@link it.unicam.formula1.model.Track#getCheckPointLine()}.
	 */
	@Test
	void testGetCheckPointLine() throws DataInputException{
		Track trDf= new Track();
		assertFalse(trDf.getCheckPointLine().isEmpty());
	}
	
	@Test
	void testIsAsphaltOnTrack() throws DataInputException{
		Track trDf= new Track();
		assertTrue(trDf.isAsphaltOnTrack(new Asphalt(1, 1)));
	}
	@Test
	void testIsPointInTrack2() throws DataInputException{
		Track trDf= new Track();
		assertTrue(trDf.isPointOfTrack(1, 2));
	}

}
