package ca.georgiancollege.comp1008summer2024thursdaygui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public class LoginController {

    @FXML
    private TextField txtEmail;

    @FXML
    private Label txtError;

    @FXML
    private PasswordField txtPass;

    private LoginModel model = new LoginModel();
    private StringBuilder sb = new StringBuilder();


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
        txtError.setText("");

        try{
            if(model.processLoginRequest(txtEmail.getText(), txtPass.getText())){
                System.out.println("successfully logged in");
            }
            else{
                System.err.println("Incorrect login");
            }
        }
        catch(Exception e){
            txtError.setText(e.getMessage());
        }


//        if(txtEmail.getText().equals("admin") && txtPass.getText().equals("pass")){
//            System.out.println("CONGRATS");
//        }
//        else{
//            txtError.setText("Invalid username or password");
//        }
    }

    @FXML
    void onRegisterClick(ActionEvent event) {

        txtError.setText("");
        try{
            model.processRegisterRequest(txtEmail.getText(), txtPass.getText());
        }
        catch (Exception e){
            txtError.setText(e.getMessage());
        }

    }


    @FXML
    void onMouseEntered(MouseEvent event) {
        System.out.print("Mouse Entered on Node: ");

        Button btn = (Button) event.getSource();
        System.out.println(btn.getText());
    }

    @FXML
    void onMouseExited(MouseEvent event) {
        System.out.print("Mouse Exited on Node: ");

        Button btn = (Button) event.getSource();
        System.out.println(btn.getText());

    }

    @FXML
    void onKeyTyped(KeyEvent event) {

        System.out.println(event.getText());
        System.out.println(event.getCode());
        System.out.println(event.getCode().getCode());
        System.out.println("*".repeat(10));

        int keyCode = event.getCode().getCode();

        if(keyCode >= 65 && keyCode <= 90 || keyCode >= 48 && keyCode <= 57){
            //sb.setLength(0);
//            try{
//                if(keyCode >= 48 && keyCode <= 57 && !event.getText().equals("@")){}
//                    Integer.parseInt(event.getText());
//            }
//            catch (Exception e){
//                txtEmail.setText(sb.toString());
//                txtEmail.positionCaret(sb.toString().length());
//
//            }
            sb.append(event.getText()); //append the character
        }
        else if(keyCode == 37 || keyCode == 38 || keyCode == 8|| keyCode == 16){}
        else{
            txtEmail.setText(sb.toString());
            txtEmail.positionCaret(sb.toString().length());
        }

    }

}
