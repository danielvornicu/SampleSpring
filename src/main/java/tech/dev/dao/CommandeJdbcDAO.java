package tech.dev.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import tech.dev.modele.Commande;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Description de la classe
 * <p>
 * Date: 17/07/2018
 *
 * @author d.vornicu
 * @version 1.0 $Revision$ $Date$
 */


@Repository
public class CommandeJdbcDAO extends AbstractJdbcDAO{

    //@Autowired on herite l'annotation aussi si on veut
    public CommandeJdbcDAO(JdbcTemplate jdbcTemplate) {
        super(jdbcTemplate);
    }


    public List<Commande> findAllByClientId(Long id){
        return this.jdbcTemplate.query("select * from commande where client_id = ?", new Object[] {id}, new RowMapper<Commande>() {

            @Override
            public Commande mapRow(ResultSet resultSet, int i) throws SQLException {
                Commande c = new Commande();
                c.setMontant(resultSet.getLong("Montant"));
                return c;
            }
        });

    }
}
