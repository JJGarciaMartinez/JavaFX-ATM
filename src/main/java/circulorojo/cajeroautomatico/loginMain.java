package circulorojo.cajeroautomatico;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class loginMain extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(loginMain.class.getResource("login.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Image iconImage = new Image("https://i.imgur.com/FWnAvpa.png");
        scene.getStylesheets().add("https://fonts.googleapis.com/css2?family=Quicksand:wght@300;400;500;600;700&display=swap");
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.getIcons().add(iconImage);
        stage.setResizable(false);
        stage.setTitle("Bienvenido!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}