package it.unicam.formula1.view;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;

import it.unicam.formula1.model.Asphalt;
import it.unicam.formula1.model.Moves;
import it.unicam.formula1.model.Race;

public class View extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6522414053180990973L;
	private Race race;
	//MULTIPLICATOR FACTOR serve ad aumentare la grandezza dell'asfalto e delle macchine

	
	private JPanel btnContainer = new JPanel();
	
	private JButton  SW;
	private JButton  S ;
	private JButton  SE ;
	private JButton  W ;
	private JButton  NEUTRAL;
	private JButton  E;
	private JButton  NW;
	private JButton  N;
	private JButton  NE;
	
	
	private JFrame f = new JFrame();
	
	public View(Race r){
		super();
		this.race=r;
		//imposta controller a destra	
		
		    this.btnContainer.setLayout(new GridLayout(3, 3,0 ,150));
			this.btnContainer.add(NW);
			
			this.btnContainer.add(N);
			this.btnContainer.add(NE);
	
			this.btnContainer.add(W);
			this.btnContainer.add(NEUTRAL);
			this.btnContainer.add(E);
		
			this.btnContainer.add(SW);
			this.btnContainer.add(S);
			this.btnContainer.add(SE);
		
			f.setLayout(new BorderLayout());
			f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
			f.setSize(1280,720);
			f.add(new TrackRender(race.getTrackChoosen()),BorderLayout.CENTER);
			f.add(this.btnContainer,BorderLayout.EAST);
			f.setLocationRelativeTo(this);
			f.setVisible(true);
	}
	private void buttonGenerator() {
		for(Moves m: Moves.values()) {
			JButton button = new JButton(m.toString());
			btnContainer.add(button);
			button.addActionListener(new ActionListener() {				
				@Override
				public void actionPerformed(ActionEvent e) {
					race.getCurrentPlayer().
					
				}
			});
	
		}
		
	}
	




	
}
