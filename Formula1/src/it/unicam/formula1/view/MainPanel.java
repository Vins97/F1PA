/**
 * 
 */
package it.unicam.formula1.view;



import java.awt.Graphics;

import javax.swing.JPanel;

import it.unicam.formula1.controller.Control;
import it.unicam.formula1.model.Race;

/**
 * @author Vincenzo Chiarella 12 feb 2019
 *
 */
public class MainPanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3786810852961962984L;
	private Race race;
	private View view;
	private Control control;
	
	
	public MainPanel(){  
		this.race = new Race(1);
		this.view = new View(race);
		this.control = new Control(race, view); 	
	}
	


	public void render(Graphics g) {
		this.repaint();
	}




	
}
