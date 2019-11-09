package controle;

import java.util.List;

import modelo.DataSetLoader;
import modelo.HOGExtractor;
import modelo.Knn;

public class Controlador {
	
	public boolean run(String x, String z, int k) throws Exception{
		boolean retorno = false;
		List<Float> sent_image; //Vai receber a imagem que eu quiser
		List<String[]> data_set; //Vai receber o data set
		
		HOGExtractor extract = new HOGExtractor(); 
		DataSetLoader loader = new DataSetLoader();
		
		Knn letsee = new Knn();
		sent_image = extract.extraction(x); //carrega o vetor de imagem transformado
		data_set = loader.load_em(z); //Carrega o Data set
		
		if(k > 100) {
			Exception e = new Exception();
			throw e;
		}
		
		retorno = letsee.oKnn(k, sent_image, data_set);
		
		return retorno;
	}
}
