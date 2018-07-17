package tech.dev.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import tech.dev.dao.mapper.ClientRowMapper;
import tech.dev.modele.Adresse;
import tech.dev.modele.Client;

import javax.sql.DataSource;
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

@Repository("clientDAO")
public class ClientJdbcDAO {

    private DataSource dataSource;

    private JdbcTemplate jdbcTemplate ;

    public DataSource getDataSource() {
        return dataSource;
    }

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<Client> findAll(){
        jdbcTemplate = new JdbcTemplate(dataSource);
        //
        List<Client> clients = jdbcTemplate.query(
                "select c.id, c.nom, c.prenom, a.ville from client c left join adresse a on c.adresse_id = a.id",
                new RowMapper<Client>() {
                    public Client mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Client client = new Client();
                        Adresse adresse = new Adresse();
                        adresse.setVille(rs.getString("ville"));
                        client.setId(rs.getLong("id"));
                        client.setNom(rs.getString("nom"));
                        client.setPrenom(rs.getString("prenom"));
                        client.setAdresse(adresse);
                        return client;
                    }
                });
        return clients;
    }

    public List<Client> findAllSimple(){
        jdbcTemplate = new JdbcTemplate(dataSource);
        // on déclare le Mapper à part plutôt que d'en faire une classe anonyme
        return jdbcTemplate.query("select * from client", new ClientRowMapper());
    }

    public List<Client> findAllJava8(){
        jdbcTemplate = new JdbcTemplate(dataSource);
        //java 8
        return  jdbcTemplate.query("select * from client",
                (rs, rownum) ->
                {
                    Client c = new Client();
                    c.setId(rs.getLong("ID"));
                    c.setNom(rs.getString("nom"));
                    c.setNom(rs.getString("prenom"));
                    return c;
                }
        );
    }

}
