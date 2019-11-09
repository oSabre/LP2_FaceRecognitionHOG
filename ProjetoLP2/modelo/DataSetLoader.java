package modelo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DataSetLoader {
	
	public List<String[]> load_em(String z){
		String fileName = z;
		File file = new File(fileName);
		List<String[]> valoresDataSet = new ArrayList<>();
		try {
			Scanner inputStream = new Scanner(file);
			while(inputStream.hasNext()) {
				String data = inputStream.next(); // gets the whole line
				String[] valores = data.split(",");
				valoresDataSet.add(valores);
			}
			inputStream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		valoresDataSet.remove(0);
		return valoresDataSet;
	}
}
