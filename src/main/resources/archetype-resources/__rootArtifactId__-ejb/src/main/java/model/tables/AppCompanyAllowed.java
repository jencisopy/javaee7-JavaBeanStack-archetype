package ${package}.model.tables;

import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity; 
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.javabeanstack.data.DataRow;
import org.javabeanstack.model.IAppCompanyAllowed;

@Entity
@Table(name = "appcompanyallowed")
public class AppCompanyAllowed extends DataRow implements IAppCompanyAllowed {
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "iduser")
    private Long iduser;

    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idcompany")
    private Long idcompany;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "allow")
    private boolean allow;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "deny")
    private boolean deny;
    
    @Size(max = 32)
    @Column(name = "appuser")
    private String appuser;

    @Transient
    @Column(name = "dateCreated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreated;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "dateModified")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateModified;
    

    public AppCompanyAllowed() {
    }

    @Override
    public Long getIduser() {
        return iduser;
    }

    @Override
    public void setIduser(Long iduser) {
        this.iduser = iduser;
    }

    @Override
    public Long getIdcompany() {
        return idcompany;
    }

    @Override
    public void setIdcompany(Long idcompany) {
        this.idcompany = idcompany;
    }


    @Override
    public boolean getAllow() {
        return allow;
    }

    @Override
    public void setAllow(boolean allow) {
        this.allow = allow;
    }

    @Override
    public boolean getDeny() {
        return deny;
    }

    @Override
    public void setDeny(boolean deny) {
        this.deny = deny;
    }

    @Override
    public String getAppuser() {
        return appuser;
    }

    @Override
    public void setAppuser(String appuser) {
        this.appuser = appuser;
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
}
