package tech.dev;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import tech.dev.dao.ClientJpaDAO;
import tech.dev.entites.Client;
import tech.dev.service.ClientService;

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

        //Security
        afficherClients(context);

        authenticateUser(context, "dv", "mdp");

        try {
            LOGGER.debug("Tentative de suppression d'un client et son adresse");
            ClientService service = context.getBean(ClientService.class);
            service.deleteClientByAdresseId(1L);
            LOGGER.debug("Client et son adresse supprimés");
        } catch (NullPointerException e) {
            LOGGER.error("Problème lors de la suppression");
        }
        afficherClients(context);

        LOGGER.debug("Close Spring ClassPathXmlApplicationContext...");
        context.close();
    }

    private static void afficherClients(ApplicationContext context) {
        //
        ClientJpaDAO dao = context.getBean(ClientJpaDAO.class);
        LOGGER.debug("Liste des clients :");
        for (Client client : dao.findAll()) {
            LOGGER.debug(client.toString());
        }
    }

    private static void authenticateUser(AbstractApplicationContext context, String username, String password) {
        AuthenticationManager authManager = context.getBean(AuthenticationManager.class);
        UsernamePasswordAuthenticationToken authReq = new UsernamePasswordAuthenticationToken(username, password);
        Authentication auth = authManager.authenticate(authReq);
        SecurityContext sc = SecurityContextHolder.getContext();
        sc.setAuthentication(auth);
    }
}
