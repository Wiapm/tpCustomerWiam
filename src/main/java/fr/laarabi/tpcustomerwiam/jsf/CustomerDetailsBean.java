/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package fr.laarabi.tpcustomerwiam.jsf;

import fr.laarabi.tpcustomerwiam.Customer;
import fr.laarabi.tpcustomerwiam.Discount;
import fr.laarabi.tpcustomerwiam.service.CustomerManager;
import fr.laarabi.tpcustomerwiam.service.DiscountManager;
import java.io.Serializable;
import jakarta.inject.Inject;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import java.util.List;

/**
 *
 * @author WIAM
 */
/**
 * Backing bean pour la page customerDetails.xhtml.
 */
@Named
@ViewScoped
public class CustomerDetailsBean implements Serializable {

    private int idCustomer;
    private Customer customer;

    @Inject
    private CustomerManager customerManager;

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    /**
     * Retourne les détails du client courant (contenu dans l'attribut customer
     * de cette classe).
     *
     * @return
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     * Action handler - met à jour dans la base de données les données du client
     * contenu dans la variable d'instance customer.
     *
     * @return la prochaine page à afficher, celle qui affiche la liste des
     * clients.
     */
    public String update() {
        // Modifie la base de données.
        // Il faut affecter à customer (sera expliqué dans le cours).
        customer = customerManager.update(customer);
        return "customerList";
    }

    public void loadCustomer() {
        this.customer = customerManager.findById(idCustomer);
    }

    /**
     * Retourne la liste de tous les Discount.
     */
    @Inject
    private DiscountManager discountManager;

    public CustomerDetailsBean() {
    }

    public List<Discount> getDiscounts() {
        return discountManager.getAllDiscounts();
    }

}
