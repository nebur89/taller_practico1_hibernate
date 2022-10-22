package persistence;

import model.Client;

import java.util.List;

public interface ClientDaoInterface extends CommonDaoInterface<Client> {


    public List<Client> findByNameAndFirstSurname(final String name, final String first_surname);

}
