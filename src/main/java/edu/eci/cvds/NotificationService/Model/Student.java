package edu.eci.cvds.NotificationService.Model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

@Document
public class Student{
    
    @Id 
    private String id;
    
    private String name;
    private String lastname;
    private String code;

    public Student() {}

    public Student(String name, String lastname, String code) {
        this.name = name;
        this.lastname = lastname;
        this.code = code;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getname() {
        return name;
    }

    public void setname(String name) {
        this.name = name;
    }

    public String getlastname() {
        return lastname;
    }

    public void setlastname(String lastname) {
        this.lastname = lastname;
    }

    public String getcode() {
        return code;
    }

    public void setcode(String code) {
        this.code = code;
    }
}


