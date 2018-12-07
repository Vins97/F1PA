package it.unicam.formula1.model;

public class SingletonGrid {
	private static SingletonGrid grid;
	private static Asphalt[][]	floor;
	private static final int DEFAULT_SIZE = 350;
	private SingletonGrid() {
		this.floor= new Asphalt [DEFAULT_SIZE][DEFAULT_SIZE];
	}
	//used lazy inizialization
	public static SingletonGrid getInstance() {
		if(grid== null)
			grid = new SingletonGrid();
		return grid;
	}
	private static void writeTrack() {
		
	}

}
