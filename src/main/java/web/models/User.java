package web.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(unique = true)
    private String login;
    private String password;
    @ManyToMany(fetch = FetchType.EAGER
            , cascade = CascadeType.MERGE)
    @JoinTable(name = "user_roles"
            , joinColumns = @JoinColumn(name = "user_id")
            , inverseJoinColumns = @JoinColumn(name = "role_id"))
    @JoinColumn(name = "roles")
    private Set<Role> roles;
    
    public User() {
    }
    
    public User(String login,String password) {
        this.login = login;
        this.password = password;
    }
    
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    
    public String getLogin() {
        return login;
    }
    
    public void setLogin(String login) {
        this.login = login;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public Set<Role> getRoles() {
        return roles;
    }
    
    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
    
    public void setRole(Role role) {
        if (roles == null) {
            roles = new HashSet<>();
        }
        roles.add(role);
        
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id
                && Objects.equals(login, user.login)
                && Objects.equals(password, user.password)
                && Objects.equals(roles, user.roles);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(id, login, password, roles);
    }
    
    @Override
    public String toString() {
        return id + " " + roles + " " + login + " " + password;
    }
}
