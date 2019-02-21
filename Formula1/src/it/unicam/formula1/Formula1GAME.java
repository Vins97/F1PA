/**
 * 
 */
package it.unicam.formula1;

import java.awt.EventQueue;

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
	@Override
	public void run() {
		  JFrame f = new JFrame("Formula1 Unicam PA");
	        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        f.add(new MainPanel());
	        f.setSize(1280, 720);
	        f.setLocationRelativeTo(null);
	        f.setVisible(true);
		
	}

}
