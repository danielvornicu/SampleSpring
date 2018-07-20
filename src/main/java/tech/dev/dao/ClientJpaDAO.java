package tech.dev.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
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
@CacheConfig
public class ClientJpaDAO {

    @PersistenceContext
    //@PersistenceContext(unitName = "crm-pu")  -- unitName - declaration explicite si on a plusieurs unites de persistance
    EntityManager em;

    private static Logger LOGGER = LoggerFactory.getLogger(ClientJpaDAO.class);

    public ClientJpaDAO() {
        super();
    }

    public List<Client> findAllSansInjection() {
        //version sans injection du EntityManager mais avec les <properties> declarées dans l'inité de persitence "crm-pu" dans persistence.xml
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("crm-pu");
        EntityManager em = emf.createEntityManager();
        return em.createQuery("select c from Client c", Client.class).getResultList();
    }


    public void deleteByAdreseId(Long adresseId){
        Query query = em.createQuery("DELETE FROM Client c WHERE c.adresse.id = :id");
        query.setParameter("id", adresseId);
        int count = query.executeUpdate();
        //System.out.println("Nombre de clients supprimés: "  + count);
        LOGGER.debug("Nombre de clients supprimés: "  + count);
    }

    @Cacheable(cacheNames = {"clients"})
    public List<Client> findAll() {
        LOGGER.debug("Running findAll");
        return em.createQuery("select c from Client c left join fetch c.adresse a left join fetch c.commandes", Client.class)
                .getResultList();
    }

    @Cacheable(cacheNames = {"client"})
    public Client findById(Long id) {
        LOGGER.debug("Running findById avec id = " + id);
        Client c = em.find(Client.class, id);
        //
        //c.getAdresse();
        //c.getCommandes().size();
        return c;
    }
}
