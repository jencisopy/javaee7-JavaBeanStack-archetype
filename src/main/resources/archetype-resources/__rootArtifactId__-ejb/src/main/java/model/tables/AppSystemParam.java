package ${package}.model.tables;

import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import org.javabeanstack.model.IAppSystemParam;
import org.javabeanstack.data.DataRow;


/**
 *
 * @author Jorge Enciso
 */
@Entity
@Table(name = "appsystemparam")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AppSystemParam.findAll", query = "SELECT s FROM AppSystemParam s")})
public class AppSystemParam extends DataRow implements IAppSystemParam {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)            
    @Basic(optional = false)
    @NotNull
    @Column(name = "idappsystemparam")
    private Long idsystemparam;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "systemgroup")
    private String systemgroup;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "param")
    private String param;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "paramDescrip")
    private String paramDescrip;
    @Basic(optional = false)
    @NotNull
    @Column(name = "paramType")
    private Character paramType;
    @Column(name = "valueDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date valueDate;
    @Column(name = "valueNumber")
    private Long valueNumber;
    @Column(name = "valueBoolean")
    private Boolean valueBoolean;
    @Size(max = 200)
    @Column(name = "valueChar")
    private String valueChar;
    
    @Transient
    @Column(name = "dateCreated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreated;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "dateModified")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateModified;
    

    @Column(name = "appuser")
    private String appuser;

    public AppSystemParam() {
    }

    public AppSystemParam(Long idsystemparam) {
        this.idsystemparam = idsystemparam;
    }

    public AppSystemParam(Long idsystemparam, String systemgroup, String param, String paramDescrip, Character paramType) {
        this.idsystemparam = idsystemparam;
        this.systemgroup = systemgroup;
        this.param = param;
        this.paramDescrip = paramDescrip;
        this.paramType = paramType;
    }

    @Override
    public Long getIdsystemparam() {
        return idsystemparam;
    }

    @Override
    public void setIdsystemparam(Long idsystemparam) {
        this.idsystemparam = idsystemparam;
    }

    @Override
    public String getSystemgroup() {
        return systemgroup;
    }

    @Override
    public void setSystemgroup(String systemgroup) {
        this.systemgroup = systemgroup;
    }

    @Override
    public String getParam() {
        return param;
    }

    @Override
    public void setParam(String param) {
        this.param = param;
    }

    @Override
    public String getParamDescrip() {
        return paramDescrip;
    }

    @Override
    public void setParamDescrip(String paramDescrip) {
        this.paramDescrip = paramDescrip;
    }

    @Override
    public Character getParamType() {
        return paramType;
    }

    @Override
    public void setParamType(Character paramType) {
        this.paramType = paramType;
    }

    @Override
    public Date getValueDate() {
        return valueDate;
    }

    @Override
    public void setValueDate(Date valueDate) {
        this.valueDate = valueDate;
    }

    @Override
    public Long getValueNumber() {
        return valueNumber;
    }

    @Override
    public void setValueNumber(Long valueNumber) {
        this.valueNumber = valueNumber;
    }

    @Override
    public Boolean getValueBoolean() {
        return valueBoolean;
    }

    @Override
    public void setValueBoolean(Boolean valueBoolean) {
        this.valueBoolean = valueBoolean;
    }

    @Override
    public String getValueChar() {
        return valueChar;
    }

    @Override
    public void setValueChar(String valueChar) {
        this.valueChar = valueChar;
    }

    public String getAppuser() {
        return appuser;
    }

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

    @Override
    public String toString() {
        return "${package}.model.tables.Systemparam[ idsystemparam=" + idsystemparam + " ]";
    }
}
