package org.example.proyectohibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

/**
 * Clase que realiza operaciones CRUD en la tabla 'usuario' usando Hibernate.
 */
public class UsuarioDB {

    private SessionFactory sessionFactory;

    /**
     * Constructor que inicializa la sesión de Hibernate.
     */
    public void UsuarioDAO() {
        Configuration configuration = new Configuration().configure();
        sessionFactory = configuration.buildSessionFactory();
    }

    /**
     * Método para guardar un nuevo usuario en la base de datos.
     *
     * @param nombre    Nombre del usuario.
     * @param apellidos Apellidos del usuario.
     * @param direccion Dirección del usuario.
     */
    public void crearUsuario(String nombre, String apellidos, String direccion) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Usuario usuario = new Usuario(nombre, apellidos, direccion);
        session.save(usuario);

        transaction.commit();
        session.close();
    }

    /**
     * Método para obtener todos los usuarios de la base de datos.
     *
     * @return Lista de usuarios.
     */
    public List<Usuario> obtenerUsuarios() {
        Session session = sessionFactory.openSession();
        List<Usuario> usuarios = session.createQuery("FROM Usuario", Usuario.class).list();
        session.close();
        return usuarios;
    }

    /**
     * Método para mostrar por separado cada fila de la tabla 'usuario'.
     */
    public void mostrarUsuariosPorSeparado() {
        List<Usuario> usuarios = obtenerUsuarios();

        for (Usuario usuario : usuarios) {
            System.out.println("Nombre: " + usuario.getNombre());
            System.out.println("Apellidos: " + usuario.getApellidos());
            System.out.println("Dirección: " + usuario.getDireccion());
            System.out.println("----------");
        }
    }
}