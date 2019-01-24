package tech.dev.web.jaxws;

import org.springframework.beans.factory.annotation.Autowired;
import tech.dev.service.ClientService;
import tech.dev.to.ClientTO;

import javax.jws.WebService;
import java.util.List;

/**
 * JAX-RS Web Service
 * <p>
 * Date: 13/12/2018
 *
 * @author d.vornicu
 * @version 1.0 $Revision$ $Date$
 */

@WebService
public class ClientWS{

    private ClientService clientService;

    @Autowired
    public void setClientService(ClientService clientService) {
        this.clientService = clientService;
    }

    public List<ClientTO> index() {
        //2.liste des TO
        List<ClientTO> clients = clientService.findAllFillTO();
        return clients;
    }
}
