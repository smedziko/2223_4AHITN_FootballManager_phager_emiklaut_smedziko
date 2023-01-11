module com.example._2223_4ahitn_footballmanager_phager_emiklaut_smedziko {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.java;


    opens com.example._2223_4ahitn_footballmanager_phager_emiklaut_smedziko to javafx.fxml;
    exports com.example._2223_4ahitn_footballmanager_phager_emiklaut_smedziko;
    exports com.example._2223_4ahitn_footballmanager_phager_emiklaut_smedziko.Controller;
    opens com.example._2223_4ahitn_footballmanager_phager_emiklaut_smedziko.Controller to javafx.fxml;
}