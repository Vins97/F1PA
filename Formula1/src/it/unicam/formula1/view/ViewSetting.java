/**
 * 
 */
package it.unicam.formula1.view;


import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.util.stream.IntStream;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


import it.unicam.formula1.model.CarType;
import it.unicam.formula1.model.ModelSetting;
import it.unicam.formula1.model.TrackType;


/**
 * @author Vincenzo Chiarella 23 feb 2019
 *
 */
public class ViewSetting extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5641711571804928912L;
	private static final Dimension SCREEN_DIMENSION = Toolkit.getDefaultToolkit().getScreenSize();

	private JComboBox<CarType> selectCar;
	private JComboBox<Integer> cmbIdPlayer;
	private JComboBox<TrackType> trackType;
	private JTextField tfPlayerName;
	private JButton enterButton;
	
	private JPanel pnPanel0;	
	
	private JButton startRace;
	private JLabel lbLabel1;
	private JLabel lbLabel2;
	private JLabel lbLabel3;
	private JLabel countPlayerToInsert;
	
	private ModelSetting ms;
	private int dialogWidth = SCREEN_DIMENSION.width / 9; //example; a quarter of the screen size
	private int dialogHeight = SCREEN_DIMENSION.height /9; //example
	private int dialogX = SCREEN_DIMENSION.width / 2 - dialogWidth / 2; //position right in the middle of the screen
	private int dialogY = SCREEN_DIMENSION.height / 2 - dialogHeight / 2;
	 
	
	public ViewSetting(ModelSetting ms) {
		this.ms = ms;
		this.setSize(500,500);
		setIconImage(new ImageIcon(getClass().getResource("SettingIcon.png").getPath()).getImage());	
		generateElement();
	}

	private void generateElement() {
		pnPanel0 = new JPanel();
		GridBagLayout gbPanel0 = new GridBagLayout();
		GridBagConstraints gbcPanel0 = new GridBagConstraints();
		pnPanel0.setLayout( gbPanel0 );

		
		selectCar = new JComboBox<CarType>();
		selectCar.setModel(new DefaultComboBoxModel<CarType>(CarType.values()));
		selectCar.setSelectedIndex(0);
		gbcPanel0.gridx = 2;
		gbcPanel0.gridy = 6;
		gbcPanel0.gridwidth = 1;
		gbcPanel0.gridheight = 1;
		gbcPanel0.fill = GridBagConstraints.BOTH;
		gbcPanel0.weightx = 1;
		gbcPanel0.weighty = 0;
		gbcPanel0.anchor = GridBagConstraints.NORTH;
		gbPanel0.setConstraints( selectCar, gbcPanel0 );
		pnPanel0.add( selectCar );

		
		Integer[] a = {1,2,3,4};
		cmbNumPlayer = new JComboBox<Integer>(a);
		gbcPanel0.gridx = 3;
		gbcPanel0.gridy = 2;
		gbcPanel0.gridwidth = 11;
		gbcPanel0.gridheight = 1;
		gbcPanel0.fill = GridBagConstraints.NONE;
		gbcPanel0.weightx = 1;
		gbcPanel0.weighty = 0;
		gbcPanel0.anchor = GridBagConstraints.CENTER;
		gbPanel0.setConstraints( cmbNumPlayer, gbcPanel0 );
		pnPanel0.add( cmbNumPlayer );
		
		countPlayerToInsert = new JLabel( "" + ms.getNumPlayerToInsert());
		gbcPanel0.gridx = 17;
		gbcPanel0.gridy = 2;
		gbcPanel0.gridwidth = 1;
		gbcPanel0.gridheight = 1;
		gbcPanel0.fill = GridBagConstraints.BOTH;
		gbcPanel0.weightx = 1;
		gbcPanel0.weighty = 1;
		gbcPanel0.anchor = GridBagConstraints.NORTH;
		gbPanel0.setConstraints( countPlayerToInsert, gbcPanel0 );
		pnPanel0.add( countPlayerToInsert );

		tfPlayerName = new JTextField( );
		gbcPanel0.gridx = 5;
		gbcPanel0.gridy = 6;
		gbcPanel0.gridwidth = 5;
		gbcPanel0.gridheight = 1;
		gbcPanel0.fill = GridBagConstraints.BOTH;
		gbcPanel0.weightx = 1;
		gbcPanel0.weighty = 0;
		gbcPanel0.anchor = GridBagConstraints.NORTH;
		gbPanel0.setConstraints( tfPlayerName, gbcPanel0 );
		pnPanel0.add( tfPlayerName );

		enterButton = new JButton( "Inserisci"  );
		gbcPanel0.gridx = 17;
		gbcPanel0.gridy = 6;
		gbcPanel0.gridwidth = 1;
		gbcPanel0.gridheight = 1;
		gbcPanel0.fill = GridBagConstraints.BOTH;
		gbcPanel0.weightx = 1;
		gbcPanel0.weighty = 0;
		gbcPanel0.anchor = GridBagConstraints.NORTH;
		gbPanel0.setConstraints( enterButton, gbcPanel0 );
		pnPanel0.add( enterButton );

		
		int[] ids= IntStream.range(1, 100).toArray();
		Integer[] getId = IntStream.of( ids ).boxed().toArray(Integer[] :: new);
		cmbIdPlayer = new JComboBox<Integer>( getId );
		gbcPanel0.gridx = 12;
		gbcPanel0.gridy = 6;
		gbcPanel0.gridwidth = 3;
		gbcPanel0.gridheight = 1;
		gbcPanel0.fill = GridBagConstraints.BOTH;
		gbcPanel0.weightx = 1;
		gbcPanel0.weighty = 0;
		gbcPanel0.anchor = GridBagConstraints.NORTH;
		gbPanel0.setConstraints( cmbIdPlayer, gbcPanel0 );
		pnPanel0.add( cmbIdPlayer );

		lbLabel1 = new JLabel( "Scuderia"  );
		gbcPanel0.gridx = 2;
		gbcPanel0.gridy = 4;
		gbcPanel0.gridwidth = 1;
		gbcPanel0.gridheight = 1;
		gbcPanel0.fill = GridBagConstraints.BOTH;
		gbcPanel0.weightx = 1;
		gbcPanel0.weighty = 1;
		gbcPanel0.anchor = GridBagConstraints.NORTH;
		gbPanel0.setConstraints( lbLabel1, gbcPanel0 );
		pnPanel0.add( lbLabel1 );

		lbLabel2 = new JLabel( "Nome"  );
		gbcPanel0.gridx = 5;
		gbcPanel0.gridy = 4;
		gbcPanel0.gridwidth = 5;
		gbcPanel0.gridheight = 1;
		gbcPanel0.fill = GridBagConstraints.BOTH;
		gbcPanel0.weightx = 1;
		gbcPanel0.weighty = 1;
		gbcPanel0.anchor = GridBagConstraints.NORTH;
		gbPanel0.setConstraints( lbLabel2, gbcPanel0 );
		pnPanel0.add( lbLabel2 );

		lbLabel3 = new JLabel( "ID"  );
		gbcPanel0.gridx = 12;
		gbcPanel0.gridy = 4;
		gbcPanel0.gridwidth = 3;
		gbcPanel0.gridheight = 1;
		gbcPanel0.fill = GridBagConstraints.BOTH;
		gbcPanel0.weightx = 1;
		gbcPanel0.weighty = 1;
		gbcPanel0.anchor = GridBagConstraints.NORTH;
		gbPanel0.setConstraints( lbLabel3, gbcPanel0 );
		pnPanel0.add( lbLabel3 );
		
		trackType = new JComboBox<>();
		trackType.setModel(new DefaultComboBoxModel<TrackType>(TrackType.values()));
		trackType.setSelectedIndex(0);
		gbcPanel0.gridx = 5;
		gbcPanel0.gridy = 10;
		gbcPanel0.gridwidth = 1;
		gbcPanel0.gridheight = 1;
		gbcPanel0.fill = GridBagConstraints.BOTH;
		gbcPanel0.weightx = 1;
		gbcPanel0.weighty = 0;
		gbcPanel0.anchor = GridBagConstraints.NORTH;
		gbPanel0.setConstraints( trackType, gbcPanel0 );
		pnPanel0.add( trackType );
		
		startRace = new JButton( "Inizia Corsa"  );
		gbcPanel0.gridx = 5;
		gbcPanel0.gridy = 15;
		gbcPanel0.gridwidth = 1;
		gbcPanel0.gridheight = 1;
		gbcPanel0.fill = GridBagConstraints.BOTH;
		gbcPanel0.weightx = 1;
		gbcPanel0.weighty = 0;
		gbcPanel0.anchor = GridBagConstraints.NORTH;
		gbPanel0.setConstraints( startRace, gbcPanel0 );
		pnPanel0.add( startRace );

		setDefaultCloseOperation( EXIT_ON_CLOSE );

		setContentPane( pnPanel0 );
		setTitle("Seleziona impostazioni ");
		pack();
		setBounds(dialogX, dialogY, dialogWidth, dialogHeight);
		setVisible( true );
	}
	public void addActionListenerNumPlayer(ActionListener a) {
		cmbNumPlayer.addActionListener(a);
	}
	public void addActionListenerPlayer(ActionListener a) {
		enterButton.addActionListener(a);
	}
	public void addActionListenerStartRace(ActionListener a) {
		startRace.addActionListener(a);
	}
	public void addActionListenerSelectTrack(ActionListener a) {
		trackType.addActionListener(a);
	}
	
	public void setVisibilityInsertNumberOfPlayer() {
		this.countPlayerToInsert.setVisible(false);		
		setVisibilityPlayerData(false);		
		this.trackType.setVisible(false);		
		this.startRace.setVisible(false);
	}
	
	public void setVisibilityPlayerData(boolean t) {
		this.countPlayerToInsert.setVisible(t);
		
		this.selectCar.setVisible(t);
		this.lbLabel1.setVisible(t);
		this.tfPlayerName.setVisible(t);
		this.lbLabel2.setVisible(t);
		this.cmbIdPlayer.setVisible(t);
		this.lbLabel3.setVisible(t);
		this.enterButton.setVisible(t);
	}
	public void setVisibilityAddInteractivePlayer() {
		this.cmbNumPlayer.setVisible(false);
		setVisibilityPlayerData(true);
	}
	public void setVisibilityChooseRaceAndStart() {
		setVisibilityPlayerData(false);
		this.trackType.setVisible(true);
		this.startRace.setVisible(true);
	}

	
	public JComboBox<Integer> getCmbNumPlayer() {
		return this.cmbNumPlayer;
	}
	
	public JComboBox<CarType> getSelectCar() {
		return this.selectCar;
	}
	
	public JComboBox<TrackType> getSelectTrack() {
		return this.trackType;
	}
	
	
	public JComboBox<Integer> getCmbIdPlayer() {
		return cmbIdPlayer;
	}
	public JLabel getPlayerCounter(){
		return this.countPlayerToInsert;
	}
	public void setNewCounter(int i) {
		countPlayerToInsert.setText(""+i);
	}
	
	public JTextField getTfPlayerName() {
		return tfPlayerName;
	}
	
	public JButton getEnterButton() {
		return enterButton;
	}
	private JComboBox<Integer> cmbNumPlayer;
	
	
	


}
