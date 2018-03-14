package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Controller {
    public Button bMain, bRegistration, bPerInfo, bRecords;
    @FXML
    public TextField campusId, password;
    @FXML
    public Button loginB;
    @FXML
    public Label userPassWrong;
    @FXML
    private Label Hiname;
    @FXML
    public Label gpaText, degreeText;


    java.sql.Connection conn = null;
    ResultSet rs = null;
    Statement st;



    @FXML
    private void mainBClicked(ActionEvent event) throws IOException {
        Stage stage;
        Parent root;
        stage=(Stage) ((Button)(event.getSource())).getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Main Menu");
        stage.show();

    }
    @FXML
    private void recordsBClicked(ActionEvent event) throws IOException {
        Stage stage;
        Parent root;
        stage=(Stage) ((Button)(event.getSource())).getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("Records.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Records Menu");
        stage.show();
    }
    @FXML
    private void infoBClicked(ActionEvent event) throws IOException {
        Stage stage;
        Parent root;
        stage=(Stage) ((Button)(event.getSource())).getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("PersonalInfo.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Personal Information Menu");
        stage.show();
    }
    @FXML
    private void registrationBClicked(ActionEvent event) throws IOException {
        Stage stage;
        Parent root;
        stage=(Stage) ((Button)(event.getSource())).getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("Registration.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Registration Menu");
        stage.show();
    }
    @FXML
    private void mainHClicked(ActionEvent event) throws IOException {
        Stage stage;
        Parent root;
        stage=(Stage) ((Hyperlink)(event.getSource())).getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Main Menu");
        stage.show();

    }
    @FXML
    private void recordsHClicked(ActionEvent event) throws IOException {
        Stage stage;
        Parent root;
        stage=(Stage) ((Hyperlink)(event.getSource())).getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("Records.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Records Menu");
        stage.show();
    }
    @FXML
    private void perInfoHClicked(ActionEvent event) throws IOException {
        Stage stage;
        Parent root;
        stage=(Stage) ((Hyperlink)(event.getSource())).getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("PersonalInfo.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Personal Information Menu");
        stage.show();
    }
    @FXML
    private void registrationHClicked(ActionEvent event) throws IOException {
        Stage stage;
        Parent root;
        stage=(Stage) ((Hyperlink)(event.getSource())).getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("Registration.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Registration Menu");
        stage.show();
    }
    @FXML
    private void classScheduleSearchClicked(ActionEvent event) throws IOException {
        Stage stage;
        Parent root;
        stage=(Stage) ((Hyperlink)(event.getSource())).getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("/application/Main.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Schedule Search");
        stage.show();
    }

    @FXML
    public void Login(ActionEvent event) throws Exception{

        try {
            if (!campusId.getText().isEmpty() && !password.getText().isEmpty()) {
                String user = campusId.getText();
                String pass = password.getText();

                conn = DriverManager.getConnection("jdbc:sqlite:UpdatedDB.db");
                st = (Statement) conn.createStatement();
                rs = st.executeQuery("SELECT * FROM StudentTable where Username = '" + user + "' AND Password_Plain = '" + pass+"'");

                if(rs.next()) {
                    if (rs.getString(16).equals(user) && rs.getString(17).equals(pass)) {
                        Stage stage;
                        Parent root;
                        stage = (Stage) ((Button) (event.getSource())).getScene().getWindow();
                        root = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
                        Scene scene = new Scene(root);
                        String str = rs.getString(2);

                        stage.setScene(scene);
                        stage.show();
                        rs.close();

                    }
                    Hiname.setText("Hello");

                }
                else{
                    userPassWrong.setText("CampusId or Password wrong.");
                }



            }
        }
        catch (Exception e ){
            throw e;
        }
    }



    @FXML
    public void setName(String name) {
        Hiname.setText(name);
    }

}
