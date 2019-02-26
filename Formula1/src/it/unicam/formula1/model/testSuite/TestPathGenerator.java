/**
 * 
 */
package it.unicam.formula1.model.testSuite;


import java.net.URL;

import org.junit.jupiter.api.Test;

import it.unicam.formula1.model.PathGeneratorFromTxtCsv;

/**
 * @author Vincenzo Chiarella 26 feb 2019
 *
 */
class TestPathGenerator {

	@Test
	void testPath() {
		URL url = getClass().getResource("Strange.txt");
		PathGeneratorFromTxtCsv p = new PathGeneratorFromTxtCsv(url.getPath());
		p.getPath().forEach(System.out::println);
	}
	@Test
	void testFindAsph() {
		URL url = getClass().getResource("Strange.txt");
		PathGeneratorFromTxtCsv p = new PathGeneratorFromTxtCsv(url.getPath());
	}

}
