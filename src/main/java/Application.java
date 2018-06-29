import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
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
        //on charge le context via AnnotationConfigApplicationContext
        LOGGER.debug("Init Spring AnnotationConfigApplicationContext...");
        LOGGER.debug("Get beans from AnnotationConfigApplicationContext...");
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

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

        LOGGER.debug("Test si adresse est partagée :");
        System.out.println("Scope pour le bean adresse: " + (c1.getAdresse() == c2.getAdresse() ? "singleton" : "prototype"));

        try {
            Thread.sleep(60000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        LOGGER.debug("Close Spring AnnotationConfigApplicationContext...");
        context.close();
    }
}
