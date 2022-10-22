package org.example;

import model.Client;
import model.Hibernate;
import org.hibernate.Session;
import services.ClientServiceImplement;

import java.util.List;

/**
 * @author  Rubén Barragán Pérez
 *
 */

public class App
{
    public static void main( String[] args ) {

        //Se crea una conexion a travez del metodo conexionBd de la clase Hibernate.
        Session session = Hibernate.conexionBD();

        //Crea un una instancia del servicio de cliente
        ClientServiceImplement servClient = new ClientServiceImplement(session);

        //Creo varias instancias de clientes
        Client cliente1 = new Client("ruben", "molares", "sevilla", "48989620W");
        Client cliente2 = new Client("pepe", "utrera", "marchena", "48945620W");
        Client cliente3 = new Client("juan", "doshermanas", "sevilla", "43599620W");
        Client cliente4 = new Client("manolo", "elcoronil", "lospalacios", "44989620W");


        /*Creamos clientes*/
        System.out.println("\nREAMOS 4 clientes nuevo en  BD (metodo CreateNewClient)");

        servClient.createNewClient(cliente1);
        servClient.createNewClient(cliente2);
        servClient.createNewClient(cliente3);
        servClient.createNewClient(cliente4);


        //Mostramos todos los cliente de la BD
        System.out.println("\nMostramos todos los clientes de BD ( metodo findAll)");
        List<Client> listado = servClient.findAll();

        for (Client cliente : listado) {
            System.out.println(cliente.getName() + " "+ cliente.getFirst_surname()+" "+cliente.getSecond_surname() +"  "+ cliente.getDNI());
        }



        /*Eliminanos el ultimo cliente creado */
        System.out.println("\n\nEliminamos ultimo cliente de BD (metodo deleteClient)");

        servClient.deleteClient(cliente4);

        System.out.println("\nComprobamos que se ha eliminado:");

        listado = servClient.findAll();

        for (Client cliente : listado) {
            System.out.println(cliente.getName() + " "+ cliente.getFirst_surname()+" "+cliente.getSecond_surname() +"  "+ cliente.getDNI());
        }

        /*Modificamos un cliente */
        System.out.println("\n\nActualizamos el tercer cliente cambiandole el nombre: (metodo updaterClient)");

        cliente3.setName("Antonio");
        servClient.updateClient(cliente3);

        System.out.println("\nComprobamos que se ha actualizado:");

        listado = servClient.findAll();

        for (Client cliente : listado) {
            System.out.println(cliente.getName() + " "+ cliente.getFirst_surname()+" "+cliente.getSecond_surname() +"  "+ cliente.getDNI());
        }


        /*Buscamos cliente por nombre y primer apellido  */
        System.out.println("\n\nBuscamos cliente por nombre y primer apellido: (metodo findByNameAndFirstSurname)");
        System.out.println("Nombre :pepe, Primer apellido: utrera ");

        listado =servClient.findByNameAndFirstSurname("pepe", "utrera");

        for (Client cliente : listado) {
            System.out.println(cliente.getName() + " "+ cliente.getFirst_surname()+" "+cliente.getSecond_surname() +"  "+ cliente.getDNI());
        }



        /*Buscamos cliente por nombre id  */
        System.out.println("\n\nBuscamos cliente por Id (2) (metodo findById)");

        Client cliente = servClient.findById(2);

        System.out.println(cliente.getName() + " "+ cliente.getFirst_surname()+" "+cliente.getSecond_surname() +"  "+ cliente.getDNI());

    }

}
