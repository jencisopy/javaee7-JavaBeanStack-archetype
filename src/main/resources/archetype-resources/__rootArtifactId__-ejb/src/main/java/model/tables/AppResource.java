package ${package}.model.tables;

import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
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
import org.javabeanstack.model.IAppResource;
import static org.javabeanstack.util.Strings.isNullorEmpty;

/**
 *
 * @author Jorge Enciso
 */
@Entity
@Table(name = "appresource")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AppResource.findAll", query = "SELECT a FROM AppResource a")})
public class AppResource extends DataRow implements IAppResource {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)        
    @Basic(optional = false)
    @NotNull
    @Column(name = "idappresource")
    private Long idappresource;
    
    @Column(name = "idparent")
    private Long idparent;

    @Column(name = "idobject")
    private Long idobject;

    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "code")
    private String code;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "name")
    private String name;
    
    @Size(max = 200)
    @Column(name = "url")
    private String url;
    
    @Size(max = 20)
    @Column(name = "type")
    private String type;
    
    @Size(max = 30)
    @Column(name = "charset")
    private String charset;
    
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 2147483647)
    @Column(name = "source")
    private String source;
    
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 2147483647)
    @Column(name = "compiled")
    private String compiled;
    
    @Column(name = "processtime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date processtime;

    @Column(name = "referencetime")
    private BigInteger referencetime;
    
    @Column(name = "lastreference")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastreference;

    @Size(max = 32)
    @Column(name = "checksum")
    private String checksum;
    
    
    @Transient
    @Column(name = "dateCreated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreated;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "dateModified")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateModified;
    
    
    @Size(max = 32)
    @Column(name = "appuser")
    private String appuser;

    @Column(name = "bdata")
    private byte[] bdata;
    
    public AppResource() {
    }

    public AppResource(Long idappresource) {
        this.idappresource = idappresource;
    }

    public AppResource(Long idappresource, String code, String name, String source, String compiled, Date fechacreacion, Date fechamodificacion) {
        this.idappresource = idappresource;
        this.code = code;
        this.name = name;
        this.source = source;
        this.compiled = compiled;
        this.dateCreated = fechacreacion;
        this.dateModified = fechamodificacion;
    }

    @Override
    public Long getIdappresource() {
        return idappresource;
    }

    @Override
    public void setIdappresource(Long idappresource) {
        this.idappresource = idappresource;
    }

    @Override
    public Long getIdparent() {
        return idparent;
    }

    @Override
    public void setIdparent(Long idparent) {
        this.idparent = idparent;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public void setCode(String code) {
        this.code = code;
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
    public String getUrl() {
        return url;
    }

    @Override
    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String getCharset() {
        return charset;
    }

    @Override
    public void setCharset(String charset) {
        this.charset = charset;
    }

    @Override
    public String getSource() {
        return source;
    }

    @Override
    public void setSource(String source) {
        this.source = source;
    }

    @Override
    public String getCompiled() {
        return compiled;
    }

    @Override
    public void setCompiled(String compiled) {
        this.compiled = compiled;
    }

    @Override
    public Date getProcesstime() {
        return processtime;
    }

    @Override
    public void setProcesstime(Date processtime) {
        this.processtime = processtime;
    }

    @Override
    public BigInteger getReferencetime() {
        return referencetime;
    }

    @Override
    public void setReferencetime(BigInteger referencetime) {
        this.referencetime = referencetime;
    }

    @Override
    public Date getLastreference() {
        return lastreference;
    }

    @Override
    public void setLastreference(Date lastreference) {
        this.lastreference = lastreference;
    }

    
    @Override
    public String getAppuser() {
        return appuser;
    }

    @Override
    public void setAppuser(String appuser) {
        this.appuser = appuser;
    }

    @Override
    public boolean isValid() {
        if (isNullorEmpty(compiled) || processtime == null){
            return false;
        }
        return processtime.after(dateModified);
    }

    public byte[] getBdata() {
        return bdata;
    }

    public void setBdata(byte[] bdata) {
        this.bdata = bdata;
    }

    @Override
    public Long getIdobject() {
        return idobject;
    }

    @Override
    public void setIdobject(Long idobject) {
        this.idobject = idobject;
    }

    @Override
    public String getChecksum() {
        return checksum;
    }

    @Override
    public void setChecksum(String checkSum) {
        this.checksum = checkSum;
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
        return "${package}.model.tables.Appresource[ idappresource=" + idappresource + " ]";
    }

}
