import java.awt.geom.Point2D;

public class Car {
	private int indexCar;
	private Point2D actualPosition;
	private Point2D inertiaVector;
	private Point2D nextPosition;
	Car(int indexCar,Point2D startingGrid){
		this.actualPosition=startingGrid;
		this.indexCar=indexCar;
	}
	
		
}
