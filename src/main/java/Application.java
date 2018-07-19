import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import tech.dev.dao.ClientJpaDAO;
import tech.dev.entites.Client;

import java.util.List;

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

        //on charge le context via AnnotationConfigApplicationContext
        LOGGER.debug("Init Spring ClassPathXmlApplicationContext...");

        AbstractApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        //JPA
        ClientJpaDAO dao = context.getBean(ClientJpaDAO.class);
		List<Client> clients = dao.findAll();
		for (Client client : clients) {
            LOGGER.info(client.toString());
		}

        LOGGER.debug("Close Spring ClassPathXmlApplicationContext...");
        context.close();
    }
}
