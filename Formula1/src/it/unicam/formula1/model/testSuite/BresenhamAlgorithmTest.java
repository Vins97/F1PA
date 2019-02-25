/**
 * 
 */
package it.unicam.formula1.model.testSuite;

import org.junit.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.awt.Point;
import java.util.ArrayList;



import it.unicam.formula1.model.BresenhamAlgorithm;

/**
 * @author Vincenzo Chiarella 9 feb 2019
 *
 */
class BresenhamAlgorithmTest {
	@Test
	void testFindLine() {
		ArrayList<Point> a = new ArrayList<>();
		a.add(new Point(0,1));
		a.add(new Point(0,2));		
		a.add(new Point(0,3));
		a.add(new Point(0,4));
		ArrayList<Point> b = new ArrayList<>(BresenhamAlgorithm.findLine(new Point(0,1), new Point(0,4)));
		assertEquals(b,a);		
	}
	@Test 
	void testFindLine2() {
		ArrayList<Point> a = new ArrayList<>();
		a.add(new Point(0,1));
		a.add(new Point(0,2));		
		a.add(new Point(0,4));
		a.add(new Point(0,3));
		ArrayList<Point> b = new ArrayList<>(BresenhamAlgorithm.findLine(new Point(0,1), new Point(0,4)));
		assertTrue(a.containsAll(b));
	}

}
