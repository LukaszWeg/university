package pl.lukasz.university.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Presence {

    @Id
    private Long id;
    private String present;

    @OneToMany(mappedBy = "presence")
    private List<ConnectTable> connectTableList;

    public Presence() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPresent() {
        return present;
    }

    public void setPresent(String present) {
        this.present = present;
    }

    public List<ConnectTable> getConnectTableList() {
        return connectTableList;
    }

    public void setConnectTableList(List<ConnectTable> connectTableList) {
        this.connectTableList = connectTableList;
    }
}
