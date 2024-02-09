package circulorojo.cajeroautomatico;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class controller{
    public static String username;
    @FXML
     TextField txtUser;
    @FXML
    private PasswordField txtPass;
    @FXML
    private Button btnLogin;
    @FXML
    private Label emptyuser;
    @FXML
    private Label emptypass;
    @FXML
    private Button btnExit;

    @FXML
    public void eventKey(KeyEvent event){

        if (event.getSource() == txtUser) {
            if (!event.getCharacter().matches("[a-zA-Z0-9]")) {
                event.consume();
            }
        } else if (event.getSource() == txtPass) {
            if (!event.getCharacter().matches("[a-zA-Z0-9]")) {
                event.consume();
            }
        }
    }

    public void exitEvent(ActionEvent actionEvent) {
        if (actionEvent.getSource()==btnExit){
            System.exit(0);
        }
    }

    public class AlertUtility {
        public static void showInformationAlert(String header, String content) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.initStyle(StageStyle.TRANSPARENT);
            alert.setHeaderText(header);
            alert.setContentText(content);
            alert.showAndWait();
        }

        public static void showErrorAlert(String title, String content) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initStyle(StageStyle.TRANSPARENT);
            alert.setTitle(title);
            alert.setContentText(content);
            alert.showAndWait();
        }

    }

    @FXML
    public void eventAction(ActionEvent event) throws IOException {
        Object evt = event.getSource();

        if(evt.equals(btnLogin)){

            boolean isUserEmpty = txtUser.getText().isEmpty();
            boolean isPassEmpty = txtPass.getText().isEmpty();

            if (!isUserEmpty && !isPassEmpty){

                username = txtUser.getText();

                boolean validLogin = checkValidLogin(txtUser.getText(), txtPass.getText());

                if (validLogin) {
                    Stage stage = (Stage) btnLogin.getScene().getWindow();
                    stage.close();
                    FXMLLoader fxmlLoader = new FXMLLoader(loginMain.class.getResource("screen.fxml"));
                    Scene scene = new Scene(fxmlLoader.load());
                    Image iconImage = new Image("https://i.imgur.com/FWnAvpa.png");
                    scene.getStylesheets().add("https://fonts.googleapis.com/css2?family=Quicksand:wght@300;400;500;600;700&display=swap");
                    stage.getIcons().add(iconImage);
                    stage.setResizable(false);
                    stage.setTitle("Bienvenido!");
                    stage.setScene(scene);
                    stage.show();

                } else {
                    AlertUtility.showErrorAlert("¡Datos incorrectos!", "Los datos ingresados son invalidos, favor de revisar los datos e intentar de nuevo.");
                }

            }
            if(isUserEmpty) {
                emptyuser.setDisable(false);
                emptyuser.setOpacity(1);

            }else{emptyuser.setDisable(true);emptyuser.setOpacity(0);}
            if(isPassEmpty) {
                emptypass.setDisable(false);
                emptypass.setOpacity(1);
            }else{emptypass.setDisable(true);emptypass.setOpacity(0);}
        }
    }


    public boolean checkValidLogin(String user, String pass) {
        Map<String, String> users = new HashMap<>();
        users.put("1234567890", "passwordcuenta1");
        users.put("2414205416", "passwordcuenta2");
        users.put("admin1", "password1");
        users.put("admin2", "password2");
        return users.containsKey(user) && users.get(user).equals(pass);
    }



}