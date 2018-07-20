package tech.dev.dao;

import org.springframework.stereotype.Repository;
import tech.dev.entites.Client;

import javax.persistence.*;
import java.util.List;

/**
 * Description de la classe
 * <p>
 * Date: 19/07/2018
 *
 * @author d.vornicu
 * @version 1.0 $Revision$ $Date$
 */

@Repository
public class ClientJpaDAO {

    @PersistenceContext
    //@PersistenceContext(unitName = "crm-pu")  -- unitName - declaration explicite si on a plusieurs unites de persistance
    EntityManager em;

    public ClientJpaDAO() {
        super();
    }

    public List<Client> findAllSansInjection() {
        //version sans injection du EntityManager mais avec les <properties> declarées dans l'inité de persitence "crm-pu" dans persistence.xml
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("crm-pu");
        EntityManager em = emf.createEntityManager();
        return em.createQuery("select c from Client c", Client.class).getResultList();
    }

    public List<Client> findAll() {
        return em.createQuery("select c from Client c left join fetch c.adresse a left join fetch c.commandes", Client.class)
                .getResultList();
    }


    public void deleteByAdreseId(Long adresseId){
        Query query = em.createQuery("DELETE FROM Client c WHERE c.adresse.id = :id");
        query.setParameter("id", adresseId);
        int count = query.executeUpdate();
        System.out.println("Nombre de clients supprimés: "  + count);
    }
}
