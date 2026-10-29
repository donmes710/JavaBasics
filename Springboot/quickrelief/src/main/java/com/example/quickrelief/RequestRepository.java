
package com.example.quickrelief;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;

@Repository
public class RequestRepository {

    private final JdbcTemplate jdbcTemplate;

    public RequestRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public SupplyRequest save(
            String itemName,
            int quantity,
            String status,
            String requestedBy
    ) {
        String sql = """
                INSERT INTO requests
                    (item_name, quantity, status, requested_by)
                VALUES (?, ?, ?, ?)
                """;

        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(
                    sql, Statement.RETURN_GENERATED_KEYS
            );

            ps.setString(1, itemName);
            ps.setInt(2, quantity);
            ps.setString(3, status);
            ps.setString(4, requestedBy);

            return ps;
        }, keyHolder);

        Number key = keyHolder.getKey();

        if (key == null) {
            throw new IllegalStateException(
                    "Could not retrieve generated request ID"
            );
        }

        return new SupplyRequest(
                key.longValue(),
                itemName,
                quantity,
                status,
                requestedBy
        );
    }
}
