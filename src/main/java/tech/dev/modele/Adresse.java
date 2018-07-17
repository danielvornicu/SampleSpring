package tech.dev.modele;

import java.io.Serializable;

/**
 * Classe Adresse
 * <p>
 * Date: 25/06/2018
 *
 * @author d.vornicu
 * @version 1.0 $Revision$ $Date$
 */

public class Adresse implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String ligne1;
    private String ligne2;
    private Integer codePostal;
    private String ville;

    public Adresse() {
        //System.out.println("new Adresse class constructed.");
    }

    public Adresse(Integer codePostal) {
        this.codePostal = codePostal;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        if (this.getId() == null){
            this.id = id;
        }
    }

    public String getLigne1() {
        return ligne1;
    }

    public void setLigne1(String ligne1) {
        if (this.getLigne1() == null){
            this.ligne1 = ligne1;
        }
    }

    public String getLigne2() {
        return ligne2;
    }

    public void setLigne2(String ligne2) {
        if (this.getLigne2() == null){
            this.ligne2 = ligne2;
        }
    }

    public Integer getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(Integer codePostal) {
        //parce que on a l'injection qui est faite apres l'appel createInstance de AdresseFactory on veut pas ecraser
        if (this.getCodePostal() == null){
            this.codePostal = codePostal;
        }
    }

    public String getVille() {
        return ville;
    }


    public void setVille(String ville) {
        //parce que on a l'injection qui est faite apres l'appel createInstance de AdresseFactory on veut pas ecraser
        if (this.getVille() == null){
            this.ville = ville;
        }
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((codePostal == null) ? 0 : codePostal.hashCode());
        result = prime * result + ((ligne1 == null) ? 0 : ligne1.hashCode());
        result = prime * result + ((ligne2 == null) ? 0 : ligne2.hashCode());
        result = prime * result + ((ville == null) ? 0 : ville.hashCode());
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

        Adresse other = (Adresse) obj;

        if (codePostal == null) {
            if (other.codePostal != null)
                return false;
        } else if (!codePostal.equals(other.codePostal))
            return false;

        if (ligne1 == null) {
            if (other.ligne1 != null)
                return false;
        } else if (!ligne1.equals(other.ligne1))
            return false;

        if (ligne2 == null) {
            if (other.ligne2 != null)
                return false;
        } else if (!ligne2.equals(other.ligne2))
            return false;

        if (ville == null) {
            if (other.ville != null)
                return false;
        } else if (!ville.equals(other.ville))
            return false;

        return true;
    }

    @Override
    public String toString() {
        return "Adresse [" +
                    "id=" + this.getId() + ", " +
                    "ligne1='" + this.getLigne1() + "', " +
                    "ligne2='" + this.getLigne2() + "', " +
                    "codePostal=" + this.getCodePostal() + ", " +
                    "ville='" + this.getVille() + '\'' +
                ']';
    }



}