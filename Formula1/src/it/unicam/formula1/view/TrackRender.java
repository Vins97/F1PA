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
public class TrackRender extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 779796061997824537L;
	private static final int MULTIPLICATION_FACTOR = 10;
	private static final int GRIDDIMENSIONX = 120;
	private static final int GRIDDIMENSIONY = 65;
	private Track t;
	TrackRender(Track t){
		this.t= t;
	}
	//disegna il tracciato appena viene creato l'oggetto
	@Override	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
	    Graphics2D g2d = (Graphics2D) g;
	    g2d.setStroke(new BasicStroke(MULTIPLICATION_FACTOR));
		for (Asphalt a : t.getTrack()) {
			if(a.getCar()==null) {
    			g2d.setColor(new Color(68, 68, 68));
    			if(!a.isIdDefalt()) {
        			g2d.setColor(Color.cyan);
        		}
    			g2d.fillRect(a.x*MULTIPLICATION_FACTOR,(GRIDDIMENSIONY - a.y -1)*MULTIPLICATION_FACTOR, MULTIPLICATION_FACTOR , MULTIPLICATION_FACTOR );
    		}
    		else {
    			g2d.setColor(a.getCar().getTeamColor());
    			g2d.fillOval(a.x*MULTIPLICATION_FACTOR,(GRIDDIMENSIONY - a.y-1)*MULTIPLICATION_FACTOR, MULTIPLICATION_FACTOR, MULTIPLICATION_FACTOR);
    		}    		
	    }
		g2d.setStroke(new BasicStroke(0));
		g2d.setColor(new Color(0,0,0));
		for (int i = 0; i <= GRIDDIMENSIONX; i++) {
			g2d.drawLine(i * MULTIPLICATION_FACTOR, 0, i * MULTIPLICATION_FACTOR, GRIDDIMENSIONY * MULTIPLICATION_FACTOR);
			if (i <= GRIDDIMENSIONY)
				g2d.drawLine(0, i * MULTIPLICATION_FACTOR, GRIDDIMENSIONX * MULTIPLICATION_FACTOR, i * MULTIPLICATION_FACTOR);
		}
	}

}
