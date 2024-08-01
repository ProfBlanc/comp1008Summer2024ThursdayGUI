package ca.georgiancollege.comp1008summer2024thursdaygui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class LoginController {

    @FXML
    private TextField txtEmail;

    @FXML
    private Label txtError;

    @FXML
    private PasswordField txtPass;


    @FXML
    void initialize(){

        txtError.setText("");

    }

    @FXML
    void onForgotPasswordClick(MouseEvent event) {

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("How could you?");
        alert.setContentText("Forget your password? Where is your head?!");
        alert.show();
    }

    @FXML
    void onLoginClick(ActionEvent event) {

        if(txtEmail.getText().equals("admin") && txtPass.getText().equals("pass")){
            System.out.println("CONGRATS");
        }
        else{
            txtError.setText("Invalid username or password");
        }
    }

    @FXML
    void onRegisterClick(ActionEvent event) {

        System.out.println("To be implemented");

    }

}
