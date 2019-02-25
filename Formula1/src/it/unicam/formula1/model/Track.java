package it.unicam.formula1.model;

import java.awt.Point;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.stream.Collectors;


import it.unicam.formula1.model.exception.DataInputException;



public class Track {
	private ArrayList<Asphalt> trk;
	private VectorLine strGrid;
	private VectorLine[] checkPointLines = new VectorLine[4];
	private final int SIZETRACK = 10;
	
	public Track(ArrayList<Asphalt> trackChoosen,VectorLine startingGrid,VectorLine[] chkLns)throws DataInputException{
		this.trk= new ArrayList<>(trackChoosen);		
		this.strGrid = startingGrid;
		this.checkPointLines = chkLns;
		this.checkInputData();
	}
	//inizializza un tracciato diritto 
	public Track() throws DataInputException{
		this.trk = new ArrayList<>();
		trackGenerator();
		this.strGrid = initLines(0,0);
		initCPLines();
		putCheckPointOnTrack();
		checkInputData();
	}
	//controlla se i check point e la linea iniziale siano all'interno del tracciato
	private void checkInputData() throws DataInputException{
		if(!this.trk.containsAll(strGrid.getLine()))
			throw new DataInputException();
		for(VectorLine cp: checkPointLines) {
			if(!this.trk.containsAll(cp.getLine()))
				throw new DataInputException();
		}
	}	
	//controlla se l'auto compiendo lo spostamento attraversa caselle fuori dal tracciato
	private boolean checkLines(ArrayList<Asphalt> as) {
		return this.trk.containsAll(as);
	}
	
	
	//controlla che se e che id abbia il checkpoint dato il vettore di spostamento dell'auto
	private Vector<Integer> matchCheckPoint(ArrayList<Asphalt> a) {			
		Vector<Integer> iDS= new Vector<>();
		ArrayList<Asphalt> ids= 
				a.stream()
		.filter(agg -> agg.isIdDefalt()!=true).collect(Collectors.toCollection(ArrayList::new));
		for(Asphalt as:ids) {
			iDS.add(as.getId());
		}
		return iDS;
	}

	
	//controlla se l'asfalto e' sul tracciato
	public boolean isAsphaltOnTrack(Asphalt p) {
		return this.trk.contains(p);
	}
	public boolean isAsphaltOnTrack(int x,int y) {
		return this.isAsphaltOnTrack(new Asphalt(x,y));
	}
	
	//default startinggrid
	public VectorLine initLines(int baseX,int id) {
		return new VectorLine(new Point(baseX,0),new Point(baseX,SIZETRACK-1),id);
	}
	//
	public void initCPLines() {
		for(int i=0;i<checkPointLines.length;i++) {
			checkPointLines[i]=this.initLines((i+1)*5,i);
		}
		
	}
	
	//assegna all'asfalto il checkpoint ricavato dal checkpointline
	private void putCheckPointOnTrack() {		
		for(int i=0;i<checkPointLines.length;i++) {
			for(Point a : checkPointLines[i].getLine())
				this.getAsphalt(a.x,a.y).setId(i);					
		}
	}
	//posiziona una macchiana su un determinato punto
	public boolean setCarOnTrack(Car c,int x,int y) {
		if(isAsphaltOnTrack(x, y)) {
			c.setOnTrack(true);
			return this.getAsphalt(x, y).setCar(c);
			}			
		else return false;		
	}
	
	//restituisce gli oggetti Asphalt del tracciato che corrispondono al vettore di asphalto
	public ArrayList<Asphalt> getAsphaltArray(ArrayList<Asphalt> asLs){
		ArrayList<Asphalt> ss = new ArrayList<>();
		for(Asphalt a : asLs) {
			ss.add(this.getAsphalt(a.x,a.y));
		}
		return ss;
	}
	//ritorna l'oggetto asphalt alle date coordinate
	public Asphalt getAsphalt(int x,int y) {
		return trk.stream()
				  .filter(coords -> new Asphalt(x,y).equals(coords))
				  .findAny()
				  .orElse(null);
	}
	//ritorna l'oggetto asphalt che contiene quella determinata macchina
	public Asphalt getAsphalt(Car c) {
		return trk.stream()
				.filter(as -> new Asphalt(c).equalsCar(as.getCar()))
				.findAny()
				.orElse(null);
	}
	
	//restituisce il numero di macchine nel tracciato
	
	public int numCarOnCircuit() {
		return (int)trk.stream()
				  .filter( asph -> asph.isEmpty()!= true )
				  .count();
	}
	
	//restituisce gli oggetti asphalt che contengono una macchina
	public ArrayList<Asphalt> getCarsPosition(){
		ArrayList<Asphalt> position = new ArrayList<>();
		position = trk
				.stream()
				.filter( asph -> asph.isEmpty()!= true)
				.collect(Collectors.toCollection(ArrayList::new));
		return position;
	}
	
	
	//sposta una macchina da una posizione all'altra
	public void moveCar(Car c,Moves choosenMove) {
		c.makeAcceleration(choosenMove);
		Asphalt actual = getAsphalt(c);
		Asphalt next = getAsphalt(actual.x+c.getInertia().x,actual.y+c.getInertia().y);		
			ArrayList<Asphalt> vector = new ArrayList<>();
			vector = BresenhamAlgorithm.findLine(actual.getLocation(),next.getLocation());
			vector = this.getAsphaltArray(vector);
			
			if(!this.checkLines(vector)) {
				actual.setEmpty();
				next.setEmpty();
				c.setOnTrack(false);
			}				
			Vector<Integer> ids = this.matchCheckPoint(vector);
			for(Integer i:ids) { 
				c.addCheckPassed(i);
			}
		if(next.isEmpty()) {
			actual.setEmpty();
			next.setCar(c);
		}else{	
			actual.setEmpty();
			c.setOnTrack(false);			
			}
	}
	
	public double getDistance(Point p1,Point p2) {
		return Point2D.distanceSq(p1.getX(), p1.getY(), p2.getX(), p2.getY());
	}	
	public double getDistance(VectorLine cp1,VectorLine cp2) {
		return this.getDistance(cp1.getMiddle(), cp2.getMiddle());
	}
	//controlla la distanza tra macchina e il prossimo checkpoint 
	//piu' la somma delle distanze tra i check point
	public double getTotalDistanceToRun(Car c) {
		int i=0;
		boolean isFirst=true;
		double totDist=0;
		if(c.isAllChecked()) return 0;
		for(boolean b:c.getCheckPassed()) {
			if(b) i++;
			if(!b) {
				if(isFirst) {
					totDist+=this.getDistance(this.getAsphalt(c).getLocation(),checkPointLines[i].getMiddle());
					isFirst=false;
					i++;
				}else {
					totDist+=this.getDistance(checkPointLines[i], checkPointLines[(i+1)%4]);
					i++;
				}
			}
		}
		return totDist;		
	}
	
	public void printAsphaltList(List<Asphalt> list) {
		list.forEach(System.out::println);
	}
	
	
	
	
	//for JUnitTest
	public ArrayList<Asphalt> getTrack() {
		return trk;
	}	
	public VectorLine getStrGrid() {
		return strGrid;
	}
	public	VectorLine[] getCheckPointLine() {
		return checkPointLines;
	}
	
	
	private void trackGenerator() {
		for(int i=0;i<100;i++) {
			for(int j=0;j<SIZETRACK;j++)
				trk.add(new Asphalt(i,j));
		}
	}
	
	
	
	
		
}	
	

