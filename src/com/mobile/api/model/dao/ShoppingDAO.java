package com.mobile.api.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mobile.api.model.entities.Shopping;

public class ShoppingDAO {

	public List<Shopping> buscarShoppings() {
		String sql = null;
        PreparedStatement stm = null;

        sql = "SELECT * FROM shopping";
        ArrayList<Shopping> shoppings = new ArrayList<Shopping>();
        try {
			stm = ConnectionFactory.getConnection().prepareStatement(sql);
			ResultSet rs = stm.executeQuery();	        
	        while(rs.next()){
	            Shopping s = new Shopping();
	            s.setId(rs.getInt("id"));
	            s.setNome(rs.getString("nome"));
	            s.setEndereco(rs.getString("endereco"));
	            s.setRating(rs.getDouble("rating"));
	            
	            shoppings.add(s);
	        }
        } catch (SQLException e) {
			e.printStackTrace();
		}

        return shoppings;
	}

}
