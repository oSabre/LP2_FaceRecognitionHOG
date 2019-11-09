package modelo;

import java.util.List;

public class SelectSorter {
	
	public List<GuardaInfo> select_sort(List<GuardaInfo> x, int size) {
		for(int indice = 0; indice < size; indice++) {
			int indiceMenor = indice;
			for(int indiceSeguinte = indice + 1; indiceSeguinte < size; indiceSeguinte++) {
				if(x.get(indiceSeguinte).getDist() < x.get(indiceMenor).getDist()) {
					indiceMenor = indiceSeguinte;
				}
			}
			GuardaInfo aux = x.get(indice);
			x.set(indice, x.get(indiceMenor));
			x.set(indiceMenor, aux);
		}
		return x;
	}
}
