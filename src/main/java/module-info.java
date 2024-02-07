module org.example.proyectohibernate {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;
    requires java.sql;
    requires java.persistence;
    requires org.hibernate.orm.core;

    opens org.example.proyectohibernate to javafx.fxml,java.sql,java.persintence,org.hibernate.orm.core;

    exports org.example.proyectohibernate;

}