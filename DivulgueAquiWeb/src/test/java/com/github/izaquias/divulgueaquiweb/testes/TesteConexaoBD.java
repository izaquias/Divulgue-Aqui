
package com.github.izaquias.divulgueaquiweb.testes;


import com.github.izaquias.divulgueaquiweb.hibernate.HibernateUtil;
import com.github.izaquias.divulgueaquiweb.model.Pessoa;
import com.github.izaquias.divulgueaquiweb.model.Problema;
import com.github.izaquias.divulgueaquiweb.model.Usuario;
import java.time.LocalDate;
import javax.persistence.EntityManager;

/**
 *
 * @author Izaquias
 */
public class TesteConexaoBD {
    
    static EntityManager manager;
    
     public static void main(String[] horaDoShow){
        
    
        manager = HibernateUtil.getInstance().getFactory().createEntityManager();
    
        Usuario u = new Usuario();
        
        Problema pb = new Problema();
        
        Pessoa p = new Pessoa();
        //Ao inserir, altere os valores para não ficar com valores repetidos  no BD! 
        

        p.setNome("ana");
        p.setEndereco("Belo Horizonte");
        
        u.setNome("kratos");
        u.setEmail("kratos@gmail.com");
        u.setSenha("kratos35");
        u.setIdade(35);
       
        pb.setCategoria("Serviços Comunitários");
        pb.setDescricao("Falta de maior frequência de recolhimento do lixo urbano.");
        pb.setLocalidade("Rua Boa Vista");
        LocalDate hoje = LocalDate.now();
        pb.setData(hoje);
        //pb.getUsuario().add(u);
        
        
        
        manager.getTransaction().begin();
        manager.persist(p);
        //manager.persist(u);
        
        //manager.persist(pb);        
        manager.getTransaction().commit();
        manager.close();
       
        
    }
    
}
