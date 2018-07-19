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
                "select c.id, c.nom, c.prenom, a.id as adresse_id, a.ligne1, a.ligne2, a.code_postal, a.ville from client c left join adresse a on c.adresse_id = a.id",
                new RowMapper<Client>() {
                    public Client mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Client client = new Client();
                        Adresse adresse = new Adresse();
                        adresse.setId(rs.getLong("adresse_id"));
                        adresse.setLigne1(rs.getString("ligne1"));
                        adresse.setLigne2(rs.getString("ligne2"));
                        adresse.setCodePostal(rs.getInt("code_postal"));
                        adresse.setVille(rs.getString("ville"));
                        //
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
        return jdbcTemplate.query("select c.id, c.nom, c.prenom, a.id as adresse_id, a.ligne1, a.ligne2, a.code_postal, a.ville from client c left join adresse a on c.adresse_id = a.id", new ClientRowMapper());
    }

    public List<Client> findAllJava8(){
        jdbcTemplate = new JdbcTemplate(dataSource);
        //java 8
        return  jdbcTemplate.query("select c.id, c.nom, c.prenom, a.id as adresse_id, a.ligne1, a.ligne2, a.code_postal, a.ville from client c left join adresse a on c.adresse_id = a.id",
                (rs, rownum) ->
                {
                    Client client = new Client();
                    Adresse adresse = new Adresse();
                    adresse.setId(rs.getLong("adresse_id"));
                    adresse.setLigne1(rs.getString("ligne1"));
                    adresse.setLigne2(rs.getString("ligne2"));
                    adresse.setCodePostal(rs.getInt("code_postal"));
                    adresse.setVille(rs.getString("ville"));
                    //
                    client.setId(rs.getLong("id"));
                    client.setNom(rs.getString("nom"));
                    client.setPrenom(rs.getString("prenom"));
                    client.setAdresse(adresse);
                    return client;
                }
        );
    }

}
