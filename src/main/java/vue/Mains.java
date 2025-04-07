package vue;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.File;

public class Mains extends Application {
    public void start(Stage stage) {

        VBox root = new VBoxRoot();
        Scene scene = new Scene(root, 300,80);
        stage.setScene(scene);
        stage.setTitle("Try");
        stage.show();
        File css = new File("css/stylesheet.css");
        scene.getStylesheets().add(css.toURI().toString());
    }

}
