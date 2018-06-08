package pl.lukasz.university.entity;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstname;
    private String lastname;
    private LocalDate birthday;
    @Length(min = 11, max = 11, message = "PESEL MUSI POSIADAĆ 11 ZNAKÓW")
    private long PESEL;
    @Length(min = 9, max = 9, message = "NUMER TELEFONU MUSI POSIADAĆ 9 ZNAKÓW")
    private long telephoneNumber;

    @OneToMany(mappedBy = "student")
    private List<ConnectTable> connectTables;

    @ManyToOne
    @JoinColumn(name = "roleId")
    private Role role;

    public Student() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public long getPESEL() {
        return PESEL;
    }

    public void setPESEL(long PESEL) {
        this.PESEL = PESEL;
    }

    public long getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(long telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public List<ConnectTable> getConnectTables() {
        return connectTables;
    }

    public void setConnectTables(List<ConnectTable> connectTables) {
        this.connectTables = connectTables;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}

