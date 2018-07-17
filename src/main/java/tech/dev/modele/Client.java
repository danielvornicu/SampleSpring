package tech.dev.modele;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.io.Serializable;
import java.util.Set;

/**
 * Classe Client
 * <p>
 * Date: 25/06/2018
 *
 * @author d.vornicu
 * @version 1.0 $Revision$ $Date$
 */

public class Client implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String prenom;
    private String nom;
    private Adresse adresse;
    private Set<Commande> commandes;

    public Client() {
    }

    public Client(String nom, String prenom, Adresse adresse){
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
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

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    @Autowired
    @Qualifier("adressePrincipaleAnnotation")
    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public Set<Commande> getCommandes() {
        return commandes;
    }

    public void setCommandes(Set<Commande> commandes) {
        this.commandes = commandes;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((adresse == null) ? 0 : adresse.hashCode());
        result = prime * result + ((nom == null) ? 0 : nom.hashCode());
        result = prime * result + ((prenom == null) ? 0 : prenom.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;

        Client other = (Client) obj;

        if (adresse == null) {
            if (other.adresse != null)
                return false;
        } else if (!adresse.equals(other.adresse))
            return false;

        if (nom == null) {
            if (other.nom != null)
                return false;
        } else if (!nom.equals(other.nom))
            return false;

        if (prenom == null) {
            if (other.prenom != null)
                return false;
        } else if (!prenom.equals(other.prenom))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Client [" +
                 "id=" + this.getId() + ", " +
                 "prenom='" + this.getPrenom()+ "', " +
                 "nom='" + this.getNom() + "', " +
                 "adresse=" + this.getAdresse() + ", " +
                 "commandes=" + this.getCommandes() +
                ']';
    }

}
