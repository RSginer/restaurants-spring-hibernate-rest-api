/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rsginer.spring.dao;

import com.rsginer.exceptions.BussinessException;
import com.rsginer.spring.model.Restaurante;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

/**
 *
 * @author Rubén
 */
public class RestaurantesDAOImplJDBC implements RestaurantesDAO {

    private Connection con;

    private Connection getConnection() {
        try {
            InitialContext initCtx = new InitialContext();
            Context envCtx = (Context) initCtx.lookup("java:comp/env");
            DataSource dataSource = (DataSource) envCtx.lookup("jdbc/webapp");
            return dataSource.getConnection();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void insert(Restaurante restaurante) throws BussinessException {
        try {
            String sql = "INSERT INTO restaurantes VALUES(?,?,?,?,?,?)";
            PreparedStatement ps = this.con.prepareStatement(sql);
            ps.setInt(1, restaurante.getId());
            ps.setString(2, restaurante.getNombre());
            ps.setString(3, restaurante.getDireccion());
            ps.setString(4, restaurante.getDescripcion());
            ps.setString(5, restaurante.getImagen());
            ps.setString(6, restaurante.getPrecio());
            ps.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                }
            }
        }
    }

    @Override
    public void update(int idRestaurante, Restaurante restaurante) throws BussinessException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Restaurante get(int idRestaurante) throws BussinessException {
        try {
            String sql = "SELECT * FROM restaurantes WHERE id = ?";
            PreparedStatement ps = this.con.prepareStatement(sql);
            ps.setInt(1, idRestaurante);
            ResultSet res = ps.executeQuery();
            if (res.next()) {
                return createRestaurante(res);
            } else {
                return null;
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                }
            }
        }
    }

    @Override
    public void delete(int idRestaurante) throws BussinessException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Restaurante> findAll() throws BussinessException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private Restaurante createRestaurante(ResultSet res) {
        try {
            Restaurante restaurante = new Restaurante();
            restaurante.setId(res.getInt("id"));
            restaurante.setNombre(res.getString("nombre"));
            restaurante.setDireccion(res.getString("direccion"));
            restaurante.setDescripcion(res.getString("descripcion"));
            restaurante.setImagen(res.getString("imagen"));
            restaurante.setPrecio(res.getString("precio"));
            return restaurante;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }

    }

}
