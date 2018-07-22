package ${package}.model.tables;

import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.javabeanstack.data.DataRow;
import org.javabeanstack.model.IAppTablesRelation;

/**
 *
 * @author Jorge Enciso
 */
@Entity
@Table(name = "AppTablesRelation")
@NamedQueries({
    @NamedQuery(name = "AppTablesRelation.findAll", query = "SELECT d FROM AppTablesRelation d"),
    @NamedQuery(name = "AppTablesRelation.findByEntity", query = 
            "SELECT d FROM AppTablesRelation d"
                    + " where d.entityPK = :entityPK "
                    + " and d.entityFK = :entityFK "
                    + " and d.included = true")
                })
public class AppTablesRelation extends DataRow implements IAppTablesRelation {
    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "entityFK")
    private String entityFK;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "entityPK")
    private String entityPK;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "fieldsFK")
    private String fieldsFK;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "fieldsPK")
    private String fieldsPK;

    @Column(name = "included")
    private Boolean included;

    @Basic(optional = false)
    @NotNull
    @Column(name = "relationType")
    private short relationType;

    @Transient
    @Column(name = "dateCreated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreated;
    @Column(name = "dateModified")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateModified;

    public AppTablesRelation() {
    }

    @Override
    public String getEntityPK() {
        return entityPK;
    }

    @Override
    public String getFieldsPK() {
        return this.fieldsPK;
    }

    @Override
    public String getEntityFK() {
        return entityFK;
    }

    @Override
    public String getFieldsFK() {
        return fieldsFK;
    }

    @Override
    public void setEntityPK(String entity) {
        this.entityPK = entity;
    }

    @Override
    public void setFieldsPK(String fields) {
        this.fieldsPK = fields;
    }

    @Override
    public void setEntityFK(String entity) {
        this.entityFK = entity;
    }

    @Override
    public void setFieldsFK(String fields) {
        this.fieldsFK = fields;
    }
    
    @Override
    public boolean isIncluded() {
        return included;
    }

    @Override
    public void setIncluded(boolean included) {
        this.included = included;
    }

    @Override
    public short getRelationType() {
        return relationType;
    }

    @Override
    public void setRelationType(short relationType) {
        this.relationType = relationType;
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
        return "${package}.model.tables.AppTablesRelation[ = ]";
    }
}
