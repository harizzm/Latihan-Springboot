/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tabeldata.buku.dao;

import com.tabeldata.buku.entity.Buku;
import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Aktivisual
 */
@Repository
public class BukuDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Buku findById(String id) {
        String query = "select id, kode, judul, NamaPengarang, TahunTerbit, harga, qty from buku where id=?";
        Buku buku = jdbcTemplate.queryForObject(query, new RowMapper<Buku>() {
            @Override
            public Buku mapRow(ResultSet rs, int i) throws SQLException {
                return new Buku(
                        rs.getString("id"),
                        rs.getString("kode"),
                        rs.getString("judul"),
                        rs.getString("NamaPengarang"),
                        rs.getInt("TahunTerbit"),
                        rs.getBigDecimal("harga"),
                        rs.getInt("qty"));
            }
        }, id);
        return buku;
    }

    public List<Buku> findAll() {
        String query = "select id, kode, judul, NamaPengarang, TahunTerbit, harga, qty from buku";
        List<Buku> list = jdbcTemplate.query(query, new RowMapper<Buku>() {
            @Override
            public Buku mapRow(ResultSet rs, int i) throws SQLException {
                return new Buku(
                        rs.getString("id"),
                        rs.getString("kode"),
                        rs.getString("judul"),
                        rs.getString("NamaPengarang"),
                        rs.getInt("TahunTerbit"),
                        rs.getBigDecimal("harga"),
                        rs.getInt("qty")
                );
            }
        });
        return list;
    }
    
    public Buku save(Buku buku){
        String query = "insert into buku(id, kode, judul, NamaPengarang, TahunTerbit, harga, qty) values(?,?,?,?,?,?,?)";
        String PrimaryKey = UUID.randomUUID().toString();
        this.jdbcTemplate.update(query, new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setString(1, PrimaryKey);
                ps.setString(2, buku.getKode());
                ps.setString(3, buku.getJudul());
                ps.setString(4, buku.getNamapengarang());
                ps.setInt(5, buku.getTahunterbit());
                ps.setBigDecimal(6, buku.getHarga());
                ps.setInt(7, buku.getQty());
                
            }
        });
        buku.setId(PrimaryKey);
        return buku;
    }
    
    public Buku update(Buku buku){
        String query = "update buku set kode=?, judul=?, NamaPengarang=?, TahunTerbit=?, harga=?, qty=? where id=?";
        this.jdbcTemplate.update(query, new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setString(1, buku.getKode());
                ps.setString(2, buku.getJudul());
                ps.setString(3, buku.getNamapengarang());
                ps.setInt(4, buku.getTahunterbit());
                ps.setBigDecimal(5, buku.getHarga());
                ps.setInt(6, buku.getQty());
                ps.setString(7, buku.getId());
                
            }
        });
        return buku;
    }
    
    public void delete(String id){
        String query = "delete from buku where id=?";
        this.jdbcTemplate.update(query, new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setString(1, id);
            }
        });
         
    }
}
