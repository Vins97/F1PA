/**
 * 
 */
package it.unicam.formula1.view;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.BorderFactory;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import it.unicam.formula1.model.InteractivePlayer;
import it.unicam.formula1.model.Moves;

/**
 * @author Vincenzo Chiarella 25 feb 2019
 *
 */
public class InteractiveCommand extends JDialog{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8391474996522556716L;
	private JPanel pnPanel0;
	private JButton btnNW;
	private JButton btnN;
	private JButton btnNE;
	private JButton btnW;
	private JButton btnNeutral;
	private JButton btnE;
	private JButton btnSW;
	private JButton btnS;
	private JButton btnSE;
	private JLabel lbCurrentPlayer;

	private InteractivePlayer ip;
	
	private Moves move;
	/**
	 * @param ip
	 */
	public InteractiveCommand(InteractivePlayer ip) {
		this.ip=ip;
		setModal(true);
		generateElements();
		addActionListener(new MoveListener());
		
	}
	private void generateElements() {
		pnPanel0 = new JPanel();
		pnPanel0.setBorder( BorderFactory.createTitledBorder( "Enter Command" ) );
		GridBagLayout gbPanel0 = new GridBagLayout();
		GridBagConstraints gbcPanel0 = new GridBagConstraints();
		pnPanel0.setLayout( gbPanel0 );

		btnNW = new JButton( "NW"  );
		btnNW.setActionCommand( "NW" );
		gbcPanel0.gridx = 2;
		gbcPanel0.gridy = 3;
		gbcPanel0.gridwidth = 3;
		gbcPanel0.gridheight = 3;
		gbcPanel0.fill = GridBagConstraints.BOTH;
		gbcPanel0.weightx = 1;
		gbcPanel0.weighty = 0;
		gbcPanel0.anchor = GridBagConstraints.NORTH;
		gbPanel0.setConstraints( btnNW, gbcPanel0 );
		pnPanel0.add( btnNW );

		btnN = new JButton( "N"  );
		btnN.setActionCommand( "N" );
		gbcPanel0.gridx = 6;
		gbcPanel0.gridy = 3;
		gbcPanel0.gridwidth = 3;
		gbcPanel0.gridheight = 3;
		gbcPanel0.fill = GridBagConstraints.BOTH;
		gbcPanel0.weightx = 1;
		gbcPanel0.weighty = 0;
		gbcPanel0.anchor = GridBagConstraints.NORTH;
		gbPanel0.setConstraints( btnN, gbcPanel0 );
		pnPanel0.add( btnN );

		btnNE = new JButton( "NE"  );
		btnNE.setActionCommand( "NE" );
		gbcPanel0.gridx = 10;
		gbcPanel0.gridy = 3;
		gbcPanel0.gridwidth = 3;
		gbcPanel0.gridheight = 3;
		gbcPanel0.fill = GridBagConstraints.BOTH;
		gbcPanel0.weightx = 1;
		gbcPanel0.weighty = 0;
		gbcPanel0.anchor = GridBagConstraints.NORTH;
		gbPanel0.setConstraints( btnNE, gbcPanel0 );
		pnPanel0.add( btnNE );

		btnW = new JButton( "W"  );
		btnW.setActionCommand( "EW" );
		gbcPanel0.gridx = 2;
		gbcPanel0.gridy = 7;
		gbcPanel0.gridwidth = 3;
		gbcPanel0.gridheight = 3;
		gbcPanel0.fill = GridBagConstraints.BOTH;
		gbcPanel0.weightx = 1;
		gbcPanel0.weighty = 0;
		gbcPanel0.anchor = GridBagConstraints.NORTH;
		gbPanel0.setConstraints( btnW, gbcPanel0 );
		pnPanel0.add( btnW );

		btnNeutral = new JButton( "Ntl"  );
		btnNeutral.setActionCommand( "NEUTRAL" );
		gbcPanel0.gridx = 6;
		gbcPanel0.gridy = 7;
		gbcPanel0.gridwidth = 3;
		gbcPanel0.gridheight = 3;
		gbcPanel0.fill = GridBagConstraints.BOTH;
		gbcPanel0.weightx = 1;
		gbcPanel0.weighty = 0;
		gbcPanel0.anchor = GridBagConstraints.NORTH;
		gbPanel0.setConstraints( btnNeutral, gbcPanel0 );
		pnPanel0.add( btnNeutral );

		btnE = new JButton( "E"  );
		btnE.setActionCommand( "E" );
		gbcPanel0.gridx = 10;
		gbcPanel0.gridy = 7;
		gbcPanel0.gridwidth = 3;
		gbcPanel0.gridheight = 3;
		gbcPanel0.fill = GridBagConstraints.BOTH;
		gbcPanel0.weightx = 1;
		gbcPanel0.weighty = 0;
		gbcPanel0.anchor = GridBagConstraints.NORTH;
		gbPanel0.setConstraints( btnE, gbcPanel0 );
		pnPanel0.add( btnE );

		btnSW = new JButton( "SW"  );
		btnSW.setActionCommand( "SW" );
		gbcPanel0.gridx = 2;
		gbcPanel0.gridy = 11;
		gbcPanel0.gridwidth = 3;
		gbcPanel0.gridheight = 3;
		gbcPanel0.fill = GridBagConstraints.BOTH;
		gbcPanel0.weightx = 1;
		gbcPanel0.weighty = 0;
		gbcPanel0.anchor = GridBagConstraints.NORTH;
		gbPanel0.setConstraints( btnSW, gbcPanel0 );
		pnPanel0.add( btnSW );

		btnS = new JButton( "S"  );
		btnS.setActionCommand( "S" );
		gbcPanel0.gridx = 6;
		gbcPanel0.gridy = 11;
		gbcPanel0.gridwidth = 3;
		gbcPanel0.gridheight = 3;
		gbcPanel0.fill = GridBagConstraints.BOTH;
		gbcPanel0.weightx = 1;
		gbcPanel0.weighty = 0;
		gbcPanel0.anchor = GridBagConstraints.NORTH;
		gbPanel0.setConstraints( btnS, gbcPanel0 );
		pnPanel0.add( btnS );

		btnSE = new JButton( "SE"  );
		btnSE.setActionCommand( "SE" );
		gbcPanel0.gridx = 10;
		gbcPanel0.gridy = 11;
		gbcPanel0.gridwidth = 3;
		gbcPanel0.gridheight = 3;
		gbcPanel0.fill = GridBagConstraints.BOTH;
		gbcPanel0.weightx = 1;
		gbcPanel0.weighty = 0;
		gbcPanel0.anchor = GridBagConstraints.NORTH;
		gbPanel0.setConstraints( btnSE, gbcPanel0 );
		pnPanel0.add( btnSE );

		lbCurrentPlayer = new JLabel( "E' il turno di: "+ ip);
		gbcPanel0.gridx = 1;
		gbcPanel0.gridy = 0;
		gbcPanel0.gridwidth = 13;
		gbcPanel0.gridheight = 3;
		gbcPanel0.fill = GridBagConstraints.BOTH;
		gbcPanel0.weightx = 1;
		gbcPanel0.weighty = 1;
		gbcPanel0.anchor = GridBagConstraints.NORTH;
		gbPanel0.setConstraints( lbCurrentPlayer, gbcPanel0 );
		pnPanel0.add( lbCurrentPlayer );

		setDefaultCloseOperation( DO_NOTHING_ON_CLOSE );
		
		setContentPane( pnPanel0 );
		pack();
		

	}
	public void addActionListener(ActionListener al) {
		this.btnNW.addActionListener(al);
		this.btnN.addActionListener(al);
		this.btnNE.addActionListener(al);
		this.btnW.addActionListener(al);
		this.btnNeutral.addActionListener(al);
		this.btnE.addActionListener(al);
		this.btnSW.addActionListener(al);
		this.btnS.addActionListener(al);
		this.btnSE.addActionListener(al);		
	}
	public Moves getMoves() {
		setVisible(true);
		return move;
	}
	private class MoveListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {				
			switch (e.getActionCommand()) {
			case "NW":
				move=Moves.NW;
				break;
			case "N":
				move=Moves.N;
				break;
			case "NE":
				move=Moves.NE;
				break;
			case "W":
				move=Moves.W;
				break;
			case "NEUTRAL":
				move=Moves.NEUTRAL;
				break;
			case "E":
				move=Moves.E;
				break;
			case "SW":
				move=Moves.SW;
				break;
			case "S":
				move=Moves.S;
				break;
			case "SE":
				move=Moves.SE;
				break;
			default:
				break;
			}
			setVisible(false);
		}
	}
	

}


