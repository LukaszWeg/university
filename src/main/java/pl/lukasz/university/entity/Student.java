package pl.lukasz.university.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Student {
    @Id
    private Long id;
    private String firstname;
    private String lastname;
    private LocalDate birthday;
    private long PESEL;
    private String Semester;

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

    public String getSemester() {
        return Semester;
    }

    public void setSemester(String semester) {
        Semester = semester;
    }
}

