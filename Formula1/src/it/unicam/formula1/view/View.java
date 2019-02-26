package it.unicam.formula1.view;




import java.awt.BorderLayout;



import javax.swing.JFrame;

import it.unicam.formula1.model.Race;

public class View extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6522414053180990973L;
	private Race race;

	
	public View(Race r){
		super();
		this.race=r;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		setSize(1920,1080);
		setTitle("F1 Game Unicam PA");			
		setLocationRelativeTo(this);
		setVisible(true);
		setLayout(new BorderLayout());
		updateView();
				
	}
	
	public void updateView() {
		//aggiungendo altri elementi nella stessa posizione quelli precedenti vengono sovrascritti
		add(new TrackRender(race.getTrackChoosen()),BorderLayout.CENTER);
		
 
//		DefaultListModel<String> dlm = new DefaultListModel<>();
//		for (Player p : race.getLeaderBoard()) {
//			dlm.addElement(p.toString());
//		}
//		add(new JList<String>(dlm),BorderLayout.SOUTH);
	}


 


	
}
