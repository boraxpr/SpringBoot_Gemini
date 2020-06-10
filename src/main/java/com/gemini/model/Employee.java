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
    private String password;
    private String firstname;
    private String lastname;
    private String email;

    @OneToMany(mappedBy = "planNo",cascade = CascadeType.ALL)
    private List<SciencePlan> sciencePlans;

    public Employee(int id, String password, String firstname
            , String lastname, String email){
        this.id = id;
        this.email = email;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
    }
    public Employee(){}

    public List<SciencePlan> getSciencePlans(){
        return sciencePlans;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }
}
