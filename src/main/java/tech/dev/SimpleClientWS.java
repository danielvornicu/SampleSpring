package tech.dev;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tech.dev.web.jaxws.sei.ClientWebServ;
import tech.dev.web.jaxws.sei.ClientWebService;

/**
 * Description de la classe
 * <p>
 * Date: 18/12/2018
 *
 * @author d.vornicu
 * @version 1.0 $Revision$ $Date$
 */

public class SimpleClientWS {
    private static Logger LOGGER = LoggerFactory.getLogger(SimpleClientWS.class);

    public static void main(String[] args) throws Exception {

        LOGGER.debug("Client for SOAP Web Service ready");

        //Instantiate the web service client object
        ClientWebService service = new ClientWebService() ;
        //Get the web service proxy or port from the web service client factory. This port is nothing but the stub for the web service created.
        ClientWebServ servicePort = service.getClientWebServicePort();

      //  List<ClientTO> clients = servicePort.fetchClients() ;

    //    LOGGER.debug("Liste des clients :");
    //    for (ClientTO client : clients) {
    //        LOGGER.debug(client.toString());
    //    }

    }
}
