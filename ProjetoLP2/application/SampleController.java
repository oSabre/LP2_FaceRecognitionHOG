package application;

import java.io.File;
import java.net.MalformedURLException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import controle.Controlador;

public class SampleController{
	
	@FXML
	private Label lul;
	
	@FXML
	private Label situacao;
	
	@FXML
	private Label possible;
	
	@FXML
	private ImageView img1;
	
	@FXML
	private TextField input;
	
	
	@FXML
	private void handleButtonAction(ActionEvent event) {
		boolean tem_ou_n = false;
		
		FileChooser fileChooser = new FileChooser();
		FileChooser dataSetChooser = new FileChooser();
		
		fileChooser.setTitle("Escolha a imagem");
		fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("PNG", "*.png"));
		File file = fileChooser.showOpenDialog(null);
		
		dataSetChooser.setTitle("Escolha o data set");
		dataSetChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("CSV", "*.csv"));
		File file2 = dataSetChooser.showOpenDialog(null);
		
		try {
			String localUrl = file.toURI().toURL().toString();
			Image image = new Image(localUrl);
			img1.setImage(image);
		} catch (MalformedURLException e) {
			System.out.println("Problema com a URL da imagem.");
		} catch (NullPointerException z) {
			System.out.println("Nenhuma imagem foi escolhida.");
		}
		
		Controlador x = new Controlador();
		try {
			tem_ou_n = x.run(file.getAbsolutePath(), file2.getAbsolutePath(), Integer.parseInt(input.getText()));
		} catch (Exception e) {
			System.out.println("Ocorreu algum erro");
			situacao.setText("Situação: erro");
			lul.setText("Status: Desligado");
			possible.setText("--> Data set inválido\n--> Imagem nenhuma foi escolhida\n--> K inválido");
			return;
		}
		
		if(tem_ou_n) {
			possible.setText("");
			situacao.setText("Situação: normal");
			lul.setText("Status: Ligado");
		}else {
			possible.setText("");
			situacao.setText("Situação: normal");
			lul.setText("Status: Desligado");
		}
	}

	
	
}
