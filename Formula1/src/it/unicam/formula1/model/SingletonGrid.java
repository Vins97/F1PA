package it.unicam.formula1.model;

public class SingletonGrid {
	private static SingletonGrid grid;
	private static int[][]	floor;
	private static final int DEFAULT_SIZE = 350;
	private SingletonGrid() {
		this.floor= new int[DEFAULT_SIZE][DEFAULT_SIZE];
	}
	//used lazy inizialization
	public static SingletonGrid getInstance() {
		if(grid== null)
			grid = new SingletonGrid();
		return grid;
	} 	

}
