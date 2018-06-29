import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import tech.dev.modele.Client;

/**
 * Classe de configuration Java Config
 * <p>
 * Date: 28/06/2018
 *
 * @author d.vornicu
 * @version 1.0 $Revision$ $Date$
 */

@Configuration
@ComponentScan(basePackages = "tech.dev.modele")
@PropertySource("classpath:villes.properties")
@EnableAsync
@EnableScheduling
//@EnableTransactionManagement
public class AppConfig {

    @Bean("c1")
    //@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public Client c1() {
        // instantiate, configure and return bean ...
        Client c = new Client();
        c.setNom("Vornicu");
        c.setPrenom("Daniel");
        //l'adresse est injecte dans la classe Client: SetAdresse avec @Autowired @Qualifier("adressePrincipaleAnnotation")
        return c;
    }

    @Bean("c2")
    //@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public Client c2() {
        // instantiate, configure and return bean ...
        Client c = new Client();
        c.setNom("Vornicu");
        c.setPrenom("Alina");
        //l'adresse est injecte dans la classe Client: SetAdresse avec @Autowired @Qualifier("adressePrincipaleAnnotation")
        return c;
    }

    @Bean("c3")
    //@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public Client c3() {
        // instantiate, configure and return bean ...
        Client c = new Client();
        c.setNom("Vornicu");
        c.setPrenom("Luca");
        //l'adresse est injecte dans la classe Client: SetAdresse avec @Autowired @Qualifier("adressePrincipaleAnnotation")
        return c;
    }

    @Bean("c4")
    //@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public Client c4() {
        // instantiate, configure and return bean ...
        Client c = new Client();
        c.setNom("Vornicu");
        c.setPrenom("Sofia");
        //l'adresse est injecte dans la classe Client: SetAdresse avec @Autowired @Qualifier("adressePrincipaleAnnotation")
        return c;
    }
}
