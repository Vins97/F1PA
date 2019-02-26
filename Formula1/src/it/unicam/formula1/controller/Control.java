/**
 * 
 */
package it.unicam.formula1.controller;


import it.unicam.formula1.model.Race;
import it.unicam.formula1.view.View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.Timer;


/**
 * @author Vincenzo Chiarella 18 feb 2019
 *
 */
public class Control{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8306672006716268102L;
	private Race race;
	private View view;
	
	public Control(Race race, View view) {
		this.race = race;
		this.view = view;
		startRefreshTimer();
	}
	private void startRefreshTimer() {
		  int delay = 500; //milliseconds
		  ActionListener taskPerformer = new ActionListener() {
		      public void actionPerformed(ActionEvent evt) {
		          view.repaint();
		      }
		  };
		  new Timer(delay, taskPerformer).start();
	}
	
	
	
	
}
