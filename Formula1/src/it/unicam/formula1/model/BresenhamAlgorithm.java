/**
 * 
 */
package it.unicam.formula1.model;

import java.awt.Point;
import java.util.ArrayList;

/**
 * @author Vincenzo Chiarella 9 feb 2019
 *
 */

public class BresenhamAlgorithm {
	//Per trovare i punti che sono attravarsati dalla linea (che puo' essere usata sia per i generare i checkpoint sia per stabilire se quel check point e' stato attraversato oltre naturalmente a stabilire che ogni
	//mossa della macchina sia all'interno del circuito) 
	/**
	 * @param p1
	 * @param p2
	 * @return
	 */
	public static ArrayList<Point> findLine(Point p1,Point p2){
		
		ArrayList<Point> line = new ArrayList<>();
		
		int dx = Math.abs(p2.x - p1.x);
        int dy = Math.abs(p2.y - p1.y);
 
        int sx = p1.x < p2.x ? 1 : -1; 
        int sy = p1.y < p2.y ? 1 : -1; 
 
        int err = dx-dy;
        int e2;
 
        while (true) {
            line.add(new Point(p1.x,p1.y));
 
            if (p1.x == p2.x && p1.y == p2.y) 
                break;
 
            e2 = 2 * err;
            if (e2 > -dy) {
                err = err - dy;
                p1.x = p1.x + sx;
            } 
            if (e2 < dx)  {
                err = err + dx;
                p1.y = p1.y + sy;
            }
        }                                
        return line;
    
	}

}
