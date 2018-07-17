package tech.dev.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import tech.dev.modele.Adresse;

import javax.sql.DataSource;
import java.util.List;

/**
 * Description de la classe
 * <p>
 * Date: 17/07/2018
 *
 * @author d.vornicu
 * @version 1.0 $Revision$ $Date$
 */

@Repository("adresseDAO")
public class AdresseJdbcDAO extends AbstractJdbcDAO{

    private DataSource dataSource;

    private JdbcTemplate jdbcTemplate ;

/*    @Autowired
    public AdresseJdbcDAO(@Qualifier("datasource") DataSource ds) {
        this.dataSource = ds;
    }*/

    @Autowired
    public AdresseJdbcDAO(JdbcTemplate jdbcTemplate) {
        super(jdbcTemplate);
    }


    public List<Adresse> findAll(){
        //jdbcTemplate = new JdbcTemplate(dataSource);
        return null;
        //
/*        List<Adresse> adresses = jdbcTemplate.query(
                "select c.id, c.nom, c.prenom, a.ville from adresse c left join adresse a on c.adresse_id = a.id",
                new RowMapper<Client>() {
                    public Client mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Client client = new Client();
                        Adresse adresse = new Adresse();
                        adresse.setVille(rs.getString("ville"));
                        client.setNom(rs.getString("nom"));
                        client.setPrenom(rs.getString("prenom"));
                        client.setAdresse(adresse);
                        return client;
                    }
                });
        return clients;    */
    }

    public void deleteById(Long id){
        //String deleteSql = "delete from ADRESSE WHERE id = ?";

        // define query arguments
        //Object[] params = { id };
        // define SQL types of the arguments
        //int[] types = {Types.BIGINT};
        //jdbcTemplate.update(deleteSql, params, types);

        //this.jdbcTemplate.update("DELETE FROM ADRESSE WHERE ID = ?", id);
        //if (true) throw new NullPointerException();
        this.jdbcTemplate.update("DELETE FROM ADRESSE WHERE ID = ?", id);
    }

}
