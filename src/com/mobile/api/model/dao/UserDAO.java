package com.mobile.api.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mobile.api.model.entities.User;
import com.mysql.jdbc.Statement;

public class UserDAO {

    public User buscarUser(int idUser) throws SQLException {

        String sql = null;
        PreparedStatement stm = null;

        sql = "SELECT * FROM user WHERE id = " + idUser;
        stm = ConnectionFactory.getConnection().prepareStatement(sql);
        
        ResultSet rs = stm.executeQuery();
        rs.next();
        User u = new User();
        u.setId(rs.getInt("id"));
        u.setLogin(rs.getString("login"));
        u.setSenha(rs.getString("senha"));

        return u;

    }
    
    public User buscaLogin(User u) throws SQLException {

        String sql = null;
        PreparedStatement stm = null;

        sql = "SELECT * FROM user WHERE login = ? and senha = ?";
        stm = ConnectionFactory.getConnection().prepareStatement(sql);
        stm.setString(1, u.getLogin());
        stm.setString(2, u.getSenha());
        
        ResultSet rs = stm.executeQuery();
        rs.next();
        u.setId(rs.getInt("id"));
        u.setLogin(rs.getString("login"));
        u.setSenha(rs.getString("senha"));

        return u;

    }
    
    public User buscaByLogin(String login) throws SQLException {

        String sql = null;
        PreparedStatement stm = null;

        sql = "SELECT * FROM user WHERE login = ? ";
        stm = ConnectionFactory.getConnection().prepareStatement(sql);
        stm.setString(1, login);
        
        ResultSet rs = stm.executeQuery();
        
        User u = null;
        while(rs.next()) {
        	u = new User();
            u.setId(rs.getInt("id"));
            u.setLogin(rs.getString("login"));
            u.setSenha(rs.getString("senha"));
        }

        return u;

    }
    
    public User inserir(User u) {
		String sql = null;
        PreparedStatement stm = null;

        sql = "INSERT INTO user (login, senha) VALUES (?, ?)";
        try {
			stm = ConnectionFactory.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stm.setString(1, u.getLogin());
			stm.setString(2, u.getSenha());
			stm.executeUpdate();	
			
			ResultSet rs = stm.getGeneratedKeys();
			rs.next();
			u.setId(rs.getInt(1));			
		} catch (SQLException e) { 
			e.printStackTrace();
		}        
        
        return u;
	}
}

