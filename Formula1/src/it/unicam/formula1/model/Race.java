/**
 * 
 */
package it.unicam.formula1.model;

import java.util.List;

import java.util.stream.Collectors;

import javax.swing.JOptionPane;





/**
 * @author Vincenzo Chiarella 31 gen 2019
 *
 */
public class Race {
	private final int numRacer=4;
	private Track trackChoosen;
	private Player[] racer = new Player[numRacer];

	//private List<Player> leaderBoard;
	private int currentPlayer = 0;
	
	public Race(List<InteractivePlayer> listPlayer) {
			this.trackChoosen= new Track();
		//	this.leaderBoard= new ArrayList<>();
			addInteractivePlayer(listPlayer);
			fillRandomBot();
			initCarPosition();	
			
	}
	public Race(List<InteractivePlayer> listPlayer, List<Asphalt> trackPath){	
			this.trackChoosen= new Track(trackPath);
		//	this.leaderBoard= new ArrayList<>();
			addInteractivePlayer(listPlayer);
			fillRandomBot();
			initCarPosition();

	}	
	//usare una player factory (Factory Method)
	public void addInteractivePlayer(List<InteractivePlayer> pl) {		
		for(int i=0;i<pl.size();i++) {
			racer[i] = pl.get(i);
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
		List<Asphalt> as = this.getTrackChoosen().getTrack().stream().filter(asp -> asp.isStartPoint()).collect(Collectors.toList());		
		for(Asphalt a : as.subList(0, numRacer)) {
			trackChoosen.setCarOnTrack(getCurrentPlayer().getCar(), a.x, a.y);
			changePlayer();
		}
	}
	

	public void mainGameLoop() {
	//	updateLeaderboard();
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
			if(c) {
				JOptionPane.showMessageDialog(null, getCurrentPlayer().youFinish(),"Congratulazioni",JOptionPane.INFORMATION_MESSAGE);
				return false;
				}			
			changePlayer();
			return !c;
		}
		if(allPlayerOut()) {
			JOptionPane.showMessageDialog(null, "Fai ripartire una gara","Non ha vinto nessuno",JOptionPane.INFORMATION_MESSAGE);
			return false;
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
	private boolean allPlayerOut() {
		for(Player p : racer) {
			if(p.getIsInGame())
				return false;
		}
		return true;
	}
	private void changePlayer() {
		this.currentPlayer= (currentPlayer+1)%numRacer;
	}
	
//	private void updateLeaderboard() {
//		List<Player> tempLead = new ArrayList<>();
//		for(int i=0;i<numRacer;i++) {
//			if(racer[i].getIsInGame()) {
//				racer[i].setDistanceToRun(this.trackChoosen.getTotalDistanceToRun(racer[i].getCar()));
//				tempLead.add(racer[i]);
//			}else {
//				racer[i].setDistanceToRun(9999);
//				tempLead.add(racer[i]);
//			}
//		}
//		Collections.sort(tempLead);
//		this.leaderBoard=tempLead;		
//	}

//	public List<Player> getLeaderBoard(){
//		return this.leaderBoard;
//	}
	//restituisce il giocatore che sta di turno
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
