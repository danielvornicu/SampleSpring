package tech.dev.modele;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Set;

/**
 * Factory pour la classe Client
 * <p>
 * Date: 28/06/2018
 *
 * @author d.vornicu
 * @version 1.0 $Revision$ $Date$
 */

@Component("clientBuilder")
public class ClientFactory{

    private Long id;
    private String prenom;
    private String nom;
    private Adresse adresse;
    private Set<Commande> commandes;

    public ClientFactory() {
    }

    public Client createInstance(){
        Client c = new Client();
        c.setPrenom(prenom);
        c.setNom(nom);
        c.setAdresse(adresse);
        return c;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPrenom() {
        return prenom;
    }

    @Value("Henry")
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    @Value("Gomis")
    public void setNom(String nom) {
        this.nom = nom;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    @Autowired(required = false)
    @Qualifier("a2")
    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public Set<Commande> getCommandes() {
        return commandes;
    }

    public void setCommandes(Set<Commande> commandes) {
        this.commandes = commandes;
    }
}

