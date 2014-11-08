package be.technofutur.javafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		Scene root = new Scene(new LoginView());
		primaryStage.setScene(root);
		primaryStage.show();
		primaryStage.centerOnScreen();
		//primaryStage.setFullScreen(true);
	}
}
