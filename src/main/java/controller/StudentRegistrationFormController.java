package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import model.Student;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class StudentRegistrationFormController implements Initializable {
    public RadioButton btnMale;
    public RadioButton btnFemale;
    public ToggleGroup group1;
    public Button btnSubmit;
    public ComboBox<String> btnCourses;
    public TextField txtFullName;
    public TextField txtEmail;
    public Button btnReset;
    public Button btnViewDetails;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        group1 = new ToggleGroup();
        btnMale.setToggleGroup(group1);
        btnFemale.setToggleGroup(group1);

        btnCourses.getItems().addAll("ICM", "ICD", "ICP");

    }

    public void btnSubmitOnAction(ActionEvent actionEvent) {

        RadioButton selectedRadioButton = (RadioButton) group1.getSelectedToggle();

        String fullName = txtFullName.getText();
        String email = txtEmail.getText();
        String gender = "";
        if (group1.getSelectedToggle() != null) {
            gender = selectedRadioButton.getText();
        }
        String course = btnCourses.getValue();

        if (fullName.isEmpty() || email.isEmpty() || gender.isEmpty() || course == null) {
            JOptionPane.showMessageDialog(null, "Please enter all details");
        } else {
            if(fullName.matches("^[a-zA-Z]+$") && email.contains("@")) {
                Student student = new Student(fullName, email, gender, course);
                System.out.println(student);
                JOptionPane.showMessageDialog(null, "Added Success");
            }else {
                JOptionPane.showMessageDialog(null, "Invalid information");
            }
        }

    }

    public void btnResetOnAction(ActionEvent actionEvent) {
        txtFullName.clear();
        txtEmail.clear();
        btnCourses.setValue(null);
        group1.selectToggle(null);
    }

    Stage stage = new Stage();

    public void btnViewDetailsOnAction(ActionEvent actionEvent) {

        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/summary_screen.fxml"))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stage.show();
    }
}
