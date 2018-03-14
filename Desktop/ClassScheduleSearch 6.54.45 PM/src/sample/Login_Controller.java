package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.xml.soap.Text;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class LoginController {

    @FXML
    public TextField campusId, password;
    @FXML
    public Button loginB;
    @FXML
    public Label userPassWrong;
    @FXML
    public Label name;

    java.sql.Connection conn = null;
    ResultSet rs = null;
    Statement st;

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
                        name.setText(str);
                        rs.close();
                    }

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
}
