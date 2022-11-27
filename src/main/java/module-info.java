module com.example.demo_project {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    requires javafx.media;
    requires com.jfoenix;
    requires java.desktop;


    opens com.example.demo_project to javafx.fxml;
    exports com.example.demo_project;
}