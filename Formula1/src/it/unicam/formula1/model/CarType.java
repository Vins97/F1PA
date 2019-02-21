package it.unicam.formula1.model;

import java.awt.Color;

public enum CarType {
	MERCEDES(17, 135, 97),
	FERRARI(165, 6, 6),
	REDBULL(6, 34, 112),
	TOROROSSO(43, 71, 150),
	HAAS(3, 8, 15),
	FORCEINDIA(237, 125, 144),
	WILLIAMS(125, 194, 237),
	RENAULT(255, 217, 5),
	SAUBER(242, 242, 242),
	MCLAREN(255, 174, 0);
	int r,g,b;
	CarType(int r,int g,int b){
		this.r=r;
		this.g=g;
		this.b=b;
	}
	public int getIndex() {
		return this.ordinal();
	}
	public Color getColor() {
		return new Color(this.r,this.g,this.b);
	}
	
	
	
}
