package odb;

import java.io.Serializable;

import javax.persistence.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import static util.Printing.*;

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
    
    public static User login() throws Exception {
    	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    	
        // Open a database connection(create a new database if it doesn't exist yet)
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/db/pde.odb");
        EntityManager em = emf.createEntityManager();
        
        // Request username from user      
        pnb("Username: ");
        String username = reader.readLine();
        
        // Check if a record for user exists, and if not create one
        try{
        	em.createQuery("SELECT u FROM User u WHERE u.username ='"+username+"'").getSingleResult();
        }catch(NoResultException nre){
        	pnb("Full Name: ");
            String fullname = reader.readLine();
            p();
        	
        	em.getTransaction().begin();
        	em.persist(new User(username,fullname));
        	em.getTransaction().commit();
        	
        	p("A new user account for "+fullname+" has been created with a username of "+username);
        }
        
        p();
        User u = (User) em.createQuery("SELECT u FROM User u WHERE u.username ='"+username+"'").getSingleResult();
        p("Hello, "+u.getFullName()+", you have logged in as "+u.getUserName());
        
        // Close the database connection
        em.close();
        emf.close();
        
        return u;
    }
}
