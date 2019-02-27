/**
 * 
 */
package it.unicam.formula1.model.testSuite;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import it.unicam.formula1.SettingPanel;
import it.unicam.formula1.model.CarType;
import it.unicam.formula1.model.InteractivePlayer;



/**
 * @author Vincenzo Chiarella 26 feb 2019
 *
 */
class SettingsTest {

	@Test
	void testNumPlayer() {
		SettingPanel sp = new SettingPanel();
		assertTrue(sp.getCs().getMs().getnPlayer()==1);
	}
	@Test
	void testListPlayer() {
		SettingPanel sp = new SettingPanel();
		sp.getCs().getMs().addNewPlayer(CarType.FERRARI, "Vins",5);
		assertTrue(!sp.getCs().getMs().getP().isEmpty());
	}

}
