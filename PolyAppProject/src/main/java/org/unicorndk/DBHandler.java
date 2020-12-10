package org.unicorndk;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

public class DBHandler extends Configs {
    Connection dbConnection;

    public Connection getDbConnection() throws ClassNotFoundException, SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName;

            dbConnection = DriverManager.getConnection(url, dbUser, dbPassword);

        } catch (Exception e) {
            e.printStackTrace();
        }



        return dbConnection;
    }


    public void addEmployee(String firstName, String lastName, String middleName, String position) {
        String insert = "INSERT INTO "
                + Const.EMPLOYEES_TABLE + "("
                + Const.FIRST_NAME + ","
                + Const.LAST_NAME + ","
                + Const.MIDDLE_NAME + ","
                + Const.POSITION + ")"
                + "VALUES(?,?,?,?)";

        try {
            PreparedStatement prst = getDbConnection().prepareStatement(insert);

            prst.setString(1, firstName);
            prst.setString(2, lastName);
            prst.setString(3, middleName);
            prst.setString(4, position);

            prst.executeUpdate();

            String message = "Новый сотрудник успешно добавлен!";
            App.textArea.appendText(message);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    public void get5Employee(int _id){
        ResultSet resultSet = null;

        String select = "SELECT "
                + "FROM "
                + Const.EMPLOYEES_TABLE
                + " WHERE "
                + Const.ID
                + "=?";

        try {
            PreparedStatement statement = getDbConnection().prepareStatement(select);

            System.out.println(resultSet);
            int id = resultSet.getInt(Const.ID);

            String firstName = resultSet.getString(Const.FIRST_NAME);
            String lastName = resultSet.getString(Const.LAST_NAME);
            String middleName = resultSet.getString(Const.MIDDLE_NAME);
            String position = resultSet.getString(Const.POSITION);

            resultSet = statement.executeQuery();

            String message = String.format("%d. Имя: %-15s \t Фамилия: %-15s \t Отчество: %-15s \t Должность: %-15s \n", id, firstName, lastName, middleName, position);;
            App.textArea.appendText(message);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void removeEmployee(int id){
        String select = "DELETE "
                + "FROM "
                + Const.EMPLOYEES_TABLE
                + " WHERE "
                + Const.ID
                + "=?";

        try {
            PreparedStatement prst = getDbConnection().prepareStatement(select);

            prst.setString(1, String.valueOf(id));

            int resultSet = prst.executeUpdate();

            String message = String.format("Сотрудник %d успешно удален! \n", id);
            App.textArea.appendText(message);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void getAndRemoveEmployee(int _id) {
        Statement statement = null;
        try {
            statement = getDbConnection().createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT * FROM " + Const.EMPLOYEES_TABLE + " WHERE ID = " + String.valueOf(_id));

            while (resultSet.next()) {
                removeEmployee(_id);

                return;
            }

            String message = "Информация о сотруднике не найдена. \n";
            App.textArea.appendText(message);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void getEmployee(int _id) {
        Statement statement = null;
        try {
            statement = getDbConnection().createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT * FROM " + Const.EMPLOYEES_TABLE + " WHERE ID = " + String.valueOf(_id));

            while (resultSet.next()) {
                int id = resultSet.getInt("ID");
                String firstName = resultSet.getString(Const.FIRST_NAME);
                String lastName = resultSet.getString(Const.LAST_NAME);
                String middleName = resultSet.getString(Const.MIDDLE_NAME);
                String position = resultSet.getString(Const.POSITION);

                String message = String.format("%d. Имя: %-15s \t Фамилия: %-15s \t Отчество: %-15s \t Должность: %-15s \n", id, firstName, lastName, middleName, position);
                App.textArea.appendText(message);

                return;

            }

            String message = "Информация о сотруднике не найдена. \n";
            App.textArea.appendText(message);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void printAllEmployees() {
        Statement statement = null;
        try {
            statement = getDbConnection().createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT * FROM " + Const.EMPLOYEES_TABLE);

            while (resultSet.next()) {
                int id = resultSet.getInt("ID");
                String firstName = resultSet.getString(Const.FIRST_NAME);
                String lastName = resultSet.getString(Const.LAST_NAME);
                String middleName = resultSet.getString(Const.MIDDLE_NAME);
                String position = resultSet.getString(Const.POSITION);

                String message = String.format("%d. Имя: %-15s \t Фамилия: %-15s \t Отчество: %-15s \t Должность: %-15s \n", id, firstName, lastName, middleName, position);
                App.textArea.appendText(message);

            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void exportAllEmployees() {
        try {
            PrintWriter printWriter = new PrintWriter(getFile());
            Statement statement = null;
            statement = getDbConnection().createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT * FROM " + Const.EMPLOYEES_TABLE);

            while (resultSet.next()) {
                int id = resultSet.getInt("ID");
                String firstName = resultSet.getString(Const.FIRST_NAME);
                String lastName = resultSet.getString(Const.LAST_NAME);
                String middleName = resultSet.getString(Const.MIDDLE_NAME);
                String position = resultSet.getString(Const.POSITION);


                String newString = String.format("%d. Имя: %-15s \t Фамилия: %-15s \t Отчество: %-15s \t Должность: %-15s \n", id, firstName, lastName, middleName, position);

                printWriter.println(newString);

                String message = "Новая запись успешно экспортирована! \n";
                App.textArea.appendText(message);
            }

            String message = "Экспорт списка успешно завершен! \n";
            App.textArea.appendText(message);

            printWriter.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public File getFile(){
        File file = null;
        try {
            file = new File("employees_list.txt");

            if (!file.exists()){
                file.createNewFile();
            }

        } catch ( IOException e) {
            String message = "Произошла ошибка при попытке открыть/создать файл! \n";
            App.textArea.appendText(message);
        }
        return file;
    }
}
