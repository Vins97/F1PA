/**
 * 
 */
package it.unicam.formula1.view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import it.unicam.formula1.model.Asphalt;
import it.unicam.formula1.model.Track;

/**
 * @author Vincenzo Chiarella 20 feb 2019
 *
 */
public class ViewTrackRender extends JPanel{

	private static final long serialVersionUID = -7370831895405750199L;
	
	private final int MULTIPLICATION_FACTOR = 10;
	private final int DIM_FIXED=7;
	private final int GRIDDIMENSIONX = 24*DIM_FIXED;
	private final int GRIDDIMENSIONY = 13*DIM_FIXED;
	private Track t;
	ViewTrackRender(Track t){
		this.t= t;
	}
	//disegna il tracciato appena viene creato l'oggetto
	@Override	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
	    Graphics2D g2d = (Graphics2D) g;
	    g2d.setStroke(new BasicStroke(MULTIPLICATION_FACTOR));
	    paintTrack(g2d);
	    paintCar(g2d);
	    paintGrid(g2d);
	}
	public void paintTrack(Graphics2D g2d) {
	    for (Asphalt a : t.getTrack()) {
	    	g2d.setColor(new Color(68, 68, 68));
	    	if(!a.isIdDefalt()) g2d.setColor(Color.cyan);	    	
	    	g2d.fillRect(a.x*MULTIPLICATION_FACTOR,(GRIDDIMENSIONY - a.y -1)*MULTIPLICATION_FACTOR, MULTIPLICATION_FACTOR , MULTIPLICATION_FACTOR );
	    }		
	}
	
	public void paintCar(Graphics2D g2d) {
		for(Asphalt a : t.getCarsPosition()) {
			g2d.setColor(a.getCar().getTeamColor());
			g2d.fillOval(a.x*MULTIPLICATION_FACTOR,(GRIDDIMENSIONY - a.y-1)*MULTIPLICATION_FACTOR, MULTIPLICATION_FACTOR, MULTIPLICATION_FACTOR);
		}
	}
	public void paintGrid(Graphics2D g2d) {
		g2d.setStroke(new BasicStroke(0));
		g2d.setColor(new Color(0,0,0));
		for (int i = 0; i <= GRIDDIMENSIONX; i++) {
			g2d.drawLine(i * MULTIPLICATION_FACTOR, 0, i * MULTIPLICATION_FACTOR, GRIDDIMENSIONY * MULTIPLICATION_FACTOR);
			if (i <= GRIDDIMENSIONY)
				g2d.drawLine(0, i * MULTIPLICATION_FACTOR, GRIDDIMENSIONX * MULTIPLICATION_FACTOR, i * MULTIPLICATION_FACTOR);
		}
	}
	
}
