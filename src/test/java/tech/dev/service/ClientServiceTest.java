package tech.dev.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.test.context.support.WithAnonymousUser;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;


/**
 * Description de la classe
 * <p>
 * Date: 20/07/2018
 *
 * @author d.vornicu
 * @version 1.0 $Revision$ $Date$
 */

@ContextConfiguration("classpath:test-applicationContext.xml")
@RunWith(SpringRunner.class)
// Dans une classe de test, permet d'exécuter chaque cas de test dans un contexte transactionnel isolé
// Après chaque cas de test Spring se charge de faire un rollback
@Transactional
public class ClientServiceTest {

    @Autowired
    ClientService clientService;

    @Test
    public void injection_clientService() {
        assertNotNull(clientService);
    }

    //@Test(expected = AuthenticationCredentialsNotFoundException.class)
    public void no_authenticated_user_should_not_run_clientService(){
        clientService.deleteClientByAdresseId(1L);
    }

    @Test
    @WithUserDetails("eric")
    public void user_eric_should_run_clientService() {
        clientService.deleteClientByAdresseId(1L);
        // en toute rigueur, je devrais tester en exécutant une requête SQL et non
        // réutiliser mon service / dao. Le problème est qu'avec JPA il faut s'assurer
        // que les ordres SQL ont été envoyés à la base pour pouvoir disposer d'un état
        // cohérent
        //assertNull(clientService.findClientsByAdresseId(1L));
        assertTrue(clientService.findClientsByAdresseId(1L).isEmpty());
    }

    @Test(expected = AccessDeniedException.class)
    @WithMockUser(username = "other", authorities = { "ROLE_USER" })
    public void user_with_user_role_should_not_run_clientService() {
        clientService.deleteClientByAdresseId(1L);
    }

    @Test(expected = AccessDeniedException.class)
    @WithAnonymousUser
    public void anonymous_user_should_not_run_clientService() {
        clientService.deleteClientByAdresseId(1L);
    }
}
