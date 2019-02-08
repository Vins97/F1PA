package it.unicam.formula1.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;


public class Track {
	private ArrayList<Asphalt> trk;
	private ArrayList<Asphalt> strGrid;
	private HashMap<Integer,ArrayList<Asphalt>> checkPointLine;
	private final int SIZETRACK = 10;
	private final int CHECKPOINTDISTANCE = 10;
	
	public Track(ArrayList<Asphalt> trackChoosen,ArrayList<Asphalt> startingGrid,HashMap<Integer,ArrayList<Asphalt>> chkLns)throws DataInputException{
		this.trk= new ArrayList<>(trackChoosen);		
		this.strGrid = new ArrayList<>(startingGrid);
		this.checkPointLine = new HashMap<>(chkLns);
		//checkInputData();
	}
	//method to create a standard streight track whith checkpoints every
	public Track()throws DataInputException{
		this.trk = new ArrayList<>();
		for(int i=0;i<100;i++) {
			for(int j=0;j<SIZETRACK;j++)
				trk.add(new Asphalt(i,j));
		}
		this.strGrid = new ArrayList<>(initLines(1));
		this.checkPointLine = new HashMap<>(initCPLines());
		checkInputData();
	}
	//TODO check if element of strGri and checkPoingLine are in the track
	private void checkInputData() throws DataInputException{
		if(!this.trk.containsAll(strGrid))
			throw new DataInputException();
		for(Integer checkNum : checkPointLine.keySet()) {
			if(!this.trk.containsAll(checkPointLine.get(checkNum)))
				throw new DataInputException();
		}
	}
	//check if that point is on track
	public boolean isAsphaltOnTrack(Asphalt p) {
		return this.trk.contains(p);
	}
	public boolean isPointOfTrack(int x,int y) {
		return this.getTrack().contains(new Asphalt (x,y));
	}
	//default straight track 
	public ArrayList<Asphalt> initLines(int baseX) {
		ArrayList<Asphalt> grid = new ArrayList<>();
		for (int i=0;i<SIZETRACK; i++)
			grid.add(new Asphalt(baseX,i));
		return grid;
	}
	public HashMap<Integer,ArrayList<Asphalt>> initCPLines() {
		HashMap<Integer,ArrayList<Asphalt>> ch = new HashMap<>();
		for(int i=0;i<5;i++)
			ch.put(i, initLines((i+1)*CHECKPOINTDISTANCE));		
		return ch;
	}
	public void setCarOnTrack(String pl,Car c) {
		c.setNewPosition();
	}
	//For JUnitTest
	public ArrayList<Asphalt> getTrack() {
		return trk;
	}
	public ArrayList<Asphalt> getStrGrid() {
		return strGrid;
	}
	public HashMap<Integer, ArrayList<Asphalt>> getCheckPointLine() {
		return checkPointLine;
	}
	
	
	
	
		
}	
	

