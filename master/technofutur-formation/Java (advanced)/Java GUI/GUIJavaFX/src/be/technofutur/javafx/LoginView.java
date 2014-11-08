package be.technofutur.javafx;

import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class LoginView extends GridPane {

	private Label loginLabel;
	private Label pwdLabel;
	private TextField loginField;
	private PasswordField pwdField;
	private Button loginBtn;
	
	public LoginView() {
		
		setMargin(this, new Insets(25));
		this.setHgap(10);
		this.setVgap(8);
		
		this.init();
	}

	private void init() {
		
		this.add(this.getLoginLabel(), 0, 0);
		this.add(this.getLoginField(), 1, 0);
		this.add(this.getPwdLabel(), 0, 1);
		this.add(this.getPwdField(), 1, 1);
		this.add(this.getLoginBtn(), 0, 2);
	}

	public Label getLoginLabel() {
		
		if(this.loginLabel == null) {
			this.loginLabel = new Label("Login: ");
		}
		
		return loginLabel;
	}

	public Label getPwdLabel() {
		
		if(this.pwdLabel == null) {
			this.pwdLabel = new Label("Password: ");
		}
		
		return pwdLabel;
	}

	public TextField getLoginField() {
		
		if(this.loginField == null) {
			this.loginField = new TextField();
			this.loginField.setPromptText("votre login...");
		}
		
		return loginField;
	}

	public PasswordField getPwdField() {
		
		if(this.pwdField == null) {
			this.pwdField = new PasswordField();
		}
		
		return pwdField;
	}

	public Button getLoginBtn() {
		
		if(this.loginBtn == null) {
			this.loginBtn = new Button("Login");
		}
		
		return loginBtn;
	}
}
