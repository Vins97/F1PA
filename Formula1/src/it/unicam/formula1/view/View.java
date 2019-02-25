package it.unicam.formula1.view;




import java.awt.BorderLayout;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;

import it.unicam.formula1.model.Race;

public class View extends JFrame{
	/**
	 * 
	 */
	private final int DEFAULTSIZE = 150;
	private static final long serialVersionUID = -6522414053180990973L;
	private Race race;

	
	public View(Race r){
		super();
		this.race=r;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		setSize(1280,720);
		setTitle("F1 Game Unicam PA");			
		setLocationRelativeTo(this);
		setVisible(true);
		setLayout(new BorderLayout());
		updateView();
				
	}
	
	public void updateView() {
		//aggiungendo altri elementi nella stessa posizione quelli precedenti vengono sovrascritti
		add(new TrackRender(race.getTrackChoosen()),BorderLayout.CENTER);
		
		List<String> strings = race.getLeaderBoard().stream()
				   .map(player -> player.toString())
				   .collect(Collectors.toList()); 
		DefaultListModel<String> dlm = new DefaultListModel<>();
		for(String s :strings ) {
			dlm.addElement(s);
		}
		add(new JList<String>(dlm),BorderLayout.EAST);
	}


 


	
}
