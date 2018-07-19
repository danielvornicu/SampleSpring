package tech.dev.entites;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Description de la classe
 * <p>
 * Date: 19/07/2018
 *
 * @author d.vornicu
 * @version 1.0 $Revision$ $Date$
 */

@Entity
@Table(name = "CLIENT")
public class Client implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name="ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="PRENOM")
    private String prenom;

    @Column(name="NOM")
    private String nom;

    @ManyToOne
    @JoinColumn(name = "ADRESSE_ID")
    private Adresse adresse;

    @OneToMany
    @JoinColumn(name = "CLIENT_ID")
    private Set<Commande> commandes;

    public Client() {
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
