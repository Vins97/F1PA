/**
 * 
 */
package it.unicam.formula1.view;




import java.util.List;

import javax.swing.JFrame;


import it.unicam.formula1.controller.Control;
import it.unicam.formula1.model.InteractivePlayer;
import it.unicam.formula1.model.Race;

/**
 * @author Vincenzo Chiarella 12 feb 2019
 *
 */
public class MainPanel extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3786810852961962984L;
	private Race race;
	private View view;
	private Control control;
	
	
	public MainPanel(List<InteractivePlayer> interactivePlayer){  
		this.race = new Race(interactivePlayer);
		this.view = new View(race);
		this.control = new Control(race, view);
		startRace();
	}

	public void startRace() {
		this.race.mainGameLoop();
	}




	
}
