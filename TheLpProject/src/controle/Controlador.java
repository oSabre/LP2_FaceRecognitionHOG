package controle;

import java.util.List;

import modelo.DataSetLoader;
import modelo.HOGExtractor;
import modelo.Knn;

public class Controlador {
	
	public void run() {
		List<Float> sent_image; //Vai receber a imagem que eu quiser
		List<String[]> data_set; //Vai receber o data set
		HOGExtractor extract = new HOGExtractor(); 
		DataSetLoader loader = new DataSetLoader();
		Knn letsee = new Knn();
		sent_image = extract.extraction(); //carrega o vetor de imagem transformado, depois vou mudar pra recber endereço
		data_set = loader.load_em(); //Carrega o Data set
		letsee.oKnn(5, sent_image, data_set);
		
	}
}
