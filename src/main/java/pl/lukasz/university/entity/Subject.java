package pl.lukasz.university.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Subject {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String subject;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime date;
    private Short lenght;
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

    public Short getLenght() {
        return lenght;
    }

    public void setLenght(Short lenght) {
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
