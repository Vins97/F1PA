/**
 * 
 */
package it.unicam.formula1.model.testSuite;



import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import it.unicam.formula1.model.CarType;
import it.unicam.formula1.model.InteractivePlayer;
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
		
		List<InteractivePlayer> listInteractive = new ArrayList<>();
		listInteractive.add(new InteractivePlayer(CarType.FERRARI, "nome", 44));
		
		Race r = new Race(listInteractive);
		r.fillRandomBot();
		Player[] p = r.getRacer();
		for(Player p1: p) System.out.println(p1);		
	}
	@Test 
	void testAddPlayer() {
		List<InteractivePlayer> listInteractive = new ArrayList<>();
		listInteractive.add(new InteractivePlayer(CarType.FERRARI, "nome", 44));
		listInteractive.add(new InteractivePlayer(CarType.FERRARI, "nome1", 55));
		listInteractive.add(new InteractivePlayer(CarType.FERRARI, "nome2", 66));
		
		Race r = new Race(listInteractive);
		r.addInteractivePlayer();
		Player[] p = r.getRacer();
		for(Player p1: p) System.out.println(p1);	
	}
	@Test
	void testStart(){
		List<InteractivePlayer> listInteractive = new ArrayList<>();
		listInteractive.add(new InteractivePlayer(CarType.FERRARI, "nome", 44));
		listInteractive.add(new InteractivePlayer(CarType.FERRARI, "nome1", 55));
		listInteractive.add(new InteractivePlayer(CarType.FERRARI, "nome2", 66));
		Race r = new Race(listInteractive);
		Player[] p = r.getRacer();
		for(Player p1: p) System.out.println(p1);
	}

}
