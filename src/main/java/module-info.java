module org.example.projectclinic {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.projectclinic to javafx.fxml;
    exports org.example.projectclinic;
}