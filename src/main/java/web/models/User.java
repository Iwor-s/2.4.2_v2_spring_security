package web.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String surname;
    @Column(name="year_of_birth")
    private int yearOfBirth;
    
    
    public User() {
    }
    
    public User(String name, String surname, int yearOfBirth) {
        this.name = name;
        this.surname = surname;
        this.yearOfBirth = yearOfBirth;
    }
    
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    
    public int getYearOfBirth() {
        return yearOfBirth;
    }
    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id
                && yearOfBirth == user.yearOfBirth
                && Objects.equals(name, user.name)
                && Objects.equals(surname, user.surname);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, yearOfBirth);
    }
    
    @Override
    public String toString() {
        return "(" + id + ") " + name + " " + surname + ", " + yearOfBirth;
    }
}
