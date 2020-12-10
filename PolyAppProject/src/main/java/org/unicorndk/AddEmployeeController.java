package org.unicorndk;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddEmployeeController {

    @FXML
    private TextField firstNameField;

    @FXML
    private Button okButton;

    @FXML
    private TextField lastNameField;

    @FXML
    private TextField middleNameField;

    @FXML
    private TextField positionField;

    @FXML
    void CloseAction(ActionEvent event) {
        if (firstNameField.getText().length() != 0
            && lastNameField.getText().length() != 0
            && middleNameField.getText().length() != 0
            && positionField.getText().length() != 0){

            String newText = firstNameField.getText() + ";"
                    + lastNameField.getText() + ";"
                    + middleNameField.getText() + ";"
                    + positionField.getText();

            Buffer.setTextBuffer(newText);

            Stage currentStage = (Stage) okButton.getScene().getWindow();
            currentStage.close();
        }

    }

}
