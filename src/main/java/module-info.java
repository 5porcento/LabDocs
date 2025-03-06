module com.example.labdocs {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens com.example.labdocs to javafx.fxml;
    exports com.example.labdocs;
}