package tech.dev.dao;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Description de la classe
 * <p>
 * Date: 17/07/2018
 *
 * @author d.vornicu
 * @version 1.0 $Revision$ $Date$
 */

public abstract class AbstractJdbcDAO {

    protected JdbcTemplate jdbcTemplate ;


    public AbstractJdbcDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
