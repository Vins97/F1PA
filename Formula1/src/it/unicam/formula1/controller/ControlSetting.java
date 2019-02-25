
package it.unicam.formula1.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import it.unicam.formula1.model.CarType;
import it.unicam.formula1.model.InteractivePlayer;
import it.unicam.formula1.model.ModelSetting;
import it.unicam.formula1.view.MainPanel;
import it.unicam.formula1.view.ViewSetting;
import sun.applet.Main;

/**
 * @author Vincenzo Chiarella 23 feb 2019
 *
 */
public class ControlSetting {
	/**
	 * 
	 */
	private ModelSetting ms;
	private ViewSetting vs;
	
	public ControlSetting(ModelSetting ms,ViewSetting vs) {
		this.ms=ms;
		this.vs=vs;
		vs.addActionListenerNumPlayer(new NumPlayerListener());
		vs.addActionListenerPlayer(new AddNewPlayer());
		vs.addActionListenerStartRace(new StartRace());
	}
	private class NumPlayerListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			int n = (int) vs.getCmbNumPlayer().getSelectedItem();
			ms.setnPlayer(n);
			vs.setNewCounter(ms.getNumPlayerToInsert());
		}
		
	}
	private class AddNewPlayer implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			CarType c = (CarType) vs.getSelectCar().getSelectedItem();
			String name = vs.getTfPlayerName().getText();		
			int i = (int) vs.getCmbIdPlayer().getSelectedItem();		
			ms.setP(new InteractivePlayer(c,name,i));
			vs.setNewCounter(ms.getNumPlayerToInsert());
			}
		
	}
	private class StartRace implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {			
			vs.setVisible(false);
			new MainPanel(ms.getP());
			
			
		}
		
	}
}
