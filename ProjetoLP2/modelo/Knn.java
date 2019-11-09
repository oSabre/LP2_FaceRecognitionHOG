package modelo;

import java.util.ArrayList;
import java.util.List;


public class Knn {
	
	public boolean oKnn(int k, List<Float> sent_img, List<String[]> data_set) {
		int human = 0, notHuman = 0;
		float somatorio;
		float dif;
		float result;
		
		SelectSorter x = new SelectSorter();
		List<GuardaInfo> distances = new ArrayList<GuardaInfo>();
		
		//Calcula a distância euclidiana.
		for(int i = 0; i < data_set.size(); i++) {
			somatorio = 0;
			dif = 0;
			for(int j = 0; j < 999; j++) {
				dif = sent_img.get(j) - Float.parseFloat(data_set.get(i)[j]);
				dif = (float) Math.pow(dif, 2);
				somatorio = somatorio + dif;
			}
			result = (float) Math.sqrt(somatorio);
			distances.add(new GuardaInfo(data_set.get(i)[1000], result));
		}
	
		//Dá sort no distances para deixar os menores valores no inicio.
		distances = x.select_sort(distances, distances.size());
		
		//Incrementa o valor de Human ou notHuman pra retonar o correto
		for(int i = 0; i < k; i++) {
			if(distances.get(i).getE_ou_n().equals("person")) {
				human++;
			}else {
				notHuman++;
			}
		}
		
		//Pra caso o número K seja par e evita desempate. Ele entra mesmo human e not human sendo diferentes, mas não altera o resultado em caso algum
		if(k%2 == 0) {
			if(distances.get(0).getE_ou_n().contentEquals("person")) {
				human++;
			}else {
				notHuman++;
			}
		}
		
		if(human > notHuman) {
			System.out.println("Tem uma pessoa ai");
			return true;
		}else {
			System.out.println("Não tem uma pessoa ai");
			return false;
		}
	}
	
}
