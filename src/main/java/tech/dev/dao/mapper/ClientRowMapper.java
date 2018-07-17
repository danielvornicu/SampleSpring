package tech.dev.dao.mapper;

import org.springframework.jdbc.core.RowMapper;
import tech.dev.modele.Client;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Description de la classe
 * <p>
 * Date: 17/07/2018
 *
 * @author d.vornicu
 * @version 1.0 $Revision$ $Date$
 */



public class ClientRowMapper implements RowMapper<Client> {

    @Override
    public Client mapRow(ResultSet rs, int i) throws SQLException {
        Client client = new Client();
        client.setId(rs.getLong("id"));
        client.setNom(rs.getString("nom"));
        client.setPrenom(rs.getString("prenom"));
        return client;
    }
}
