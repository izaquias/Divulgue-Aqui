/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WS;

import ModelBeans.BeansFeedDeNoticia;
import ModelBeans.BeansOrgao;
import ModelBeans.BeansUsuario;
import ModelDao.FeedDeNoticiaDao;
import ModelDao.OrgaoDao;
import ModelDao.UsuarioDao;
import com.google.gson.Gson;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

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
    ///////////////////////////USUARIO///////////////////////////////////
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("usuario/insert")
    public String insertUsuario(String json){
        
        UsuarioDao u = new UsuarioDao();
        BeansUsuario mod = new BeansUsuario();
        
         JSONObject jsonObject;
        JSONParser parser = new JSONParser();  
        
        String nome;
        String email;
        String senha;
	
        
        try {
            jsonObject = (JSONObject) parser.parse(json);
            
            nome = (String) jsonObject.get("nome");
            email = (String)jsonObject.get("email");
            senha = (String) jsonObject.get("senha");
            
            
            mod.setNome(nome);
            mod.setEmail(email);
            mod.setSenha(senha);
            u.salvar(mod);           
           
            
        } catch (ParseException ex) {
            Logger.getLogger(webService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
        
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("usuario/recuperar")
    public String recuperarUsuario(@QueryParam("id") Long json){
        
        UsuarioDao u = new UsuarioDao();
        BeansUsuario mod = new BeansUsuario();
      
        mod.setPesquisarPorId(json);
        mod = u.buscar(mod);
        
        Gson g = new Gson();
        return g.toJson(mod);
    }
    ///////////////////////////ORGAO///////////////////////////////////
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("orgao/inserir")
    public String insertOrgao(String json){
    
        OrgaoDao o = new OrgaoDao();
        BeansOrgao mod = new BeansOrgao();
        
        JSONObject jsonObject;
        JSONParser parser = new JSONParser();  
        
        String nome;
        String senha;
	
        
        try {
            jsonObject = (JSONObject) parser.parse(json);
            
            nome = (String) jsonObject.get("nome");
            senha = (String) jsonObject.get("senha");
            
            
            mod.setNome(nome);
            mod.setSenha(senha);
            o.salvar(mod);           
           
            
        } catch (ParseException ex) {
            Logger.getLogger(webService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
        
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("orgao/recuperar")
    public String recuperarUnico(@QueryParam("id") Long json){
        OrgaoDao o = new OrgaoDao();
        BeansOrgao mod = new BeansOrgao();
        
        mod.setPesquisarId(json);
        mod = o.buscarPorId(mod);
        
        Gson g = new Gson();
        return g.toJson(mod);
    }
    ///////////////////////////FEED///////////////////////////////////
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("feed/insert")
    public String insertFeed(String json){
    
        FeedDeNoticiaDao f = new FeedDeNoticiaDao();
        BeansFeedDeNoticia mod = new BeansFeedDeNoticia();
        
        JSONObject jsonObject;
        JSONParser parser = new JSONParser();  
        
        String localidade;
        String descricao;
        String categoria;
        long idUsuario;
     
        try {
            jsonObject = (JSONObject) parser.parse(json);
            
            localidade = (String) jsonObject.get("localidade");
            descricao = (String) jsonObject.get("descricao");
            categoria = (String) jsonObject.get("categoria");
            idUsuario =  (long) jsonObject.get("idUsuario");
            
            mod.setLocalidade(localidade);
            mod.setData(LocalDateTime.MAX);
            mod.setDescricao(descricao);
            mod.setCategoria(categoria);
            mod.setIdUsuario(idUsuario);
            f.salvar(mod);
   
        } catch (ParseException ex) {
            Logger.getLogger(webService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
        
    }
   
}
