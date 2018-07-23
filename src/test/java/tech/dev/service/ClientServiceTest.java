package tech.dev.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertNotNull;


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
@Transactional
public class ClientServiceTest {

    @Autowired
    ClientService clientService;

    @Test
    public void hello() {
        assertNotNull(clientService);
    }

    @Test(expected = AuthenticationCredentialsNotFoundException.class)
    public void testDeleteUser(){
        clientService.deleteClientByAdresseId(1L);
    }
}
