/**
 * 
 */
package it.unicam.formula1;

import it.unicam.formula1.controller.ControlSetting;

import it.unicam.formula1.model.ModelSetting;
import it.unicam.formula1.view.ViewSetting;


/**
 * @author Vincenzo Chiarella 23 feb 2019
 *
 */
public class SettingPanel {
	private ModelSetting ms;
	private ViewSetting vs;
	private ControlSetting cs;
	
	public SettingPanel(){
		this.ms = new ModelSetting();
		this.vs= new ViewSetting(ms);
		this.cs = new ControlSetting(ms,vs);		
	}
	public ControlSetting getCs() {
		return cs;
	}
	
	public void setCs(ControlSetting cs) {
		this.cs = cs;
	}
	
	
}
