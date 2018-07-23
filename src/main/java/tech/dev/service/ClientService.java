package tech.dev.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tech.dev.dao.AdresseJpaDAO;
import tech.dev.dao.ClientJpaDAO;
import tech.dev.entites.Client;

import java.util.List;

/**
 * Description de la classe
 * <p>
 * Date: 19/07/2018
 *
 * @author d.vornicu
 * @version 1.0 $Revision$ $Date$
 */

@Service
@PreAuthorize("hasRole('ROLE_ADMIN')")
public class ClientService {

    //private static Logger LOGGER = LoggerFactory.getLogger(ClientService.class);

    ClientJpaDAO clientDAO;
    AdresseJpaDAO adresseDAO;

    @Autowired
    public ClientService(ClientJpaDAO clientDAO, AdresseJpaDAO adresseDAO) {
        this.clientDAO  = clientDAO;
        this.adresseDAO = adresseDAO;
    }

    @Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NullPointerException.class)
    public void deleteClientByAdresseId(Long id){
        //System.out.println(clientDAO);
        this.clientDAO.deleteByAdreseId(id);
        this.adresseDAO.deleteById(id);
    }

    public List<Client> findAll() {
        return clientDAO.findAll();
    }

    public List<Client> findClientsByAdresseId(Long id){
      return clientDAO.findClientsByAdresseId(id);
    }


    @Transactional(readOnly = true)
    public Client findById(Long id) {
        return clientDAO.findById(id);
    }

}
