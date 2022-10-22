package model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Hibernate {

    //archivo de configuracion
   private static Configuration config = new Configuration().configure();

    //Configuracion de la conexion
   private static SessionFactory sessionFactory = config.buildSessionFactory();


   public Hibernate(){

   }

    /** Metodo Conexion BD Retorna una conexion a base de datos*/

    public static Session conexionBD() {
        return  sessionFactory.openSession();
    }
}
