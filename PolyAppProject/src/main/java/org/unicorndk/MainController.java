package org.unicorndk;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class MainController {
    String textBuffer = "";
    @FXML
    private TextField firstOperationField;

    @FXML
    private Button okButton;

    @FXML
    public TextArea outputTextArea;

    @FXML
    private Button helpButton;

    @FXML
    private Button aboutButton;

    @FXML
    void initialize() {
        outputTextArea.appendText("Добро пожаловать в PolyApp! \n");
        printMessage();
    }

    @FXML
    void AboutAction(ActionEvent event) {
        outputTextArea.appendText("\nАвтор: Коробов Артур Эдуардович. \nГруппа: ИС18-1. \n\n");
    }

    @FXML
    void HelpAction(ActionEvent event) {
        printMessage();
    }

    @FXML
    void OkAction(ActionEvent event) throws IOException {
        outputTextArea.appendText("\n");

        if (firstOperationField.getText().length() != 0) {
            Buffer.setTextBuffer("");

            String operation = firstOperationField.getText().toLowerCase();

            switch (operation){
                case "добавить":
                    outputTextArea.appendText(">" + operation + "\n");

                    openAddEmployeeWindow();

                    String[] params = Buffer.getTextBuffer().split(";");
                    String firstName = params[0];
                    String lastName = params[1];
                    String middleName = params[2];
                    String position = params[3];

                    App.dbHandler.addEmployee(firstName, lastName, middleName, position);

                    firstOperationField.clear();
                    break;

                case "список":
                    outputTextArea.appendText(">" + operation + "\n");

                    App.dbHandler.printAllEmployees();

                    firstOperationField.clear();
                    break;

                case "удалить":
                    outputTextArea.appendText(">" + operation + "\n");

                    openRemoveEmployeeWindow();

                    textBuffer = Buffer.getTextBuffer();

                    int idRemove = Integer.parseInt(textBuffer.trim());

                    App.dbHandler.getAndRemoveEmployee(idRemove);

                    firstOperationField.clear();
                    break;

                case "найти":
                    outputTextArea.appendText(">" + operation + "\n");

                    openGetEmployeeWindow();

                    textBuffer = Buffer.getTextBuffer();

                    int idGet = Integer.parseInt(textBuffer.trim());

                    App.dbHandler.getEmployee(idGet);

                    firstOperationField.clear();
                    break;

                case "экспорт":
                    outputTextArea.appendText(">" + operation + "\n");

                    App.dbHandler.exportAllEmployees();

                    firstOperationField.clear();
                    break;

                default:
                    outputTextArea.appendText("[ERROR] Такой команды нет в списке команд! \n");

                    firstOperationField.clear();
                    break;
            }

        }
        else {
            outputTextArea.appendText("[WARNING] Вы не ввели команду! \n");
        }
    }

    public void openAddEmployeeWindow() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AddEmployeeWindow.fxml"));
        Parent root = loader.load();

        AddEmployeeController newWindow = loader.getController();

        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(new Scene(root));
        stage.setTitle("");
        stage.setResizable(false);
        stage.showAndWait();
    }

    public void openRemoveEmployeeWindow() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("RemoveEmployeeWindow.fxml"));
        Parent root = loader.load();

        RemoveEmployeeController newWindow = loader.getController();

        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(new Scene(root));
        stage.setTitle("");
        stage.setResizable(false);
        stage.showAndWait();
    }

    public void openGetEmployeeWindow() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("GetEmployeeWindow.fxml"));
        Parent root = loader.load();

        GetEmployeeController newWindow = loader.getController();

        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(new Scene(root));
        stage.setTitle("");
        stage.setResizable(false);
        stage.showAndWait();
    }

    public void printMessage() {
        outputTextArea.appendText("Управление программой происходит с помощью выполнения нужной команды. \n");
        outputTextArea.appendText("\n");
        outputTextArea.appendText("Доступные команд: \n");
        outputTextArea.appendText("список - Вывести список сотрудников \n");
        outputTextArea.appendText("экспорт - Экспорт списка сотрудников в файл \n");
        outputTextArea.appendText("добавить - Добавить сотрудника в БД \n");
        outputTextArea.appendText("удалить - Удалить сотрудника по ID \n");
        outputTextArea.appendText("найти - Найти сотрудника по ID \n");
        outputTextArea.appendText("\nВведите команду...");
    }
}





































