package view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Frame extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		Parent root = FXMLLoader.load(getClass().getResource("/view/StartView.fxml"));

		Scene scene = new Scene(root);

		primaryStage.setScene(scene);
		primaryStage.setTitle("FIBA statistics");
		primaryStage.show();
	}
	
	public static void main (String[] args)
	{
		launch(args);
	}
}
