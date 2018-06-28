import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import tech.dev.modele.Client;

/**
 * La classe principale
 * <p>
 * Date: 25/06/2018
 *
 * @author d.vornicu
 * @version 1.0 $Revision$ $Date$
 */

public class Application {

    private static Logger LOGGER = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        LOGGER.debug("Startup");
        //
        LOGGER.debug("Init Spring context...");
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("spring-applicationContext.xml");
        LOGGER.debug("Get beans from Spring context *.xml file...");
        Client c1 = context.getBean("c1", Client.class);
        Client c2 = context.getBean("c2", Client.class);
        Client c3 = context.getBean("c3", Client.class);
        Client c4 = context.getBean("c4", Client.class);

        LOGGER.debug("Liste des clients :");
        //
        LOGGER.debug(c1.toString());
        LOGGER.debug(c2.toString());
        LOGGER.debug(c3.toString());
        LOGGER.debug(c4.toString());

        LOGGER.debug("Test si adresse est partagé :");
        System.out.println("Scope pour le bean adresse: " + (c1.getAdresse() == c2.getAdresse() ? "singleton" : "prototype"));

        //Client créé avec le ClientFactory
        LOGGER.debug("Client créé avec ClientFactory :");
        Client c5 = context.getBean("c5", Client.class);
        LOGGER.debug(c5.toString());

        LOGGER.debug("Close Spring context...");
        context.close();
    }
}
