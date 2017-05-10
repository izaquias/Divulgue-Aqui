/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WS;

import ModelBeans.BeansUsuario;
import ModelDao.UsuarioDao;
import com.google.gson.Gson;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author ander
 */
@Path("webService")
public class webService {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of GenericResource
     */
    public webService() {
    }

    /**
     * Retrieves representation of an instance of WS.webService
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
       return "meu web service";
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("usuario/insert")
    public String insertUsuario(){
        
        UsuarioDao u = new UsuarioDao();
        BeansUsuario mod = new BeansUsuario();
        
        mod.setNome("marcela");
        mod.setEmail("marcela@marcela.com");
        mod.setSenha("123");
        u.salvar(mod);
        
        Gson g = new Gson();
        return g.toJson(mod);
    }

    /**
     * PUT method for updating or creating an instance of webService
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
