package com.emergentes.dao;

import com.emergentes.modelo.Internet;
import com.emergentes.utiles.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InternetDAOimpl extends ConexionDB implements InternetDAO {

    @Override
    public void insert(Internet internet) throws Exception {
        String sql = "insert into registro (nombre, apellido, seminario, confirmado, fecha) values (?,?,?,?,?)";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setString(1, internet.getNombre());
        ps.setString(2, internet.getApellido());
        ps.setString(3, internet.getSeminario());
        ps.setBoolean(4, internet.isConfirmado());
        ps.setString(5, internet.getFecha());
        ps.executeUpdate();
        this.desconectar();
    }

    @Override
    public void update(Internet internet) throws Exception {
        String sql = "update registro set nombre=?, apellido=?, seminario=?, confirmado=?, fecha=? where id = ?";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setString(1, internet.getNombre());
        ps.setString(2, internet.getApellido());
        ps.setString(3, internet.getSeminario());
        ps.setBoolean(4, internet.isConfirmado());
        ps.setString(5, internet.getFecha());
        ps.setInt(6, internet.getId());
        ps.executeUpdate();
        this.desconectar();
    }

    @Override
    public void delete(int id) throws Exception {
        String sql = "delete from registro where id=?";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();
        this.desconectar();
    }

    @Override
    public List<Internet> getAll() throws Exception {
        List<Internet> lista = null;
        String sql = "select * from registro";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        lista = new ArrayList<Internet>();
        while (rs.next()) {
            Internet inter = new Internet();
            inter.setId(rs.getInt("id"));
            inter.setNombre(rs.getString("nombre"));
            inter.setApellido(rs.getString("apellido"));
            inter.setSeminario(rs.getString("seminario"));
            inter.setConfirmado(rs.getBoolean("confirmado"));
            inter.setFecha(rs.getNString("fecha"));

            lista.add(inter);
        }
        this.desconectar();
        return lista;
    }

    @Override
    public Internet getById(int id) throws Exception {
        Internet inter = new Internet();
        try {
            this.conectar();
            String sql = "select * from registro where id = ?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                inter.setId(rs.getInt("id"));
                inter.setNombre(rs.getString("nombre"));
                inter.setApellido(rs.getString("apellido"));
                inter.setSeminario(rs.getString("seminario"));
                inter.setConfirmado(rs.getBoolean("confirmado"));
                inter.setFecha(rs.getNString("fecha"));
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return inter;
    }

}
