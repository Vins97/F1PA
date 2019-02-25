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
	public void setP(InteractivePlayer p) {
		//eventuali giocatori aggiunti oltre nPlayer non vengono aggiunti
		if(count<=nPlayer)
			this.p.add(p);
		count++;
	}
	public int getNumPlayerToInsert(){
		return nPlayer-count;
	}
	
	

}
