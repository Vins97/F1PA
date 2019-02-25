/**
 * 
 */
package it.unicam.formula1;

import java.awt.EventQueue;


import it.unicam.formula1.view.SettingPanel;


/**
 * @author Vincenzo Chiarella 30 gen 2019
 *
 */
public class Formula1GAME implements Runnable{

	public static void main(String[] args) {
		EventQueue.invokeLater(new Formula1GAME());
		
	}
	@Override
	public void run() {
		new SettingPanel();
		
	}

}
