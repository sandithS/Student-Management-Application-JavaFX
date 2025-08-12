package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;

public class LoginScreenController {
    public TextField txtUserName;
    public PasswordField txtPassword;
    public Button btnLogin;

    Stage stage = new Stage();

    public void btnLoginOnAction(ActionEvent actionEvent) {
        if(txtUserName.getText().matches("^[a-zA-Z]+$") && txtPassword.getText().matches("\\d+")){
            try {
                stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/student_registration_form.fxml"))));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            stage.show();
        }else {
            JOptionPane.showMessageDialog(null,"Invalid information");
        }
    }
}
