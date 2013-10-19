package odb;

import javax.persistence.*;
import java.util.*;
 
public class Main {
    public static void main(String[] args) {
        // Open a database connection
        // (create a new database if it doesn't exist yet):
        EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("$objectdb/db/pde.odb");
        EntityManager em = emf.createEntityManager();
        
        User u = new User("abrandofbold","Robert Ritter");	
      
        
        // Create User
        em.getTransaction().begin();

        em.persist(u);

        em.getTransaction().commit();
 

        // Find the number of Point objects in the database:
        Query q1 = em.createQuery("SELECT COUNT(u) FROM User u");
        System.out.println("Total Users " + q1.getSingleResult());
 
 
        // Retrieve all the Point objects from the database:
        TypedQuery<User> query =
            em.createQuery("SELECT u FROM User u", User.class);
        List<User> results = query.getResultList();
        for (User n : results) {
            System.out.println(n);
        }
 
        // Close the database connection:
        em.close();
        emf.close();
    }
}
