package tech.dev;

import org.eclipse.jetty.server.Server;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import tech.dev.web.jaxws.ClientWS;
import tech.dev.web.jaxws.TestWS;

import javax.xml.ws.Endpoint;

/**
 * Description de la classe
 * <p>
 * Date: 13/12/2018
 *
 * @author d.vornicu
 * @version 1.0 $Revision$ $Date$
 */

public class WSApplication {
    private static Logger LOGGER = LoggerFactory.getLogger(WebApplication.class);

/*    @Bean
    public ClientWS clientWS() {
        return new ClientWS();
    }*/

    public static void main(String[] args) throws Exception {
        Server server = new Server(8090);

        //make sure JAX-WS endpoint.publish will use our new service provider
        System.setProperty("com.sun.net.httpserver.HttpServerProvider",
                "org.eclipse.jetty.http.spi.JettyHttpServerProvider");

        //add tech.dev.web.jaxws in applicationContext.xml to scan ClientWS
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        ClientWS clientWS = context.getBean(ClientWS.class);

        //1. Standalone deployment or 2 Deployment on to a servlet-container
        //1.
        //Endpoint.publish("http://localhost:1234" + "/crm/jaxws/ClientWebService", new ClientWS());
        Endpoint.publish("http://localhost:1234" + "/crm/jaxws/ClientWebService", clientWS);

        //using another port il works
        Endpoint.publish("http://localhost:1111" + "/crm/jaxws/TestWebService", new TestWS());

        // start server
        server.start();
        LOGGER.debug("SOAP Web Service application ready(Standalone deployment only) ");
        server.join();

        //Pour 2 Deployment on to a servlet-container il faut lancer WebApplication

    }
}
