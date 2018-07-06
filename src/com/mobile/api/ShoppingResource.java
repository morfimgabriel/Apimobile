package com.mobile.api;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.mobile.api.model.dao.ShoppingDAO;
import com.mobile.api.model.entities.Shopping;

@Path("/shopping")
public class ShoppingResource {
	
	@GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getShoppings() {
		ShoppingDAO sDAO = new ShoppingDAO();
        try {
        	List<Shopping> shoppings = sDAO.buscarShoppings();	
        	return Response.status(200).entity(shoppings).build();
        } catch (Exception e) {			
			e.printStackTrace();
		}
        return Response.status(404).build();
    }
}
