package it.unicam.formula1.model;

import java.awt.Point;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.stream.Collectors;





public class Track {
	private List<Asphalt> trk;
	
//	private VectorLine[] checkPointLines = new VectorLine[4];
	private final int SIZETRACK = 10;
	private final int CHECKPOINT_NUMBER=4;
	

	public Track(List<Asphalt> as){		
		this.trk = unifyTrackElements(as);
	}
	//inizializza un tracciato diritto 
	public Track(){
		this.trk = trackGenerator();

	}
	/**
	 * @param trackpoints
	 * serve per eliminare la duplicazione degli asfalti (speciale con l'asfalto vuoto)
	 * se un asfalto speciale non e' prima presente come asfalto semplice esso non verra' posizionato onde
	 * evitare ambiguita'
	 */
	private List<Asphalt> unifyTrackElements(List<Asphalt> trackpoints) {
		List<Asphalt> tempStart = getStartingGrid(trackpoints);
		List<Asphalt> tempCheckPoint = getCheckPoint(trackpoints);
		List<Asphalt> tempUnifiedTrackElements = trackpoints.stream().filter(a->a.isIdDefalt()).collect(Collectors.toList());
		tempStart.forEach(a ->{ 
			if(tempUnifiedTrackElements.contains(new Point(a.x,a.y)))
				getAsphalt(a.x,a.y,tempUnifiedTrackElements).setStartPoint();			
		});
		tempCheckPoint.forEach(a ->{ 
			if(tempUnifiedTrackElements.contains(new Point(a.x,a.y)))
				getAsphalt(a.x,a.y,tempUnifiedTrackElements).setId(a.getId());
		});
		return tempUnifiedTrackElements.stream().distinct().collect(Collectors.toList());
	}

	

	
	//controlla se l'auto compiendo lo spostamento attraversa caselle fuori dal tracciato
	public boolean checkLines(List<Point> as) {
		return this.trk.containsAll(as);
	}
	
	
	
	//controlla che se e che id abbia il checkpoint dato il vettore di spostamento dell'auto
	private Vector<Integer> matchCheckPoint(List<Point> a) {			
		Vector<Integer> iDS= new Vector<>();
		for(Point p :a) {
			if(!getAsphalt(p.x, p.y,this.trk).isIdDefalt()) {
				iDS.add(getAsphalt(p.x, p.y,this.trk).getId());
			}
		}
		return iDS;
	}	
	//controlla se l'asfalto e' sul tracciato
	public boolean isAsphaltOnTrack(Point p) {
		return this.trk.contains(p);
	}
	public boolean isAsphaltOnTrack(int x,int y) {
		return this.isAsphaltOnTrack(new Point(x,y));
	}

	//posiziona una macchiana su un determinato punto
	public boolean setCarOnTrack(Car c,int x,int y) {
		if(isAsphaltOnTrack(x, y)) {
			c.setOnTrack(true);
			return this.getAsphalt(x, y,this.trk).setCar(c);
			}			
		else return false;		
	}
	
	//restituisce gli oggetti Asphalt del tracciato che corrispondono al vettore di asphalto
	public List<Point> getAsphaltArray(List<Point> pointList){
		List<Point> ss = new ArrayList<>();
		for(Point a : pointList) {
			ss.add(getAsphalt(a.x,a.y,this.trk));
		}
		return ss;
	}
	//ritorna l'oggetto asphalt alle date coordinate
	public Asphalt getAsphalt(int x,int y,List<Asphalt> track) {
		return track.stream()
				  .filter(coords -> new Point(x,y).equals(coords))
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
//	public int numCarOnCircuit() {
//		return (int)trk.stream()
//				  .filter( asph -> asph.isEmpty()!= true )
//				  .count();
//	}
	
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
		if(!isAsphaltOnTrack(actual)) {
			c.setOnTrack(false);
			return;
		}
			Asphalt next = getAsphalt(actual.x+c.getInertia().x,actual.y+c.getInertia().y,this.trk);		
		if(isAsphaltOnTrack(next)) {
			List<Point> vector = new ArrayList<>(BresenhamAlgorithm.findLine(actual.getLocation(),next.getLocation()));
			vector = getAsphaltArray(vector);
			if(!checkLines(vector)) {
				next.setEmpty();
				c.setOnTrack(false);
			}				
			Vector<Integer> ids = this.matchCheckPoint(vector);
			for(Integer i:ids) { 
				c.addCheckPassed(i);
			}
		if(next.setCar(c)) {}
		else{	
			c.setOnTrack(false);			
			}		
		}
		actual.setEmpty();
		
	}
	
//	public double getDistance(Point p1,Point p2) {
//		return Point2D.distanceSq(p1.getX(), p1.getY(), p2.getX(), p2.getY());
//	}	
//	public double getDistance(VectorLine cp1,VectorLine cp2) {
//		return this.getDistance(cp1.getMiddle(), cp2.getMiddle());
//	}
//	//controlla la distanza tra macchina e il prossimo checkpoint 
//	//piu' la somma delle distanze tra i check point
//	public double getTotalDistanceToRun(Car c) {
//		int i=0;
//		boolean isFirst=true;
//		double totDist=0;
//		if(c.isAllChecked()) return 0;
//		for(boolean b:c.getCheckPassed()) {
//			if(b) i++;
//			if(!b) {
//				if(isFirst) {
//					totDist+=this.getDistance(this.getAsphalt(c).getLocation(),checkPointLines[i].getMiddle());
//					isFirst=false;
//					i++;
//				}else {
//					totDist+=this.getDistance(checkPointLines[i], checkPointLines[(i+1)%4]);
//					i++;
//				}
//			}
//		}
//		return totDist;		
//	}
	
	public void printAsphaltList(List<Asphalt> list) {
		list.forEach(System.out::println);
	}	
	public List<Asphalt> getStartingGrid(List<Asphalt> completeTrack){
		return completeTrack.stream().filter(a -> a.isStartPoint()).collect(Collectors.toList());
	}
	public List<Asphalt> getCheckPoint(List<Asphalt> completeTrack){
		return completeTrack.stream().filter(a -> !a.isIdDefalt()).collect(Collectors.toList());
	}

	public List<Asphalt> getTrack() {
		return trk;
	}
	
	//default startinggrid
	//-----start-----
	private ArrayList<Asphalt> trackGenerator() {
		ArrayList<Asphalt> defaultTrack = new ArrayList<>();
		for(int i=0;i<100;i++) {
			for(int j=0;j<SIZETRACK;j++)
				defaultTrack.add(new Asphalt(i,j));
		}		
		List<Point> startGrid = initLines(0,-1).getLine();
		startGrid.forEach(p -> defaultTrack.get(defaultTrack.indexOf(p)).setStartPoint());
		List<VectorLine> checkpoints = initCheckPoints(10);
		for(VectorLine vl :checkpoints) {
			vl.getLine().forEach(p -> defaultTrack.get(defaultTrack.indexOf(p)).setId(checkpoints.indexOf(vl)));
		}
		return defaultTrack;
	}	
	
	public VectorLine initLines(int baseX,int id) {		
		return new VectorLine(new Point(baseX,0),new Point(baseX,SIZETRACK-1),id);
	}
	public List<VectorLine> initCheckPoints(int distances) {
		List<VectorLine> checkpointlist = new ArrayList<>();		
		for(int i=0;i<CHECKPOINT_NUMBER;i++) {
			checkpointlist.add(initLines((i+1)*distances,i));
		}
		return checkpointlist;		
	}
	//-----end------

	
	
	
		
}	
	

