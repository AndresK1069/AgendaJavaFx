module com.example.deuxprojet {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires jdk.compiler;
    requires java.desktop;

    opens com.example.deuxprojet to javafx.fxml;
    exports com.example.deuxprojet;

    exports modele;
    exports vue;
}