import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import tech.dev.dao.ClientJdbcDAO;
import tech.dev.dao.CommandeJdbcDAO;
import tech.dev.modele.Client;
import tech.dev.modele.Commande;

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

        //JDBC
        ClientJdbcDAO dao = context.getBean(ClientJdbcDAO.class);
        //List<Client> clients = dao.findAll();
		List<Client> clients = dao.findAllSimple();
		for (Client client : clients) {
			//LOGGER.info(client.getNom() + " " + client.getPrenom() + " " + client.getAdresse().getVille());
            LOGGER.info(client.toString());
		}


        CommandeJdbcDAO daoCommande = context.getBean(CommandeJdbcDAO.class);
        List<Commande> commandes = daoCommande.findAllByClientId(1L);
        for (Commande c : commandes) {
            LOGGER.info("Montant commande client 1: " + c.getMontant());
        }

        LOGGER.debug("Close Spring ClassPathXmlApplicationContext...");
        context.close();
    }
}
