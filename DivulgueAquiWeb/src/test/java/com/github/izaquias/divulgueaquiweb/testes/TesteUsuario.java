
package com.github.izaquias.divulgueaquiweb.testes;

import com.github.izaquias.divulgueaquiweb.excecoes.UsuarioMenorDeIdadeException;
import com.github.izaquias.divulgueaquiweb.model.Usuario;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 *
 * @author Izaquias
 */
public class TesteUsuario {
    
    @Rule
    public ExpectedException excecao = ExpectedException.none();
    
    @Test
    public void naoPermitirCriarUsuarioNomeNulo(){
        excecao.expect(IllegalArgumentException.class);
        new Usuario(null, "izaquias@gmail.com", "izaquais20", 21);
        
    }
    
    @Test
    public void naoPermitirCriarUsuarioNomeVazio(){
        excecao.expect(IllegalArgumentException.class);
        new Usuario("", "izaquias@gmail.com", "izaquais20", 21);
        
    }
    
    @Test
    public void naoPermitirCriarUsuarioEmailNulo(){
        excecao.expect(IllegalArgumentException.class);
        new Usuario("izaquias", null, "izaquias21", 21);
    }
    
    @Test
    public void naoPermitirCriarUsuarioEmailVazio(){
        excecao.expect(IllegalArgumentException.class);
        new Usuario("izaquias", "", "izaquias21", 21);
    } 
    
    @Test
    public void naoPermitirCriarUsuarioSenhaNula(){
        excecao.expect(IllegalArgumentException.class);
        new Usuario("izaquias", "izaquias@gmail.com", null, 21);
    }
    
    @Test
    public void naoPermitirCriarUsuarioSenhaVazia(){
        excecao.expect(IllegalArgumentException.class);
        new Usuario("izaquias", "izaquias@gmail.com", "", 21);
    }
    @Ignore
    @Test
    public void naoPermitirCriarUsuarioMenorDeIdade(){
        excecao.expect(UsuarioMenorDeIdadeException.class);
        new Usuario("izaquias", "izaquias@gmail.com", "izaquias21", 17);
    }
}
