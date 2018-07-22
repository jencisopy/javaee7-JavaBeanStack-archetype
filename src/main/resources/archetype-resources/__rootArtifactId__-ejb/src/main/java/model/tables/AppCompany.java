package ${package}.model.tables;

import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.javabeanstack.data.DataRow;
import org.javabeanstack.model.IAppCompany;


/**
 *
 * @author Jorge Enciso
 */
@Entity
@Table(name = "appcompany") 
@XmlRootElement
public class AppCompany extends DataRow implements IAppCompany {
    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idcompany")
    private Long idcompany;
    
    @Column(name = "idcompanymask")
    private Long idcompanymask;
    @Column(name = "idperiod")
    private Long idperiod;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "name")
    private String name;
    @Size(max = 50)
    @Column(name = "socialName")
    private String socialName;
    @Size(max = 50)
    @Column(name = "address")
    private String address;
    @Size(max = 50)
    @Column(name = "telephoneNumber")
    private String telephoneNumber;
    @Size(max = 11)
    @Column(name = "taxId")
    private String taxId;
    @Size(max = 50)
    @Column(name = "persistentUnit")
    private String persistentUnit;
    @Size(max = 50)
    @Column(name = "menu")
    private String menu;
    @Size(max = 50)
    @Column(name = "filesystem")
    private String filesystem;

    @Column(name = "logo")
    private byte[] logo;

    @Size(max = 50)
    @Column(name = "dbengine")
    private String dbengine;
    @Size(max = 4)
    @Column(name = "country")
    private String country;
    @Size(max = 10)
    @Column(name = "companyActivity")
    private String companyActivity;
    
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
    

    @OneToMany(mappedBy = "idcompanygroup")
    private List<AppCompany> companyList;

    @Column(name = "idcompanygroup")
    private Long idcompanygroup;

    public AppCompany() {
    }

    public AppCompany(Long idcompany) {
        this.idcompany = idcompany;
    }

    public AppCompany(Long idcompany, String nombre) {
        this.idcompany = idcompany;
        this.name = nombre;
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
    public Long getIdcompanymask() {
        return idcompanymask;
    }

    @Override
    public void setIdcompanymask(Long idcompanymask) {
        this.idcompanymask = idcompanymask;
    }

    @Override
    public Long getIdperiod() {
        return idperiod;
    }

    @Override
    public void setIdperiod(Long idperiodo) {
        this.idperiod = idperiodo;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getSocialName() {
        return socialName;
    }

    @Override
    public void setSocialName(String socialName) {
        this.socialName = socialName;
    }

    @Override
    public String getAddress() {
        return address;
    }

    @Override
    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    @Override
    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    @Override
    public String getTaxId() {
        return taxId;
    }

    @Override
    public void setTaxId(String taxId) {
        this.taxId = taxId;
    }

    @Override
    public String getPersistentUnit() {
        return persistentUnit;
    }

    @Override
    public void setPersistentUnit(String persistentUnit) {
        this.persistentUnit = persistentUnit;
    }

    @Override
    public String getMenu() {
        return menu;
    }

    @Override
    public void setMenu(String menu) {
        this.menu = menu;
    }

    @Override
    public String getFilesystem() {
        return filesystem;
    }

    @Override
    public void setFilesystem(String filesystem) {
        this.filesystem = filesystem;
    }


    @Override
    public String getDbengine() {
        return dbengine;
    }

    @Override
    public void setDbengine(String dbengine) {
        this.dbengine = dbengine;
    }

    @Override
    public String getCountry() {
        return country;
    }

    @Override
    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String getCompanyActivity() {
        return companyActivity;
    }

    @Override
    public void setCompanyActivity(String companyrubro) {
        this.companyActivity = companyrubro;
    }

    
    @Override
    public byte[] getLogo() {
        return logo;
    }

    @Override
    public void setLogo(byte[] logo) {
        this.logo = logo;
    }
    
    @XmlTransient
    @Override
    public List<IAppCompany> getCompanyList() {
        return (List<IAppCompany>) (List<?>) companyList;
    }

    @Override
    public void setCompanyList(List<IAppCompany> companyList) {
        this.companyList = (List<AppCompany>) (List<?>) companyList;
    }

    @Override
    public Long getIdcompanygroup() {
        return idcompanygroup;
    }

    @Override
    public void setIdcompanygroup(Long idcompanygroup) {
        this.idcompanygroup = idcompanygroup;
    }

    @Override
    public String getAppuser() {
        return appuser;
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
    public void setAppuser(String appuser) {
        this.appuser = appuser;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcompany != null ? idcompany.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof AppCompany)) {
            return false;
        }
        AppCompany other = (AppCompany) object;
        if ((this.idcompany == null && other.idcompany != null) || (this.idcompany != null && !this.idcompany.equals(other.idcompany))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "${package}.model.table.Empresa[ idcompany=" + idcompany + " ]";
    }

    @Override
    public boolean equivalent(Object o) {
        if (!(o instanceof AppCompany)) {
            return false;
        }
        AppCompany obj = (AppCompany) o;
        return (this.idcompany.equals(obj.getIdcompany()));
    }
}
