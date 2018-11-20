package it.unicam.formula1.model;


import java.awt.geom.Point2D;

import java.util.List;

public class Track {
	private List<Asphalt> track;
	Track(List<Asphalt> trackChoosen){
		this.track=trackChoosen;
	}
	Track(){
		for(int i=0;i<100;i++) {
			for(int j=0;j<350;j++)
				new Asphalt(i,j);
		}
	}
	
	
		
}	
	

