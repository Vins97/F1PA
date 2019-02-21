/**
 * 
 */
package it.unicam.formula1.model;

import java.security.SecureRandom;

/**
 * @author Vincenzo Chiarella 17 feb 2019
 *
 */
public class RandomUtils {
	private static final SecureRandom random = new SecureRandom();
	public static <T extends Enum<?>> T randomEnum(Class<T> e) {		
		int i = random.nextInt(e.getEnumConstants().length);
		return e.getEnumConstants()[i];
	}
	public static int randomNumber(int range) {
		return random.nextInt(range);
	}
}
