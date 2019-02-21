/**
 * 
 */
package it.unicam.formula1.model;


/**
 * @author Vincenzo Chiarella 17 feb 2019
 *
 */
public class PlayerFactory {
	
	public Player getPlayer(String type,CarType c,String nome,int id) {
		PlayerFactory pf = new PlayerFactory();
		switch(type) {
			case "rdm":
				return new RandomPlayer(RandomUtils.randomEnum(CarType.class),"",RandomUtils.randomNumber(100));
			case "itr":
				return new InteractivePlayer(c,nome,id);
			default:
				return null;
		}
	}

}
