/**
 * 
 */
package it.unicam.formula1.model;

import java.awt.Point;
import java.util.ArrayList;

/**
 * @author Vincenzo Chiarella 8 feb 2019
 *
 */
public class VectorLine {
	private ArrayList<Point> line;
	private int id;

	public VectorLine(Point p1,Point p2,int id) {
		this.line = new ArrayList<>(BresenhamAlgorithm.findLine(p1, p2));
		this.id = id;
	}
	public VectorLine(ArrayList<Point> line,int id) {
		this.line = new ArrayList<>(line);
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public ArrayList<Point> getLine() {
		return line;
	}

	public void setLine(ArrayList<Point> line) {
		this.line = line;
	}
	//per calcolare la leaderboard
	public Point getMiddle() {
		return line.get((line.size()/2)+1);
	}
	
	public boolean isEmpty() {
		return line==null;
	}
	
	

}
