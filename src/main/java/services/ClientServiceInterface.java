package services;

import model.Client;

import java.util.List;

public interface ClientServiceInterface {

    public void createNewClient(final Client newClient);

    public void deleteClient(final Client deleteClient);

    public void updateClient(final Client updateClient);

    public Client findById(final Integer Client_id);

    public List<Client> findAll();

    public List<Client> findByNameAndFirstSurname(final String Client_name, final String Client_firstSur);



}
