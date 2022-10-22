package persistence;

import model.Client;
import org.hibernate.Session;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

public class ClientDaoImplement extends CommonDaoImplement<Client> implements ClientDaoInterface{

    /*Conexion a base de datos*/
    private Session session;

    /*Metodo de constructor*/
    public ClientDaoImplement(Session session) {
        super(session);
        this.session = session;
    }


    public List<Client> findByNameAndFirstSurname(final String name, final String first_surname){

        if (!session.getTransaction().isActive()) {
            session.getTransaction().begin();
        }

        final List<Client> list = session.createQuery("FROM Client WHERE name='"+name+ "' AND first_surname='" +first_surname+"'" ).list();

        return  list;

    }


}
