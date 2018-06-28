package tech.dev.modele;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Factory pour la classe Adresse
 * <p>
 * Date: 28/06/2018
 *
 * @author d.vornicu
 * @version 1.0 $Revision$ $Date$
 */

@Component("adresseBuilder")
public class AdresseFactory {

    private Long id;
    private String ligne1;
    private String ligne2;
    private Integer codePostal;
    private String ville;

    public AdresseFactory() {
    }

    public Adresse createInstance(){
        Adresse a = new Adresse();
        a.setId(id);
        a.setLigne1(ligne1);
        a.setLigne2(ligne2);
        a.setCodePostal(codePostal);
        a.setVille(ville);
        return a;
    }

    private void init() {
        System.out.println("Ville initialisée par AdresseFactory = " + this.ville);
        if (ville == null) {
            throw new RuntimeException("Init failure");
        }
    }

    // declaration facultative dans IntelliJ du javax.annotation in pom.xml
    @PostConstruct
    public void afterPropertiesSet() throws Exception {
        init();
    }


    public Long getId() {
        return id;
    }

    @Value("2")
    public void setId(Long id) {
        this.id = id;
    }

    public String getLigne1() {
        return ligne1;
    }

    @Value("${adrTest.rue}")
    public void setLigne1(String ligne1) {
        this.ligne1 = ligne1;
    }

    public String getLigne2() {
        return ligne2;
    }

    @Value("${adrTest.complement}")
    public void setLigne2(String ligne2) {
        this.ligne2 = ligne2;
    }

    public Integer getCodePostal() {
        return codePostal;
    }

    @Value("${villeTest.codePostal}")
    public void setCodePostal(Integer codePostal) {
        this.codePostal = codePostal;
    }

    public String getVille() {
        return ville;
    }

    @Value("${villeTest.nom}")
    public void setVille(String ville) {
        this.ville = ville;
    }
}
