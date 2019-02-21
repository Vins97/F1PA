/**
 * 
 */
package it.unicam.formula1.model;


import java.awt.Point;
import java.util.ArrayList;
import java.util.Collections;

import it.unicam.formula1.model.exception.DataInputException;
import it.unicam.formula1.model.exception.PlayerErrorException;



/**
 * @author Vincenzo Chiarella 31 gen 2019
 *
 */
public class Race {
	private static final int numRacer=4;
	private Track trackChoosen;
	private Player[] racer = new Player[numRacer];
	private ArrayList<Player> leaderBoard;
	private int interactivePlayer;
	private int currentPlayer = 0;
	public Race(int interactivePlayer) {
		try {
		this.trackChoosen= new Track();
		this.leaderBoard= new ArrayList<>();
		this.start();
		}catch(DataInputException e){
			
		}
	}
	public Race(Track trackChoosen){
		super();
		this.trackChoosen = trackChoosen;
		this.initCarPosition();
	}
	//usare una player factory (Factory Method)
	public void addPlayer(CarType c,String nome,int id) {		
		PlayerFactory pf = new PlayerFactory();
		for(int i=0;i<numRacer;i++) {
			if(racer[i]==null) {
				racer[i] = pf.getPlayer("itr", c, nome, id);
				break;
			}	
		}
	}
	public void controlAddPlayer() {
		
		
	}
	public void addRandomPlayer() {
		PlayerFactory pf = new PlayerFactory();
		for(int i=0;i<numRacer;i++) {
			if(racer[i]==null)
				racer[i] = pf.getPlayer("rdm", null, null, 0);
		}

	}
	private void initCarPosition() {
		int pos=0;
		//sublist to get first 4 position 
		for (Point as: this.trackChoosen.getStrGrid().getLine().subList(0, numRacer)) {
			trackChoosen.setCarOnTrack(racer[pos].getCar(), as.x, as.y);
			pos++;
		}
		
	}
//	//
//	public Player nextPlayer(int prevId) {
//		return racer[(prevId+1)%numRacer];		
//	}

	public void start() {
		for(int i=0;i<this.interactivePlayer;i++) {
			controlAddPlayer();
		}
		addRandomPlayer();		
		initCarPosition();		
	//	this.updateLeaderboard();
		//while(doMoves());
	}
	//TODO da correggere perche' quando un giocatore va fuori pista non si ferma la gara
	public boolean doMoves() {
		try {
			Moves m = this.racer[this.currentPlayer].nextMove();
			this.trackChoosen.moveCar(this.racer[this.currentPlayer].getCar(),m);
			updateLeaderboard();
			if(this.racer[this.currentPlayer].getCar().isAllChecked()) return false;
			changePlayer();
		}catch(PlayerErrorException e) {
			
		}
	
		return true;
	}
	private void changePlayer() {
		this.currentPlayer= (currentPlayer+1)%numRacer;
	}
	private void updateLeaderboard() {
		ArrayList<Player> tempLead = new ArrayList<>();
		for(int i=0;i<numRacer;i++) {		
			racer[i].setDistanceToRun(this.trackChoosen.getTotalDistanceToRun(racer[i].getCar()));
			tempLead.add(racer[i]);			
		}
		Collections.sort(tempLead);
		this.leaderBoard=tempLead;		
	}
	//serve per il controller
	public Player getCurrentPlayer() {
		return this.racer[this.currentPlayer];
	}
	
	public Track getTrackChoosen() {
		return this.trackChoosen;
	}
	public Player[] getRacer() {
		return this.racer;
	}

}
