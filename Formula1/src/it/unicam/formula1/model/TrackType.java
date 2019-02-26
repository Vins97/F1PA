/**
 * 
 */
package it.unicam.formula1.model;



/**
 * @author Vincenzo Chiarella 26 feb 2019
 *
 */
public enum TrackType {
	Strange("Strange.txt");
	
	private String fileName;
	TrackType(String filename){		
		this.fileName=filename;
	}
	public String getUrl() {
		return getClass().getResource(fileName).getPath();
	}

}
