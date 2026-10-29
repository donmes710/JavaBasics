
package com.example.quickrelief;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SupplyRepository {

    private final JdbcTemplate jdbcTemplate;

    public SupplyRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private final RowMapper<Supply> supplyRowMapper = (rs, rowNum) ->
            new Supply(
                    rs.getLong("id"),
                    rs.getString("item_name"),
                    rs.getInt("quantity")
            );

    public List<Supply> findAll() {
        String sql =
                "SELECT id, item_name, quantity FROM supplies ORDER BY id";

        return jdbcTemplate.query(sql, supplyRowMapper);
    }

    public Supply findByItemName(String itemName) {
        String sql = """
                SELECT id, item_name, quantity
                FROM supplies
                WHERE item_name = ?
                """;

        List<Supply> supplies =
                jdbcTemplate.query(sql, supplyRowMapper, itemName);

        return supplies.isEmpty() ? null : supplies.get(0);
    }

    public Supply findByItemNameForUpdate(String itemName) {
        String sql = """
                SELECT id, item_name, quantity
                FROM supplies
                WHERE item_name = ?
                FOR UPDATE
                """;

        List<Supply> supplies =
                jdbcTemplate.query(sql, supplyRowMapper, itemName);

        return supplies.isEmpty() ? null : supplies.get(0);
    }

    public void insert(String itemName, int quantity) {
        String sql = """
                INSERT INTO supplies (item_name, quantity)
                VALUES (?, ?)
                """;

        jdbcTemplate.update(sql, itemName, quantity);
    }

    public void updateQuantity(String itemName, int quantity) {
        String sql = """
                UPDATE supplies
                SET quantity = ?
                WHERE item_name = ?
                """;

        jdbcTemplate.update(sql, quantity, itemName);
    }

    public int deductQuantity(String itemName, int quantity) {
        String sql = """
                UPDATE supplies
                SET quantity = quantity - ?
                WHERE item_name = ?
                  AND quantity >= ?
                """;

        return jdbcTemplate.update(
                sql, quantity, itemName, quantity
        );
    }
}
