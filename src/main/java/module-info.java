module org.example.proyectohibernate {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;
    requires java.sql;
    requires java.persistence;
    requires org.hibernate.orm.core;

    opens org.example.proyectohibernate to javafx.fxml;
    exports org.example.proyectohibernate;
}