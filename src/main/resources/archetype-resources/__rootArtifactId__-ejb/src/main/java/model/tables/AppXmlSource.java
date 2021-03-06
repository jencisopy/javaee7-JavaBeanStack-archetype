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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import org.javabeanstack.data.DataRow;
import org.javabeanstack.model.IAppXmlSource;
import static org.javabeanstack.util.Strings.isNullorEmpty;


/**
 *
 * @author Jorge Enciso
 */
@Entity
@Table(name = "appxmlsource")
@XmlRootElement
public class AppXmlSource extends DataRow implements IAppXmlSource {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)        
    @Basic(optional = false)
    @NotNull
    @Column(name = "idxmlsource")
    private Long idxmlSource;

    @Column(name = "idobject")
    private Long idobject;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "xmlname")
    private String xmlName;

    @Size(max = 200)
    @Column(name = "xmlpath")
    private String xmlPath;
    
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 2147483647)
    @Column(name = "xmlsource")
    private String xmlSource;
    
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 2147483647)
    @Column(name = "xmlcompiled")
    private String xmlCompiled;
    
    @Column(name = "processtime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date processTime;
    @Basic(optional = false)
    
    @Column(name = "referencetime")
    private BigInteger referencetime;
    

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

    public AppXmlSource() {
    }

    public AppXmlSource(Long idxmlsource) {
        this.idxmlSource = idxmlsource;
    }

    public AppXmlSource(Long idxmlsource, String xmlname, String xmlsource, String xmlcompile) {
        this.idxmlSource = idxmlsource;
        this.xmlName = xmlname;
        this.xmlSource = xmlsource;
        this.xmlCompiled = xmlcompile;
    }

    @Override
    public Long getIdXmlSource() {
        return idxmlSource;
    }

    @Override
    public void setIdXmlSource(Long idxmlsource) {
        this.idxmlSource = idxmlsource;
    }

    
    @Override
    public Long getIdObject() {
        return idobject;
    }

    @Override
    public void setIdObject(Long idobjeto) {
        this.idobject = idobjeto;
    }
    
    @Override
    public String getXmlName() {
        return xmlName;
    }

    @Override
    public void setXmlName(String xmlname) {
        this.xmlName = xmlname;
    }

    @Override
    public String getXmlPath() {
        return xmlPath;
    }

    @Override
    public void setXmlPath(String xmlPath) {
        this.xmlPath = xmlPath;
    }
    
    @Override
    public String getXmlSource() {
        return xmlSource;
    }

    @Override
    public void setXmlSource(String xmlsource) {
        this.xmlSource = xmlsource;
    }

    @Override
    public String getXmlCompiled() {
        return xmlCompiled;
    }

    @Override
    public void setXmlCompiled(String xmlcompile) {
        this.xmlCompiled = xmlcompile;
    }

    @Override
    public Date getProcessTime() {
        return processTime;
    }

    @Override
    public void setProcessTime(Date processtime) {
        this.processTime = processtime;
    }
    
    @Override
    public BigInteger getReferencetime() {
        return referencetime;
    }

    @Override
    public void setReferencetime(BigInteger referencetime) {
        this.referencetime = referencetime;
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


    public String getAppuser() {
        return appuser;
    }

    public void setAppuser(String appuser) {
        this.appuser = appuser;
    }

    @Override
    public boolean isValid() {
        if (isNullorEmpty(xmlCompiled)){
            return false;
        }
        return processTime.after(dateModified);
    }
    

    @Override
    public String toString() {
        return "${package}.model.tables.Appxmlsource[ idxmlsource=" + idxmlSource + " ]";
    }
}
