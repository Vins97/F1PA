/**
 * 
 */
package it.unicam.formula1.controller;

import it.unicam.formula1.model.Race;
import it.unicam.formula1.view.View;
import javax.swing.JPanel;


/**
 * @author Vincenzo Chiarella 18 feb 2019
 *
 */
public class Control extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8306672006716268102L;
	private Race race;
	private View view;
	public Control(Race race, View view) {
		this.race = race;
		this.view = view;
	}
	
	
	
	
}
