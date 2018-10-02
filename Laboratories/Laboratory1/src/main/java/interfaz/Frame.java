package interfaz;

import java.io.File;
import java.io.IOException;

import controller.Controller;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import model.FileWithNoSetSizeException;
import model.FileWithNotNumbersSet;
import model.Model;

public class Frame extends Application {
	
	@Override
	public void start(Stage primaryStage) throws Exception 
	{
		Parent root = FXMLLoader.load(getClass().getResource("/view/inicio.fxml"));
		
		Scene scene = new Scene(root);
		
		primaryStage.setScene(scene);
		primaryStage.show();
		

	}
	
	public static void main (String[] args)
	{
		launch(args);
	}

	
	
}
