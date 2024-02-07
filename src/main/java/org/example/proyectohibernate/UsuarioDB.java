package org.example.proyectohibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que realiza operaciones CRUD en la tabla 'usuario' usando Hibernate.
 */
public class UsuarioDB {

    private SessionFactory sessionFactory;


    private static EntityManagerFactory EMF = Persistence.createEntityManagerFactory("Persistencia");
    ;

    /**
     * Método para crear un nuevo usuario en la base de datos.
     *
     * @param nombre    Nombre del usuario.
     * @param apellidos Apellidos del usuario.
     * @param direccion Dirección del usuario.
     */
    public static void crearUsuarioDB(String nombre, String apellidos, String direccion) {
        EntityManager EM = EMF.createEntityManager();
        try {

            EM.getTransaction().begin();

            // Crear una nueva instancia de Usuario
            Usuario usuario = new Usuario(nombre, apellidos, direccion);

            // Guardar el usuario en la base de datos
            //session.save(usuario);
            EM.persist(usuario);
            EM.getTransaction().commit();
            EM.close();

        } catch (Exception e) {

            e.printStackTrace(); // Imprime la excepción para depuración
        }

    }

    public static void eliminarUsuarioDB(Usuario u) {
        EntityManager EM = EMF.createEntityManager();
        try {

            EM.getTransaction().begin();

            EM.find(Usuario.class,u.getId());


            if (u != null) {
                EM.remove(u);
                EM.getTransaction().commit();
                EM.close();

                // Confirmar la transacción
                System.out.println("Usuario eliminado exitosamente.");
            } else {
                System.out.println("No se encontró un usuario con el ID proporcionado.");
            }
        } catch (Exception e) {
            e.printStackTrace(); // Imprime la excepción para depuración
        }
    }
/**
 * Método para obtener todos los usuarios de la base de datos.
 *
 * @return Lista de usuarios.
 */
    public List<Usuario> obtenerUsuarios() {
        EntityManager EM = EMF.createEntityManager();
        EM.getTransaction().begin();

        List<Usuario> usuarios = (ArrayList<Usuario>) EM.createQuery("FROM Entrenador").getResultList();
        EM.close();
        return usuarios;
    }




}

   /* public void crearUsuario(String nombre, String apellidos, String direccion) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Usuario usuario = new Usuario(nombre, apellidos, direccion);
        session.save(usuario);

        transaction.commit();
        session.close();
    }*/



    /**
     * Método para mostrar por separado cada fila de la tabla 'usuario'.
     */
   /* public void mostrarUsuariosPorSeparado() {
        List<Usuario> usuarios = obtenerUsuarios();

        for (Usuario usuario : usuarios) {
            System.out.println("Nombre: " + usuario.getNombre());
            System.out.println("Apellidos: " + usuario.getApellidos());
            System.out.println("Dirección: " + usuario.getDireccion());
            System.out.println("----------");
        }
    }
}*/