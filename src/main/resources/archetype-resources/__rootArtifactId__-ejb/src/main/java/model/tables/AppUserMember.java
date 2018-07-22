package ${package}.model.tables;

import java.util.Date;
import java.util.Objects; 
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.javabeanstack.data.DataRow;
import org.javabeanstack.model.IAppUser;
import org.javabeanstack.model.IAppUserMember;

@Entity
@Table(name = "appusermember")
public class AppUserMember extends DataRow implements IAppUserMember {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idusermember")
    private Long idusermember;
    
    @JoinColumn(name = "idmember", referencedColumnName = "iduser")
    @ManyToOne(optional = false)
    private AppUser usermember;

    @JoinColumn(name = "iduser", referencedColumnName = "iduser")
    @ManyToOne(optional = false)
    private AppUser usergroup;
    
    @Transient
    @Column(name = "dateCreated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreated;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "dateModified")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateModified;
    
    
    public AppUserMember() {
    }

    @Override
    public Long getIdusermember() {
        return idusermember;
    }

    @Override
    public void setIdusermember(Long idusermember) {
        this.idusermember = idusermember;
    }

    @Override
    public IAppUser getUserMember() {
        return usermember;
    }

    @Override
    public void setUserMember(IAppUser userMember) {
        this.usermember = (AppUser)userMember;
    }

    @Override
    public IAppUser getUserGroup() {
        return usergroup;
    }

    @Override
    public void setUserGroup(IAppUser userGroup) {
        this.usergroup = (AppUser)userGroup;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Date getDateModified() {
        return dateModified;
    }

    public void setDateModified(Date dateModified) {
        this.dateModified = dateModified;
    }

    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + Objects.hashCode(this.idusermember);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final AppUserMember other = (AppUserMember) obj;
        return Objects.equals(this.idusermember, other.idusermember);
    }

    @Override
    public String toString() {
        return "UsuarioMiembro{" + "idusuariomiembro=" + idusermember + "}";
    }

    @Override
    public boolean equivalent(Object o) {
        if (!(o instanceof AppUserMember)) {
            return false;
        }
        AppUserMember obj = (AppUserMember) o;
        return (this.idusermember.equals(obj.getIdusermember())); 
    }
}
