/**
 * 
 */
package it.unicam.formula1.model;

import java.awt.Point;

/**
 * @author Vincenzo Chiarella 30 gen 2019
 *
 */
public enum Moves {
	SW(-1,-1),
	S(0,-1),
	SE(1,-1),
	E(1,0),
	NE(1,1),
	N(0,1),
	NW(-1,1),
	W(-1,0),
	NEUTRAL(0,0);
	private int x;
	private int y;
	Moves(int x,int y){
		this.x=x;
		this.y=y;
	}
	public Point getMoves() {
		return new Point(x,y);
	}
}
