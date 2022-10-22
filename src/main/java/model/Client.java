package model;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name= "Clients", schema = "BdHibernate")
public class Client extends AbstractEntity implements Serializable {


    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;

    @Column(nullable = false)
    private String  name;

    @Column(nullable = false)
    private String  first_surname;

    @Column(nullable = false)
    private String  second_surname;

    @Column(unique = true, nullable = false, length = 9)
    private String DNI;


    public Client() {
    }

    public Client(String name, String first_surname, String second_surname, String DNI) {
        this.name = name;
        this.first_surname = first_surname;
        this.second_surname = second_surname;
        this.DNI = DNI;
    }



   public Integer getId() {
          return id;
    }

    @Override
    public void setId(Long id) {

    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirst_surname() {
        return first_surname;
    }

    public void setFirst_surname(String first_surname) {
        this.first_surname = first_surname;
    }

    public String getSecond_surname() {
        return second_surname;
    }

    public void setSecond_surname(String second_surname) {
        this.second_surname = second_surname;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }
}
