package tech.dev;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tech.dev.web.jaxws.sei.ClientTO;
import tech.dev.web.jaxws.sei.ClientWebServ;
import tech.dev.web.jaxws.sei.ClientWebService;

import java.util.List;


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

        //CALL 1 -for Standalone deployment only
        //Instantiate the web service test object

/*        TestWebService testService = new TestWebService() ;
        //port
        TestWebServ testServicePort = testService.getTestWebServicePort();

        String msg = testServicePort.getInfo("2");
        LOGGER.debug("CALL 1 response: " + msg);*/

        //CALL 2 - for Standalone deployment only
        //For servlet-container deployment if mess err 403 “Could not verify the provided CSRF token because your session was not found”
        //add <sec:csrf disabled="true"/> in <sec:http> tag in applicationContext.xml

        //Instantiate the web service client object
        ClientWebService service = new ClientWebService() ;
        //Get the web service proxy or port from the web service client factory. This port is nothing but the stub for the web service created.
        ClientWebServ servicePort = service.getClientWebServicePort();

        List<ClientTO> clients = servicePort.fetchClients();

        LOGGER.debug("CALL 2 response is all clients list: ");
        for (ClientTO client : clients) {
            LOGGER.debug(client.getId()  + ", " + client.getPrenom()  + ", " + client.getNom());
        }

    }
}
