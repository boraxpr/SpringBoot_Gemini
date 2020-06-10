package com.gemini.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@SuppressWarnings("ALL")
@Entity
public class Employee {
    @Id
    private Integer id;
    private String username;
    private String password;
    private String firstname;
    private String lastname;
    private String email;

    @OneToMany(mappedBy = "planNo",cascade = CascadeType.ALL)
    private List<SciencePlan> sciencePlans;

    public Employee(int id, String username, String password, String firstname
            , String lastname, String email){
        this.id = id;
        this.username = username;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
    }

    public List<SciencePlan> getSciencePlans(){
        return sciencePlans;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }
}
