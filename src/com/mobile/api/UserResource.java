package com.mobile.api;

import java.sql.SQLException;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.mobile.api.model.dao.UserDAO;
import com.mobile.api.model.entities.User;
 
 
@Path("/user")
public class UserResource {
 
       @GET
       @Produces(MediaType.APPLICATION_JSON)
       public User getUser(@QueryParam("id") int id) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
             User user = new User();
             user.setLogin("testedaapi");
             user.setSenha("teste");
             return user;
       }
       
       @POST
       @Consumes(MediaType.APPLICATION_JSON)
       @Produces(MediaType.APPLICATION_JSON)
       public Response postUser(User u) {
           	UserDAO uDAO = new UserDAO();
	        try {
				u = uDAO.buscaLogin(u);	
				if (u != null) {
					return Response.status(200).entity(u).build();
				}
			} catch (SQLException e) {			
				e.printStackTrace();
			}
	        return Response.status(404).entity(u).build();
       }
       
       @POST
       @Path("/new")
       @Consumes(MediaType.APPLICATION_JSON)
       @Produces(MediaType.APPLICATION_JSON)
       public Response newUser(User u) {
           	UserDAO uDAO = new UserDAO();	 
           	try {
				User uVerify = uDAO.buscaByLogin(u.getLogin());
				if (uVerify == null) {
					u = uDAO.inserir(u);					
			        return Response.status(200).entity(u).build();
				}
				u.setId(0);
				return Response.status(404).entity(u).build();
				
           	} catch (SQLException e) {
				e.printStackTrace();
			}
           						
	        return Response.status(200).entity(u).build();
       }

}
