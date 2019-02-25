/**
 * 
 */
package it.unicam.formula1.model;


import java.awt.Point;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import it.unicam.formula1.model.exception.DataInputException;




/**
 * @author Vincenzo Chiarella 31 gen 2019
 *
 */
public class Race {
	private final int numRacer=4;
	private Track trackChoosen;
	private Player[] racer = new Player[numRacer];
	private List<InteractivePlayer> interactiveList;

	private List<Player> leaderBoard;

	private int currentPlayer = 0;

	//TODO da aggiungere il tracciato al costruttore
	public Race(List<InteractivePlayer> listPlayer) {
		try {
			this.trackChoosen= new Track();
			this.leaderBoard= new ArrayList<>();
			this.interactiveList = new ArrayList<>(listPlayer);
			addInteractivePlayer();
			fillRandomBot();
			initCarPosition();
		}catch(DataInputException e){

		}
	}
	public Race(Track trackChoosen){
		super();
		this.trackChoosen = trackChoosen;
		this.initCarPosition();
	}	
	//usare una player factory (Factory Method)
	public void addInteractivePlayer() {		
		for(int i=0;i<this.interactiveList.size();i++) {
			racer[i] = this.interactiveList.get(i);
		}
	}
	public void fillRandomBot() {
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

	public void moveInteractiveCar() {

	}
	public void mainGameLoop() {


		updateLeaderboard();
		while(doMoves());
	}
	public boolean doMoves() {			
		if(getCurrentPlayer().getIsInGame()) {
			boolean c=true;
			Moves m = getCurrentPlayer().nextMove();
			this.trackChoosen.moveCar(getCurrentPlayer().getCar(),m);
			//updateLeaderboard();
			System.out.println(getCurrentPlayer().toString() + m);
			c=checkForWinner(this.currentPlayer);
			changePlayer();
			return !c;
		}
		changePlayer();
		return true;			
	}
	private boolean checkForWinner(int p) {
		if(this.racer[p].getCar().isAllChecked())
			return true;
		else 
			return false;		
	}

	private void changePlayer() {
		this.currentPlayer= (currentPlayer+1)%numRacer;
	}
	private void updateLeaderboard() {
		List<Player> tempLead = new ArrayList<>();
		for(int i=0;i<numRacer;i++) {
			if(racer[i].getIsInGame()) {
				racer[i].setDistanceToRun(this.trackChoosen.getTotalDistanceToRun(racer[i].getCar()));
				tempLead.add(racer[i]);
			}			
		}
		Collections.sort(tempLead);
		this.leaderBoard=tempLead;		
	}

	public List<Player> getLeaderBoard(){
		return this.leaderBoard;
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
