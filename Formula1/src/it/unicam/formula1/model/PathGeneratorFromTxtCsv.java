/**
 * 
 */
package it.unicam.formula1.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import java.util.List;
import java.util.function.Function;

import java.util.stream.Collectors;


/**
 * @author Vincenzo Chiarella 25 feb 2019
 *
 */
public class PathGeneratorFromTxtCsv {
	private List<Asphalt> path;

	
	public PathGeneratorFromTxtCsv(String path) {
		processPathFile(path);
 	}
	


	public List<Asphalt> getPath() {
		return this.path;
	}

	private void processPathFile(String inputPath){		
		try {
			File inputF = new File(inputPath);
			InputStream inStream = new FileInputStream(inputF);
			try(BufferedReader br = new BufferedReader( new InputStreamReader(inStream))){
				this.path = br.lines()
						.map(searchForAsphalts)
						.filter(a -> a != null)
						.distinct()
						.collect(Collectors.toList());
			}catch (IOException e) {			
			}			
		}catch(IOException e) {			
		}		
	}
	
	
	//converte le stringhe dalla input stream a int utili per la rappresentazione grafica
	private Function<String,Integer> parser = (db)-> {
		double dd= Double.parseDouble(db);
		return (int)  Math.round(dd);
		};
	//separa i tipi di elemento (asfalto,stratinggrid,checkpoint)
	private Function<String,Asphalt> searchForAsphalts = (line) -> {
		String[] p = line.split(", ");
		int layerNumber=Integer.parseInt(p[2]);
		Asphalt a = new Asphalt(parser.apply(p[0]),parser.apply(p[1]));
		if(layerNumber==0) {
			return a;
			}
		else if (layerNumber==1) {
			a.setStartPoint();
			return a;
		}
		else if(layerNumber>1&&layerNumber<=5) {
			a.setId(layerNumber-2);
			return a;
		}
		else {
			return null;
		}
	};


}
