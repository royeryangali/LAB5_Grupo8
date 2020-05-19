package sw2.lab5.Entity;


import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    @Size(max = 11,message = "El nombre del producto no puede tener más de 11 caracteres")
    private int iduser;

    @Column(name = "firstName")
    @Size(max = 50,message = "El nombre del producto no puede tener más de 50 caracteres")
    private String firstname;

    @Column(name = "lastName")
    @Size(max = 50,message = "El nombre del producto no puede tener más de 50 caracteres")
    private String lastname;

    @Column(name = "email")
    @Size(max = 50,message = "El nombre del producto no puede tener más de 50 caracteres")
    private String email;

    @Column(name = "password")
    @Size(max = 100,message = "El nombre del producto no puede tener más de 100 caracteres")
    private String password;

    @Column(name = "intro")
    private String intro;

    @Column(name = "profile")
    private String profile;

    @Column(name = "active")
    @Size(max = 2,message = "Solo puede ser 0 o 1")
    private Boolean active;

    @ManyToOne
    @JoinColumn(name = "id_role")
    private Role role;

    public int getIduser() {
        return iduser;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}

