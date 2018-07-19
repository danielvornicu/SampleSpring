package tech.dev.dao.mapper;

import org.springframework.jdbc.core.RowMapper;
import tech.dev.modele.Adresse;
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
        Adresse adresse = new Adresse();
        //
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
}
