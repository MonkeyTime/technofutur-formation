package be.contact.manager.main;

import be.contact.manager.control.ContactController;
import be.contact.manager.view.LoginView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class LaunchContact extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		ContactController cc = new ContactController(primaryStage);
		cc.startApp();
		
		//Scene root = new Scene(new LoginView());
		//primaryStage.setScene(root);
		//primaryStage.show();
		//primaryStage.setFullScreen(true);
	}

	

}
