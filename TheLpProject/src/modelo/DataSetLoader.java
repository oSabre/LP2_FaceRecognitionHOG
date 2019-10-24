package modelo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DataSetLoader {
	
	public List<String[]> load_em(){
		String fileName = "C:\\Users\\user\\Downloads\\Lp2\\dataset.csv";
		File file = new File(fileName);
		List<String[]> sera = new ArrayList<>();
		try {
			Scanner inputStream = new Scanner(file);
			while(inputStream.hasNext()) {
				String data = inputStream.next(); // gets the whole line
				String[] valores = data.split(",");
				sera.add(valores);
			}
			inputStream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		sera.remove(0);
		return sera;
	}
}
