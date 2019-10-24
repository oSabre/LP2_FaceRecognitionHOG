package visão;

import java.io.IOException;
import org.opencv.core.Core;
import controle.Controlador;


public class Vision {
	public static void main(String[] args) throws IOException {
		
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		Controlador controle = new Controlador();
		controle.run();
	
	}
}


