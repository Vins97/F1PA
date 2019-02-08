/**
 * 
 */
package it.unicam.formula1.model;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Iterator;



/**
 * @author Vincenzo Chiarella 31 gen 2019
 *
 */
public class Race {
	private int numRacer;
	private Track trackChoosen;
	private ArrayList<Car> racer;
	public Race(int numRacer, Track trackChoosen) {
		super();
		this.numRacer = numRacer;
		this.trackChoosen = trackChoosen;
		initCarPosition(trackChoosen.getStrGrid());
	}
	private void initCarPosition(ArrayList<Asphalt> strGrid) {
		Iterator it= strGrid.iterator();
		int i=1;
		while(it.hasNext()) {
			Asphalt p = (Asphalt)it.next();
			if(i<numRacer) {
				racer.add(new Car(CarType.FERRARI,p.getCoordinates()));
				i++;
			}
		}
	}
	//TODO choosable car
	//TODO change state of asphalt if car make a moves

}
