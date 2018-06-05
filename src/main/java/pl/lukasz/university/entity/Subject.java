package pl.lukasz.university.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Subject {
    @Id
    private Long id;
    private String subject;
    private LocalDateTime date;
    private short lenght;
    private String address;

    @ManyToOne
    @JoinColumn(name = "teacherId")
    private Teacher teacher;

    @OneToMany(mappedBy = "subject")
    private List<ConnectTable> connectTables;

    public Subject() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public short getLenght() {
        return lenght;
    }

    public void setLenght(short lenght) {
        this.lenght = lenght;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public List<ConnectTable> getConnectTables() {
        return connectTables;
    }

    public void setConnectTables(List<ConnectTable> connectTables) {
        this.connectTables = connectTables;
    }
}
