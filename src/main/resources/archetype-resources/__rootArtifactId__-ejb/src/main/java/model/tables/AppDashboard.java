package ${package}.model.tables;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal; 
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.javabeanstack.data.DataRow;

/**
 *
 * @author Jorge Enciso
 */
@Entity
@Table(name = "appdashboard")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AppDashboard.findAll", query = "SELECT a FROM AppDashboard a")})
public class AppDashboard extends DataRow {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)            
    @Basic(optional = false)
    @Column(name = "idappdashboard")
    private Long idappdashboard;
    @Size(max = 150)
    @Column(name = "name")
    private String name;

    @Transient
    @Basic(optional = false)
    @Column(name = "fechacreacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechacreacion;
    
    @Column(name = "fechamodificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechamodificacion;
    @Column(name = "fechareplicacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechareplicacion;
    @Size(max = 32)
    @Column(name = "appuser")
    private String appuser;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "appdashboard")
    private List<AppDashboardDetalle> appDashboardDetalleList = new ArrayList<>();

    @Column(name = "idusuario")
    private Long idusuario;
    
    @Column(name = "ispublic")
    private Boolean ispublic;

    public AppDashboard() {
    }

    public AppDashboard(Long idappdashboard) {
        this.idappdashboard = idappdashboard;
    }

    public AppDashboard(Long idappdashboard, Date fechacreacion) {
        this.idappdashboard = idappdashboard;
        this.fechacreacion = fechacreacion;
    }

    public Long getIdappdashboard() {
        return idappdashboard;
    }

    public void setIdappdashboard(Long idappdashboard) {
        this.idappdashboard = idappdashboard;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getFechacreacion() {
        return fechacreacion;
    }

    public void setFechacreacion(Date fechacreacion) {
        this.fechacreacion = fechacreacion;
    }

    public Date getFechamodificacion() {
        return fechamodificacion;
    }

    public void setFechamodificacion(Date fechamodificacion) {
        this.fechamodificacion = fechamodificacion;
    }

    public Date getFechareplicacion() {
        return fechareplicacion;
    }

    public void setFechareplicacion(Date fechareplicacion) {
        this.fechareplicacion = fechareplicacion;
    }

    public String getAppuser() {
        return appuser;
    }

    public void setAppuser(String appuser) {
        this.appuser = appuser;
    }

    public Long getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Long idusuario) {
        this.idusuario = idusuario;
    }

    public Boolean getIspublic() {
        return ispublic;
    }

    public void setIspublic(Boolean ispublic) {
        this.ispublic = ispublic;
    }
   
    @XmlTransient
    public List<AppDashboardDetalle> getAppDashboardDetalleList() {
        return appDashboardDetalleList;
    }

    public void setAppDashboardDetalleList(List<AppDashboardDetalle> appDashboardDetalleList) {
        this.appDashboardDetalleList = appDashboardDetalleList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idappdashboard != null ? idappdashboard.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof AppDashboard)) {
            return false;
        }
        AppDashboard other = (AppDashboard) object;
        if ((this.idappdashboard == null && other.idappdashboard != null) || (this.idappdashboard != null && !this.idappdashboard.equals(other.idappdashboard))) {
            return false;
        }
        return true;
    }

    @Override
    public boolean equivalent(Object o) {
        if (!(o instanceof AppDashboard)) {
            return false;
        }
        AppDashboard obj = (AppDashboard) o;
        return (this.name.trim().equals(obj.getName().trim()));
    }

   
    @PreUpdate
    @PrePersist
    public void preUpdate() {
        fechamodificacion = new Date();
    }     
    
    @Override
    public String toString() {
        return "net.makerapp.model.tables.AppDashboard[ idappdashboard=" + idappdashboard + " ]";
    }
    
}
