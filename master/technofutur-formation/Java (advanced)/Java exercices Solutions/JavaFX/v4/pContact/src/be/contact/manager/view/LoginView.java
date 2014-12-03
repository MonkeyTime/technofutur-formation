package be.contact.manager.view;

import be.contact.manager.control.ContactController;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.*;
import javafx.stage.Stage;
import javafx.*;

public class LoginView extends GridPane {

	private Label loginLbl;
	private Label passwordLbl;
	private TextField loginField;
	private PasswordField passwordField;
	private Button LoginBt;
	
	private ContactController cc;
	
	public LoginView(ContactController cc) {
		this.cc = cc;
		
		this.setPadding(new Insets(20));
		this.setHgap(5);
		this.setVgap(3);
		
		init();
	}

	public void init() {
		this.add(getLoginLbl(), 0, 0); // col / row
		this.add(getLoginField(), 1, 0);
		this.add(getPasswordLbl(), 0, 1);
		this.add(getPasswordField(), 1, 1);
		this.add(getLoginBt(), 0, 2);
		
		GridPane.setConstraints(getLoginBt(), 0, 2, 2, 2, HPos.CENTER, VPos.CENTER,
				Priority.ALWAYS, Priority.ALWAYS, new Insets(0));
		
	}

	public Label getLoginLbl() {
		if(loginLbl==null) {
			loginLbl = new Label("Login :");
		}
		return loginLbl;
	}

	public Label getPasswordLbl() {
		if(passwordLbl==null) {
			passwordLbl = new Label("Password :");
		}
		return passwordLbl;
	}

	public TextField getLoginField() {
		if(loginField==null) {
			loginField = new TextField();
			loginField.setPromptText("votre login...");
		}
		return loginField;
	}

	public PasswordField getPasswordField() {
		if(passwordField==null) {
			passwordField = new PasswordField();
		}
		return passwordField;
	}

	public Button getLoginBt() {
		if(LoginBt==null) {
			LoginBt = new Button("Login");
			LoginBt.setPrefWidth(150);
			
			LoginBt.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

				@Override
				public void handle(MouseEvent event) {
					String login = getLoginField().getText();
					String password = getPasswordField().getText();
					if(!login.isEmpty() && !password.isEmpty() ) {
						LoginView.this.cc.loginUser(login, password);
					}
				}
				
			});
		}
		return LoginBt;
	}
	
	
}
