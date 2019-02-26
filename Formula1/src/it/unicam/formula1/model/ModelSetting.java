/**
 * 
 */
package it.unicam.formula1.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Vincenzo Chiarella 23 feb 2019
 *
 */
public class ModelSetting {
	private int nPlayer=1;
	private List<InteractivePlayer> p = new ArrayList<>();
	private int count=0;
 	private String trackpath = "DEFAULT";


	public ModelSetting() {
	}
	
	public int getnPlayer() {
		return nPlayer;
	}
	public void setnPlayer(int nPlayer) {
		this.nPlayer = nPlayer;
	}
	public List<InteractivePlayer> getP() {
		return p;
	}
	public void addNewPlayer(CarType c, String nome, int id) {
		//eventuali giocatori aggiunti oltre nPlayer non vengono aggiunti
		if(count<=nPlayer)
			this.p.add(new InteractivePlayer(c,nome,id));
		count++;
	}
	public int getNumPlayerToInsert(){
		return nPlayer-count;
	}
	public String getTrackpath() {
		return trackpath;
	}

	public void setTrackpath(String trackpath) {
		this.trackpath = trackpath;
	}

}
