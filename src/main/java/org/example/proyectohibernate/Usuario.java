package org.example.proyectohibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.*;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Column(name = "id")
    private int id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "apellidos", nullable = false)
    private String apellidos;

    @Column(name = "direccion", nullable = false)
    private String direccion;


    private static SessionFactory sessionFactory;

    public Usuario() {
        // Constructor vacío requerido por Hibernate
    }

    public Usuario(String nombre, String apellidos, String direccion) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.direccion = direccion;
    }

    public int getId() {
        return id;
    }

}





    /**
     * Método para eliminar un usuario de la base de datos.
     *
     * @param usuarioId ID del usuario a eliminar.
     */
   /*

    /**
     * Método para modificar un usuario en la base de datos.
     *
     * @param usuarioId ID del usuario a modificar.
     * @param nuevoNombre Nuevo nombre del usuario.
     * @param nuevosApellidos Nuevos apellidos del usuario.
     * @param nuevaDireccion Nueva dirección del usuario.
     */
   /* public static void modificarUsuarioDB(int usuarioId, String nuevoNombre, String nuevosApellidos, String nuevaDireccion) {
        //Session session = sessionFactory.openSession();
        Transaction transaction = null;

        try {
            //transaction = session.beginTransaction();
            transaction = sessionFactory.getCurrentSession().beginTransaction();

            // Obtener el usuario por su ID
            //Usuario usuario = session.get(Usuario.class, usuarioId);
            Usuario usuario = sessionFactory.getCurrentSession().get(Usuario.class, usuarioId);

            if (usuario != null) {
                // Modificar los atributos del usuario
                usuario.setNombre(nuevoNombre);
                usuario.setApellidos(nuevosApellidos);
                usuario.setDireccion(nuevaDireccion);

                // Actualizar el usuario en la base de datos
                //session.update(usuario);
                sessionFactory.getCurrentSession().update(usuario);

                // Confirmar la transacción
                transaction.commit();
                System.out.println("Usuario modificado exitosamente.");
            } else {
                System.out.println("No se encontró un usuario con el ID proporcionado.");
            }
        } catch (Exception e) {
            // Manejo de excepciones, si es necesario
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace(); // Imprime la excepción para depuración
        } finally {
            //session.close();
            sessionFactory.getCurrentSession().close();
        }
    }

    // Getters y Setters


    public int getId() { return id; }

    public void setId(int id) {this.id = id;}

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}*/
