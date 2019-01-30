package it.unicam.formula1.model;

import java.util.ArrayList;
import java.util.Map;

public class Track {
	private ArrayList<Asphalt> track;
	private ArrayList<Asphalt> strGrid;
	private Map<Integer,ArrayList<Asphalt>> checkPointLine;
	public Track(ArrayList<Asphalt> trackChoosen,ArrayList<Asphalt> startingGrid,Map<Integer,ArrayList<Asphalt>> chkLns)throws DataInputException{
		this.track=trackChoosen;		
		this.strGrid = startingGrid;
		this.checkPointLine = chkLns;
		checkInputData();
	}
	public Track() throws DataInputException{
		for(int i=0;i<100;i++) {
			for(int j=0;j<350;j++)
				track.add(new Asphalt(i,j));
		}
		checkInputData();
	}
	//TODO check if element of strGri and checkPoingLine are in the track
	private void checkInputData() throws DataInputException{
		if(!track.containsAll(strGrid))
			throw new DataInputException();
		for(Integer checkNum : checkPointLine.keySet()) {
			if(!track.containsAll(checkPointLine.get(checkNum)))
				throw new DataInputException();
		}
	}
	public boolean isAsphaltOnTrack(Asphalt p) {
		return track.contains(p);
	}
	
	//For JUnitTest
	
	public ArrayList<Asphalt> getTrack() {
		return track;
	}
	public ArrayList<Asphalt> getStrGrid() {
		return strGrid;
	}
	public Map<Integer, ArrayList<Asphalt>> getCheckPointLine() {
		return checkPointLine;
	}
	
	
	
	
		
}	
	

