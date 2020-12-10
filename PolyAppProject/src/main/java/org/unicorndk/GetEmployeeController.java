package org.unicorndk;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class GetEmployeeController {

    @FXML
    private TextField inputField;

    @FXML
    private Button okButton;

    @FXML
    void CloseWindow(ActionEvent event) {
        if (inputField.getText().length() != 0){

            String newText = inputField.getText();

            Buffer.setTextBuffer(newText);

            Stage currentStage = (Stage) okButton.getScene().getWindow();
            currentStage.close();
        }
    }

}
