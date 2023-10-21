/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.laarabi.tpcustomerwiam.service;

import fr.laarabi.tpcustomerwiam.Customer;
import jakarta.enterprise.context.RequestScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import java.util.List;

/**
 *
 * @author WIAM
 */
@RequestScoped
public class CustomerManager {
    
       public List<Customer> getAllCustomers() {
       Query query = em.createNamedQuery("Customer.findAll");
       return query.getResultList();
    }

       @Transactional
    public Customer update(Customer customer) {
      return null;  
    } 
    
@PersistenceContext(unitName = "customerPU")
private EntityManager em;

@Transactional
public void persist(Customer customer) {
  em.persist(customer);
}
    


}
