
package com.github.izaquias.divulgueaquiweb.model;

import com.github.izaquias.divulgueaquiweb.excecoes.UsuarioMenorDeIdadeException;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Izaquias
 */
@Entity
public class Usuario implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)//add 50+ 
    private long id;
    @Column(length = 50, nullable = false)
    private String nome;
    @Column(length = 50, nullable = false)
    private String email;
    @Column(length = 50, nullable = false)
    private String senha;
    @Column(length = 3, nullable = false)
    private int idade;

    public Usuario() {
    }

    
    public Usuario( String nome, String email, String senha, int idade) {
        if(nome == null || nome.isEmpty()){
            throw new IllegalArgumentException("O nome do Usuário deve ser informado corretamente!");
        }
        if(email == null || email.isEmpty()){
            throw new IllegalArgumentException("O email do Usuário deve ser preenchido corretamente!");
        }
        if(senha == null || senha.isEmpty()){
            throw new IllegalArgumentException("A senha do usuário deve ser informada corretamente!");
        }
        if(idade < 18){
            throw new UsuarioMenorDeIdadeException();
        }
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.idade = idade;
    }

    public long getId() {
        return id;
    }

   

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
    
}
