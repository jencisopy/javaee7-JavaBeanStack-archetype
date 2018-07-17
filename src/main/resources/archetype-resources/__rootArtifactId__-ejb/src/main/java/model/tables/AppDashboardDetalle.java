package ${package}.model.tables;

import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import org.javabeanstack.data.DataRow;

/**
 *
 * @author Jorge Enciso
 */
@Entity
@Table(name = "appdashboarddetalle")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AppDashboardDetalle.findAll", query = "SELECT a FROM AppDashboardDetalle a")})
public class AppDashboardDetalle extends DataRow {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)            
    @Basic(optional = false)
    @Column(name = "idappdashboarddetalle")
    private Long idappdashboarddetalle;

    @JoinColumn(name = "idappresource", referencedColumnName = "idappresource")
    @ManyToOne(optional = false)
    private AppResource appresource;    
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "columns")
    private short columns;
    @Basic(optional = false)
    @NotNull
    @Column(name = "orden")
    private short orden;
    
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
    @JoinColumn(name = "idappdashboard", referencedColumnName = "idappdashboard")
    @ManyToOne(optional = false)
    private AppDashboard appdashboard;

    public AppDashboardDetalle() {
    }

    public AppDashboardDetalle(Long idappdashboarddetalle) {
        this.idappdashboarddetalle = idappdashboarddetalle;
    }

    public AppDashboardDetalle(Long idappdashboarddetalle, short columns, short orden, Date fechacreacion) {
        this.idappdashboarddetalle = idappdashboarddetalle;
        this.columns = columns;
        this.orden = orden;
        this.fechacreacion = fechacreacion;
    }

    public Long getIdappdashboarddetalle() {
        return idappdashboarddetalle;
    }

    public void setIdappdashboarddetalle(Long idappdashboarddetalle) {
        this.idappdashboarddetalle = idappdashboarddetalle;
    }

    public short getColumns() {
        return columns;
    }

    public void setColumns(short columns) {
        this.columns = columns;
    }

    public short getOrden() {
        return orden;
    }

    public void setOrden(short orden) {
        this.orden = orden;
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

    public AppDashboard getAppdashboard() {
        return appdashboard;
    }

    public void setAppdashboard(AppDashboard appdashboard) {
        this.appdashboard = appdashboard;
    }

    public AppResource getAppresource() {
        return appresource;
    }

    public void setAppresource(AppResource appresource) {
        this.appresource = appresource;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idappdashboarddetalle != null ? idappdashboarddetalle.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AppDashboardDetalle)) {
            return false;
        }
        AppDashboardDetalle other = (AppDashboardDetalle) object;
        if ((this.idappdashboarddetalle == null && other.idappdashboarddetalle != null) || (this.idappdashboarddetalle != null && !this.idappdashboarddetalle.equals(other.idappdashboarddetalle))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "net.makerapp.model.tables.AppDashboardDetalle[ idappdashboarddetalle=" + idappdashboarddetalle + " ]";
    }
    
}
