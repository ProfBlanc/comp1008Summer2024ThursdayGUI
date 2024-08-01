module ca.georgiancollege.comp1008summer2024thursdaygui {
    requires javafx.controls;
    requires javafx.fxml;


    opens ca.georgiancollege.comp1008summer2024thursdaygui to javafx.fxml;
    exports ca.georgiancollege.comp1008summer2024thursdaygui;
}