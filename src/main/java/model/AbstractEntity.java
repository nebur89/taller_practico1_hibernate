package model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
public abstract class AbstractEntity implements Serializable {


    private static final long serialVersionUID= 1L;

    /* Campo de Auditoria*/
    private  String updatedUser;

    private Date updatedDate;

    public abstract Integer getId();

    public abstract void setId(final Long id);


    @Column(name = "AUDIT_UPDATED_USER", nullable = false)
    public String getUpdatedUser() {
        return updatedUser;
    }

    public void setUpdatedUser(String updatedUser) {
        this.updatedUser = updatedUser;
    }

    @Column(name = "AUDIT_UPDATED_DATE", nullable = false)
    public Date getUpdatedDate() {
        return updatedDate;
    }


    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }


}
