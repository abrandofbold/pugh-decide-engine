package odb;

import java.io.Serializable;
import javax.persistence.*;
 
@Entity
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
 
    @Id @GeneratedValue
    private long id;
 
    private String username;
    private String fullname;
 
    public User() {
    }
 
    User(String username, String fullname) {
        this.username = username;
        this.fullname = fullname;
    }
 
    public Long getId() {
        return id;
    }
 
    public String getUserName() {
         return username;
    }
 
    public String getFullName() {
         return fullname;
    }
 
    @Override
    public String toString() {
        return this.username + ", " + this.fullname;
    }
}
