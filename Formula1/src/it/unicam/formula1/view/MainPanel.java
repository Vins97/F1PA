/**
 * 
 */
package it.unicam.formula1.view;

import javax.swing.JFrame;


import it.unicam.formula1.controller.Control;

import it.unicam.formula1.model.ModelSetting;
import it.unicam.formula1.model.PathGeneratorFromTxtCsv;
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
	
	
	public MainPanel(ModelSetting settings){  
		if(settings.getTrackpath().equalsIgnoreCase("DEFAULT"))
			this.race = new Race(settings.getP());
		else
			this.race = new Race(settings.getP(),new PathGeneratorFromTxtCsv(settings.getTrackpath()).getPath());
		this.view = new View(race);
		this.control = new Control(race, view);
		startRace();		
	}
	public void startRace() {
		this.race.mainGameLoop();
	}




	
}
