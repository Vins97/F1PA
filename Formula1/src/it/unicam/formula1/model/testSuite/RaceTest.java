/**
 * 
 */
package it.unicam.formula1.model.testSuite;



import org.junit.jupiter.api.Test;

import it.unicam.formula1.model.CarType;
import it.unicam.formula1.model.Player;
import it.unicam.formula1.model.Race;
import it.unicam.formula1.model.exception.DataInputException;

/**
 * @author Vincenzo Chiarella 8 feb 2019
 *
 */
class RaceTest {
	
	@Test
	void testAddRandomPlayer() throws DataInputException{
		Race r = new Race(0);
		r.addRandomPlayer();
		Player[] p = r.getRacer();
		for(Player p1: p) System.out.println(p1);		
	}
	@Test 
	void testAddPlayer() {
		Race r = new Race(0);
		r.addPlayer(CarType.FERRARI, "Ciccio", 44);
		Player[] p = r.getRacer();
		for(Player p1: p) System.out.println(p1);	
	}
	@Test
	void testStart(){
		Race r = new Race(0);
		r.start();
		Player[] p = r.getRacer();
		for(Player p1: p) System.out.println(p1);
	}

}
