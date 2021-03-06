package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import view.Controller;

public class SongLib extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {

		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(
				getClass().getResource("/view/SongGUI.fxml"));  // Set loader to FXML file when finished
		
		AnchorPane root = (AnchorPane)loader.load();
		//BorderPane root = (BorderPane)loader.load(); // Loads the main layout from FXML
		//Main layout is not necessarily a BorderPane it is just a PLACE HOLDER
		
		Controller controller = loader.getController();
		controller.start();
		
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.show();
		
	}
	
	public static void main(String[] args) {
		
		launch(args);
	}

}
