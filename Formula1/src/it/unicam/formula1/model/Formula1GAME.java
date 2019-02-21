/**
 * 
 */
package it.unicam.formula1.model;

import java.awt.EventQueue;
import java.applet.*;

import javax.swing.JFrame;


import it.unicam.formula1.view.MainPanel;

/**
 * @author Vincenzo Chiarella 30 gen 2019
 *
 */
public class Formula1GAME implements Runnable{
	
	

    public static void main(String[] args) {
		EventQueue.invokeLater(new Formula1GAME());
    }

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		MainPanel mp = new MainPanel();		
	}



}
