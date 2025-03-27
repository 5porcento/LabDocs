module com.example.labdocs {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;
    requires kernel;
    requires layout;

    opens com.example.labdocs to javafx.fxml;
    exports com.example.labdocs;

    opens com.example.labdocs.controller to javafx.fxml;
    exports com.example.labdocs.controller;
}