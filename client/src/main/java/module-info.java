module com.nasutek.podnovus.client {
        requires javafx.controls;
        requires javafx.fxml;

        requires org.controlsfx.controls;
        requires org.kordamp.ikonli.javafx;

        opens com.nasutek.podnovus.client to javafx.fxml;
        exports com.nasutek.podnovus.client;
}