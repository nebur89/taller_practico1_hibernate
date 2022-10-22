package services;

import model.Client;
import org.hibernate.Session;

import persistence.ClientDaoImplement;

import java.util.List;

public  class ClientServiceImplement implements ClientServiceInterface {



    private ClientDaoImplement  clientDao;


    public ClientServiceImplement(Session session){

        this.clientDao = new ClientDaoImplement(session);
    }

    @Override
    public  void createNewClient(Client newClient) {

        clientDao.create(newClient);

        System.out.println("Se ha creado nuevo cliente");

    }

    @Override
    public void deleteClient(Client deleteClient) {

        clientDao.delete(deleteClient);

        System.out.println("Se ha eliminado cliente");
    }

    @Override
    public void updateClient(Client updateClient) {

        clientDao.update(updateClient);
        System.out.println("Se ha actualizado cliente");
    }

    @Override
    public Client findById(Integer Client_id) {

        return clientDao.findById(Client_id);
    }

    @Override
    public List<Client> findAll() {

        return clientDao.findAll();
    }

    @Override
    public List<Client> findByNameAndFirstSurname(String Client_name, String Client_firstSur) {

        return clientDao.findByNameAndFirstSurname(Client_name, Client_firstSur);

    }


}
