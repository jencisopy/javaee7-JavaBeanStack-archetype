package ${package}.model.tables;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.javabeanstack.data.DataRow;
import org.javabeanstack.model.IAppCompanyAllowed;
import org.javabeanstack.model.IAppUser;
import org.javabeanstack.model.IAppUserMember;
import org.javabeanstack.util.Dates;

@Entity
@Table(name = "appuser")
public class AppUserLight extends DataRow implements IAppUser {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "iduser")
    private Long iduser;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "code")
    private String code;

    @Basic(optional = false)
    @NotNull(message = "Debe ingresar el nombre de usuario")
    @Size(min = 1, max = 50)
    @Column(name = "fullName")
    private String fullName;

    @Column(name = "pass")
    private String pass;

    @Transient
    private String passConfirm;

    @Size(max = 50)
    @Column(name = "description")
    private String description;

    @Size(max = 100)
    @Column(name = "email1")
    private String email1;

    @Size(max = 100)
    @Column(name = "email2")
    private String email2;
    
    @Size(max = 50)
    @Column(name = "telephoneNumber")
    private String telephoneNumber;

    @Size(max = 50)
    @Column(name = "telephoneNumber2")
    private String telephoneNumber2;

    @Size(max = 50)
    @Column(name = "telephoneNumber3")
    private String telephoneNumber3;
    
    @Column(name = "disable")
    private Boolean disable = false;

    @Column(name = "expiredDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date expiredDate;

    @Size(max = 2)
    @Column(name = "rol")
    private String rol;

    @Column(name = "type")
    private Short type;


    @Column(name = "fechamodificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechamodificacion;

    @OneToMany(mappedBy = "usermember")
    private List<AppUserMember> userMemberList = new ArrayList<>();

    @Column(name = "idcompany")
    private Long idcompany;

    public AppUserLight() {
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
    public String getLogin() {
        if (code != null) {
            code = code.trim();
        }
        return code;
    }

    @Override
    public void setLogin(String code) {
        this.code = code;
    }

    @Override
    public String getCode() {
        if (code != null) {
            code = code.trim();
        }
        return code;
    }

    @Override
    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String getFullName() {
        if (fullName != null) {
            fullName = fullName.trim();
        }
        return fullName;
    }

    @Override
    public void setFullName(String name) {
        this.fullName = name;
    }

    @Override
    public String getPass() {
        if (pass != null) {
            pass = pass.trim();
        }
        return pass;
    }

    @Override
    public void setPass(String clave) {
        this.pass = clave;
    }

    @Override
    public String getPassConfirm() {
        if (passConfirm != null) {
            passConfirm = passConfirm.trim();
        }
        return passConfirm;
    }

    @Override
    public void setPassConfirm(String passConfirm) {
        this.passConfirm = passConfirm;
    }

    @Override
    public String getDescription() {
        if (description != null) {
            description = description.trim();
        }
        return description;
    }

    @Override
    public void setDescription(String descripcion) {
        this.description = descripcion;
    }

    @Override
    public Boolean getDisable() {
        return disable;
    }

    @Override
    public void setDisable(Boolean disable) {
        this.disable = disable;
    }

    @Override
    public Date getExpiredDate() {
        return expiredDate;
    }

    @Override
    public void setExpiredDate(Date expira) {
        this.expiredDate = expira;
    }

    @Override
    public String getRol() {
        if (rol != null) {
            rol = rol.trim();
        }
        return rol;
    }

    @Override
    public void setRol(String rol) {
        this.rol = rol;
    }

    @Override
    public String getAppRol() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public void setAppRol(String appRol) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public Short getType() {
        return type;
    }

    @Override
    public void setType(Short type) {
        this.type = type;
    }

    public Date getFechamodificacion() {
        return fechamodificacion;
    }

    public void setFechamodificacion(Date fechamodificacion) {
        this.fechamodificacion = fechamodificacion;
    }

    @Override
    public List<IAppUserMember> getUserMemberList() {
        return (List<IAppUserMember>) (List<?>) userMemberList;
    }

    @Override
    public void setUserMemberList(List<IAppUserMember> userMemberList) {
        this.userMemberList = (List<AppUserMember>) (List<?>) userMemberList;
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
    public List<IAppCompanyAllowed> getAppCompanyAllowedList() {
        return null;
    }

    @Override
    public void setAppCompanyAllowedList(List<IAppCompanyAllowed> companyAllowedList) {
    }
    
    @Override
    public byte[] getAvatar() {
        return null;
    }

    @Override
    public void setAvatar(byte[] avatar) {
    }


    public String getEmail1() {
        return email1;
    }

    public void setEmail1(String email1) {
        this.email1 = email1;
    }

    public String getEmail2() {
        return email2;
    }

    public void setEmail2(String email2) {
        this.email2 = email2;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public String getTelephoneNumber2() {
        return telephoneNumber2;
    }

    public void setTelephoneNumber2(String telephoneNumber) {
        this.telephoneNumber2 = telephoneNumber;
    }
    
    public String getTelephoneNumber3() {
        return telephoneNumber3;
    }

    public void setTelephoneNumber3(String telephoneNumber) {
        this.telephoneNumber3 = telephoneNumber;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final AppUser other = (AppUser) obj;
        if (!Objects.equals(this.iduser, other.getIduser())) {
            return false;
        }
        return true;
    }

    @Override
    public boolean equivalent(Object o) {
        if (!(o instanceof AppUser)) {
            return false;
        }
        AppUser obj = (AppUser) o;
        return (this.code.trim().equals(obj.getLogin().trim()));
    }

    @Override
    public String toString() {
        return "Usuario{" + "idusuario=" + iduser + ", codigo=" + code + ", nombre=" + fullName + ", clave=" + pass + ", clave2=" + passConfirm + ", descripcion=" + description + ", disable=" + disable + ", expira=" + expiredDate + ", rol=" + rol + ", tipo=" + type + '}';
    }
    
    @PreUpdate
    @PrePersist
    public void preUpdate() {
        fechamodificacion = new Date();
        if (expiredDate == null){
            expiredDate = Dates.toDate("31/12/9999");
        }
    }    
}
